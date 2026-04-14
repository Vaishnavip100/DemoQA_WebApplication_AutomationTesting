package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AlertsPage;
import pages.HomePage;

public class AlertsTest extends BaseTest {

	//Simple Alert
    @Test
    public void simpleAlert() {
        HomePage hp=new HomePage(getDriver());
        AlertsPage alert=hp.clickAlerts();

        alert.triggerSimpleAlert();
        alert.acceptAlert();

        Assert.assertTrue(true);
    }

    //Confirm Alert
    @Test
    public void confirmAlert() {
        HomePage hp=new HomePage(getDriver());
        AlertsPage alert=hp.clickAlerts();

        alert.triggerConfirmAlert();
        alert.dismissAlert();

        Assert.assertTrue(alert.getConfirmResult().contains("Cancel"));
    }

    //Prompt Alert
    @Test
    public void promptAlert() {
        HomePage hp=new HomePage(getDriver());
        AlertsPage alert=hp.clickAlerts();

        alert.triggerPromptAlert();
        alert.enterTextInAlert("Vaishnavi");

        Assert.assertTrue(alert.getPromptResult().contains("Vaishnavi"));
    }
}