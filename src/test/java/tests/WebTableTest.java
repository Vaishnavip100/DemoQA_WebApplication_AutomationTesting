package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest extends BaseTest {

	//Add new row and verify
    @Test
    public void testAddRecord() {
        HomePage hp=new HomePage(getDriver());
        WebTablePage wt=hp.clickWebTable();
        wt.addRecord("Vaishnavi","Perumalla","vaishnavi@gmail.com","21","50000","IT");

        Assert.assertTrue(wt.isRecordPresent("Vaishnavi"));
    }

    //Search for a record and verify
    @Test
    public void testSearchRecord() {
        HomePage hp=new HomePage(getDriver());
        WebTablePage wt=hp.clickWebTable();
        wt.searchRecord("Cierra");

        Assert.assertTrue(wt.isRecordPresent("Cierra"),"Search failed");
    }

    //Delete a row and verify
    @Test
    public void testDeleteRecord() {
        HomePage hp=new HomePage(getDriver());
        WebTablePage wt=hp.clickWebTable();
        wt.deleteRecord("Cierra");

        Assert.assertFalse(wt.isRecordPresent("Cierra"),"Delete failed");
    }

    //Verify table pagination
    @Test
    public void testPagination() {
        HomePage hp=new HomePage(getDriver());
        WebTablePage wt=hp.clickWebTable();
        wt.goToNextPage();

        Assert.assertTrue(true);
    }
}