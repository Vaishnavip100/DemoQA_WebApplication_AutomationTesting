package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FramesPage;
import pages.HomePage;

public class FramesTest extends BaseTest {

	//Switch to an iframe and interact with an element and switch back to main frame and verify
    @Test
    public void testFrame() {
        HomePage hp=new HomePage(getDriver());
        FramesPage frame=hp.clickFrames();

        String text=frame.getFrameText();

        Assert.assertEquals(text, "This is a sample page","Unable to interact inside iframe");
        Assert.assertTrue(frame.isMainPageElementVisible(),"Failed to switch back to main page");
    }

    //Verify text content inside a nested iframe
    @Test
    public void verifyNestedFrame() {
        HomePage hp=new HomePage(getDriver());
        FramesPage frame=hp.clickNestedFrames();

        String text=frame.getNestedFrameText();

        Assert.assertEquals(text, "Child Iframe","Nested iframe text verification failed");
    }
}