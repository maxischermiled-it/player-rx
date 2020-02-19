package me.antoniocaccamo.player.rx.ui;

import com.diffplug.common.swt.ColorPool;
import com.diffplug.common.swt.Layouts;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

/**
 * @author antoniocaccamo on 19/02/2020
 */
public class PhotoUI extends AbstractUI {

    private final Browser browser;

    public PhotoUI(Composite wrapped) {
        super(wrapped);
        setBackground(ColorPool.forWidget(this).getSystemColor(SWT.COLOR_BLACK));

        browser = new Browser(this, SWT.NONE);

        Layouts.setGridData(browser)
                .grabAll()
        ;
    }

}