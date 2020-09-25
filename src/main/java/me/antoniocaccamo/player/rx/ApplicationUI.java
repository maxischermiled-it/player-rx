package me.antoniocaccamo.player.rx;

import com.diffplug.common.swt.*;
import com.diffplug.common.swt.jface.Actions;
import com.diffplug.common.swt.jface.ImageDescriptors;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Value;
import io.micronaut.runtime.event.annotation.EventListener;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;
import me.antoniocaccamo.player.rx.config.Constants;
import me.antoniocaccamo.player.rx.event.application.ApplicationEvent;
import me.antoniocaccamo.player.rx.event.application.StartApplicationEvent;
import me.antoniocaccamo.player.rx.helper.InitHelper;
import me.antoniocaccamo.player.rx.helper.LocaleHelper;
import me.antoniocaccamo.player.rx.helper.SWTHelper;
import me.antoniocaccamo.player.rx.model.preference.Preference;
import me.antoniocaccamo.player.rx.model.preference.Screen;
import me.antoniocaccamo.player.rx.model.preference.ScreenLocation;
import me.antoniocaccamo.player.rx.model.preference.ScreenSize;
import me.antoniocaccamo.player.rx.service.PreferenceService;
import me.antoniocaccamo.player.rx.ui.LibraryUI;
import me.antoniocaccamo.player.rx.ui.TabItemMonitorUI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

//import picocli.CommandLine;

/**
 * @author antoniocaccamo on 20/02/2020
 */
@Slf4j
@Singleton
public class ApplicationUI {

        public static Image ImageUI;

        @Inject
        private ApplicationContext applicationContext;

        @Value("${micronaut.application.name}")
        @NotNull
        private String appname;

        @Value("${micronaut.server.port}")
        @NotNull
        private int port;

        @Inject
        private PreferenceService preferenceService;

        @Inject
        private InitHelper dbInitHelper;

        private Preference preference;

        private PublishSubject<ApplicationEvent> applicationEventPublishSubject;

        private CTabFolder tabFolder;

        private CoatMux coatMux;

        private AtomicInteger tabFolderIndex;

        private CoatMux.Layer<Composite> tabFolderLayer;

        private CoatMux.Layer<Composite> resourceLibraryLayer;

        // public ApplicationUI(PreferenceService preferenceService, InitHelper
        // dbInitHelper, String appname) {
        // this.preferenceService = preferenceService;
        // this.dbInitHelper = dbInitHelper;
        // this.appname = appname;
        // }

        @EventListener
        public void onApplicationEvent(StartApplicationEvent event) {
                // startup logic here
                Application.CONTEXT = applicationContext;
                Application.SERVER_PORT = port;
                log.info(" show ui");
                show();

        }

