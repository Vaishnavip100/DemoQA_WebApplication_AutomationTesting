package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class FormPage extends BasePage {
    By firstName=By.id("firstName");
    By lastName=By.id("lastName");
    By email=By.id("userEmail");
    By mobile=By.id("userNumber");
    By submitBtn=By.id("submit");
    By successMessage=By.id("example-modal-sizes-title-lg");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public By getGender(String gender) {
        return By.xpath("//label[text()='"+ gender+"']");
    }

    public By getHobby(String hobby) {
        return By.xpath("//label[text()='"+hobby+"']");
    }

    public void fillForm(String fname,String lname,String mail,String phone,String gender,String hobby) {

        type(firstName,fname);
        type(lastName,lname);
        type(email,mail);

        click(getGender(gender));   
        type(mobile,phone);

        click(getHobby(hobby));     
    }
    
    public boolean isGenderSelected(String gender) {
        String id="";
        if (gender.equalsIgnoreCase("Male")) {
            id="gender-radio-1";
        } else if (gender.equalsIgnoreCase("Female")) {
            id="gender-radio-2";
        } else {
            id="gender-radio-3";
        }
        return driver.findElement(By.id(id)).isSelected();
    }
    
    public boolean isHobbySelected(String hobby) {
        String id="";
        if (hobby.equalsIgnoreCase("Sports")) {
            id="hobbies-checkbox-1";
        } else if (hobby.equalsIgnoreCase("Reading")) {
            id="hobbies-checkbox-2";
        } else {
            id="hobbies-checkbox-3";
        }
        return driver.findElement(By.id(id)).isSelected();
    }

    public void clickSubmit() {
        click(submitBtn);
    }

    //Validations
    public boolean isSubmissionSuccess() {
        return isDisplayed(successMessage);
    }
    
    public boolean isErrorDisplayed() {
        String validation = driver.findElement(By.id("firstName")).getAttribute("validationMessage");
        return validation != null && !validation.isEmpty();
    }
}