package me.antoniocaccamo.player.rx.ui.monitor;

import com.diffplug.common.swt.ColorPool;
import com.diffplug.common.swt.Layouts;
import lombok.Getter;
import me.antoniocaccamo.player.rx.ui.AbstractUI;
import me.antoniocaccamo.player.rx.ui.MonitorUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

/**
 * @author antoniocaccamo on 19/02/2020
 */
public class BrowserUI extends AbstractUI {

    @Getter
    protected final Browser browser;

    public BrowserUI(MonitorUI monitorUI, Composite wrapped) {
        super(monitorUI, wrapped);
        setBackground(ColorPool.forWidget(this).getSystemColor(SWT.COLOR_BLACK));

        browser = new Browser(this, SWT.NONE);

        Layouts.setGridData(browser)
                .grabAll()
        ;
    }

}
