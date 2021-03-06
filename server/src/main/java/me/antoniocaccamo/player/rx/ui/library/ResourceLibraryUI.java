package me.antoniocaccamo.player.rx.ui.library;

import com.diffplug.common.rx.RxBox;
import com.diffplug.common.swt.Layouts;
import com.diffplug.common.swt.jface.ColumnViewerFormat;
import com.diffplug.common.swt.jface.ViewerMisc;
import io.reactivex.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;
import me.antoniocaccamo.player.rx.Application;
import me.antoniocaccamo.player.rx.ApplicationUI;
import me.antoniocaccamo.player.rx.event.resource.ResourceEvent;
import me.antoniocaccamo.player.rx.event.resource.SelecteResourceEvent;
import me.antoniocaccamo.player.rx.model.resource.Resource;
import me.antoniocaccamo.player.rx.service.ResourceService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import java.util.Optional;

/**
 * @author antoniocaccamo on 05/05/2020
 */
@Slf4j
public class ResourceLibraryUI extends Composite {
    private final DragSource dragSource;

    public ResourceLibraryUI(Composite parent/*, PublishSubject<ResourceEvent> resourcePublishSubject*/) {
        super(parent, SWT.NONE);

        Layouts.setGrid(this).numColumns(1).columnsEqualWidth(false).margin(0).spacing(0);
        //Layouts.setGridData(this).grabAll();

        ResourceService resourceService = Application.CONTEXT.getBean(ResourceService.class);

        Group group = new Group(this, SWT.NONE);
        Layouts.setGrid(group).numColumns(1).spacing(0).margin(0);
        //Layouts.setGrid(group);
        //Layouts.setGridData(group).grabAll();
        group.setText("resources..01");
        Layouts.setGrid(group).numColumns(1);
        Layouts.setGridData(group).grabAll();
        Composite composite = new Composite(group, SWT.NONE);
        Layouts.setFill(composite);
        Layouts.setGridData(composite).grabAll();

        ColumnViewerFormat<Resource> format = ColumnViewerFormat.builder();
        format.addColumn().setText("hash").setLabelProviderText(r -> String.valueOf(r.getHash()));
        format.addColumn().setText("location").setLabelProviderText(r-> r.getClass().getSimpleName());
        format.addColumn().setText("type").setLabelProviderText(r-> r.getType().name());
        format.addColumn().setText("duration").setLabelProviderText(r->r.getDuration() != null ?r.getDuration().toString(): "");
        format.addColumn().setText("path").setLabelProviderText(r->r.getPath());
        format.setStyle( SWT. FULL_SELECTION);

        TableViewer tableViewer = format.buildTable(new Composite(composite, SWT.BORDER));
        tableViewer.setContentProvider(new ArrayContentProvider());


        tableViewer.setInput(resourceService.getResources());

        Composite buttoComposite = new Composite(group, SWT.SHADOW_ETCHED_OUT | SWT.CENTER);
        Layouts.setGrid(buttoComposite).numColumns(3);
        Layouts.setGridData(buttoComposite).grabHorizontal().horizontalAlignment(SWT.CENTER);

        Button button = new Button(buttoComposite, SWT.PUSH );
        button.setText("button 01");

        button = new Button(buttoComposite, SWT.PUSH );
        button.setText("button 02");

        button = new Button(buttoComposite, SWT.PUSH );
        button.setText("button 03");

        dragSource= new DragSource(tableViewer.getControl(), DND.DROP_MOVE);
        dragSource.setTransfer(new Transfer[] { TextTransfer.getInstance() });
        dragSource.addDragListener(  new DragSourceAdapter() {
            public void dragSetData(DragSourceEvent event) {
                // Set the data to be the first selected item's text
                if ( tableViewer.getStructuredSelection().size() > 0 ) {
                    event.data = ( (Resource)tableViewer.getStructuredSelection().getFirstElement()).getHash();
                    log.warn("## drag : {}" , event.data);
                }
            }
        });

        RxBox<Optional<Resource>> resourceRxBox  = ViewerMisc.singleSelection(tableViewer);
        resourceRxBox.asObservable()
                .subscribe(
                        or -> or.ifPresent( r-> {
                            log.info("selected : {}", r);
                            ApplicationUI.RESOURCE_EVENT_BUS.onNext(new SelecteResourceEvent(r));
                        })
                );

    }


}