        public void show() {

                dbInitHelper.getDefaultSquence();
                preference = preferenceService.read();
                applicationEventPublishSubject = PublishSubject.create();

                log.info("launching swt");

                Shells.builder(SWT.RESIZE | SWT.ICON | SWT.CLOSE, cmp -> {
                        Layouts.setGrid(cmp)
                                .numColumns(1)
                                .columnsEqualWidth(true)
                                .horizontalSpacing(0)
                                .verticalSpacing(0);

                        toolbarManager(cmp);
                        coatMux = new CoatMux(cmp, SWT.NONE);
                        Layouts.setGridData(coatMux).grabAll();

                        tabFolderLayer = coatMux.addCoat(composite -> {
                                Layouts.setGrid(composite).numColumns(1).columnsEqualWidth(true).horizontalSpacing(0)
                                                .verticalSpacing(0);
                                tabFolder = new CTabFolder(composite, SWT.NONE);
                                Layouts.setGrid(tabFolder);
                                Layouts.setGridData(tabFolder).grabAll();
                                return composite;
                        });

                        resourceLibraryLayer = coatMux.addCoat(cmpResLib -> {
                                Layouts.setGrid(cmpResLib).horizontalSpacing(0).verticalSpacing(0);
                                Layouts.setGridData(new LibraryUI(cmpResLib)).grabAll();
                                return cmpResLib;
                        });

                        tabFolderLayer.bringToTop();

                        tabFolderIndex = new AtomicInteger(0);

                        List<TabItemMonitorUI> monitorUIS = preference
                                        .getScreens().stream().map(monitorModel -> new TabItemMonitorUI(tabFolder,monitorModel, tabFolderIndex.incrementAndGet()))
                                        .collect(Collectors.toList());

                        Observable.fromIterable(monitorUIS).subscribeOn(Schedulers.computation()).map(t -> {
                                log.info("getIndex() [{}] - waiting for all stuff..", t.getIndex());
                                try {
                                        t.getScreenUI().getLatch().await();
                                } catch (InterruptedException e) {
                                        log.error("", e);
                                }
                                return t;
                        }).observeOn(SwtExec.async().getRxExecutor().scheduler())
                                        .subscribe(TabItemMonitorUI::applyScreen, Throwable::printStackTrace);

                        /*
                         * Observable.fromArray(tabFolder.getItems()) .map(i -> (TabItemMonitorUI) i)
                         * .subscribe( tabItemMonitorUI -> tabItemMonitorUI.applyMonitorModel() );
                         */

                        SwtRx.addListener(cmp, SWT.Resize, SWT.Move)
                                        .subscribe(event -> log.debug("event : {} | cmp size : {} location : {}", event,
                                                        preference.getSize().fromPoint(cmp.getSize()),
                                                        preference.getLocation().fromPoint(cmp.getLocation())));
                        menuManager((Shell) cmp);
                        try {
                                ApplicationUI.ImageUI = ImageDescriptors.createManagedImage(
                                                SWTHelper.getImage(getClass().getClassLoader()
                                                                .getResourceAsStream("images/logo.jpg")).getImageData(),
                                                cmp);
                                ((Shell) cmp).setImage(ApplicationUI.ImageUI);
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                        SwtRx.addListener(cmp, SWT.Dispose).subscribe(event -> dispose());
                })
                .setTitle(String.format("%s : %s", appname, preference.getComputer()))
                .setSize(preference.getSize().toPoint())
                .setLocation(preference.getLocation().toPoint())
                .openOnDisplayBlocking();
                log.info("shell closed - > preference : {}", preference);
        }

        public void dispose() {

                log.info("disposing ..");
                for (CTabItem item : tabFolder.getItems()) {
                        item.getControl().dispose();
                        item.dispose();
                }
                Application.CONTEXT.stop();
                System.exit(0);

        }

        private void toolbarManager(Composite cmp) {
                ToolBarManager manager = new ToolBarManager();

                final IAction addMonitor = Actions.builder()
                                // .setImage(ImageDescriptors.createManagedImage(SWTHelper.getImage("images/logo.jpg").getImageData(),
                                // cmp).)
                                .setText("Add").setStyle(Actions.Style.PUSH).setListener(event -> {
                                        Screen screen = Screen.builder().defaultScreen(Constants.Screen.DefaultEnum.N)
                                                        .size(ScreenSize.builder().width(Constants.Screen.WIDTH)
                                                                        .height(Constants.Screen.HEIGHT).build())
                                                        .location(ScreenLocation.builder().top(Constants.Screen.TOP)
                                                                        .left(Constants.Screen.LEFT).build())
                                                        .sequence(Constants.Sequence.DefaultSequenceName)
                                                        .timing(Constants.TimingEnum.ALL_DAY).build();
                                        TabItemMonitorUI cTabItem = new TabItemMonitorUI(tabFolder, screen,
                                                        tabFolderIndex.getAndIncrement());
                                        tabFolder.setSelection(cTabItem);
                                        cTabItem.applyScreen();
                                        preference.addScreen(screen);
                                }).build();

                final IAction removeMonitor = Actions.builder()
                                // .setImage(ImageDescriptors.createManagedImage(SWTHelper.getImage("images/logo.jpg").getImageData(),
                                // cmp).)
                                .setText("Remove").setStyle(Actions.Style.PUSH)
                                .setListener(evt -> Observable.fromArray(tabFolder.getItems()).count()
                                                .filter(cnt -> cnt > 1).subscribe(cnt -> {
                                                        TabItemMonitorUI cTabItem = (TabItemMonitorUI) Observable
                                                                        .fromArray(tabFolder.getItems()).blockingLast();
                                                        preference.removeScreen(cTabItem.getScreen());
                                                        cTabItem.dispose();
                                                        tabFolderIndex.decrementAndGet();
                                                }))
                                .build();

                applicationEventPublishSubject.count()
                                .subscribe(cnt -> removeMonitor.setEnabled(Boolean.valueOf(cnt > 1)));

                manager.add(addMonitor);
                manager.add(removeMonitor);
                manager.add(Actions.builder().setListener(event -> tabFolderLayer.bringToTop()).setText("monitors")
                                .build());
                manager.add(Actions.builder().setListener(event -> resourceLibraryLayer.bringToTop())
                                .setText("resource lib").build());

                manager.createControl(cmp);
        }

        private void menuManager(Shell shell) {
                MenuManager manager = new MenuManager();

                MenuManager file_menu = new MenuManager(LocaleHelper.Application.Menu.File.File);

                // Save
                file_menu.add(Actions.builder().setText(LocaleHelper.Application.Menu.File.Save)
                                .setStyle(Actions.Style.PUSH).setRunnable(() -> {
                                        try {
                                                preferenceService.save();
                                        } catch (IOException e) {
                                                log.error("error saving prefs", e);
                                        }
                                }).build());

                // Exit
                file_menu.add(Actions.builder().setText(LocaleHelper.Application.Menu.File.Exit)
                                .setStyle(Actions.Style.PUSH).setRunnable(() -> {
                                        if (SwtMisc.blockForQuestion(
                                                        String.format("%s : %s", appname, preference.getComputer()),
                                                        LocaleHelper.Application.Menu.File.Exit))
                                                dispose();
                                }).build());

                // selection.set(Boolean.TRUE);

                manager.add(file_menu);

                Menu menu = manager.createMenuBar((Decorations) shell);

                shell.setMenuBar(menu);
        }

}