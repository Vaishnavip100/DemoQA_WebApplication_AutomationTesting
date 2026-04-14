package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormPage;
import pages.HomePage;
import utils.ConfigReader;
import utils.ExcelUtil;

public class FormTest extends BaseTest {

    ConfigReader config=new ConfigReader();

    @DataProvider(name="formData")
    public Object[][] getData() {
        return ExcelUtil.getTestData(config.getTestDataPath(), "Sheet1");
    }

    @Test(dataProvider="formData")
    public void testFormSubmission(String fname, String lname, String email,String phone, String gender, String hobby) {
    	HomePage hp=new HomePage(getDriver());
        FormPage form=hp.clickForm();
        form.fillForm(fname, lname, email, phone, gender, hobby);
        
        Assert.assertTrue(form.isGenderSelected(gender));
        Assert.assertTrue(form.isHobbySelected(hobby));
        
        form.clickSubmit();
        
        Assert.assertTrue(form.isSubmissionSuccess(), "Form submission failed");
    }

    //Verify with mandatory empty fields submission
    @Test
    public void testEmptyForm() {
    	HomePage hp=new HomePage(getDriver());
        FormPage form=hp.clickForm();
        form.clickSubmit();

        Assert.assertTrue(form.isErrorDisplayed(), "Error state not shown");
    }
}