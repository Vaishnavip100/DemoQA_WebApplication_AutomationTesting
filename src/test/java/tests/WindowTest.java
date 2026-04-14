package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.WindowPage;

public class WindowTest extends BaseTest {

	//Switch to a new tab
    @Test
    public void newTab() {
        HomePage hp=new HomePage(getDriver());
        WindowPage window=hp.clickBrowserWindows();

        window.openNewTab();
        window.switchToNewWindow();

        Assert.assertEquals(window.getSampleText(), "This is a sample page","New tab content mismatch");
    }
}