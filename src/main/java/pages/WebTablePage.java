package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class WebTablePage extends BasePage {
    By addBtn=By.id("addNewRecordButton");

    By firstName=By.id("firstName");
    By lastName=By.id("lastName");
    By email=By.id("userEmail");
    By age=By.id("age");
    By salary=By.id("salary");
    By department=By.id("department");

    By searchBox=By.id("searchBox");

    By tableRows=By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']");

    By submitBtn=By.id("submit");
    By deleteBtn=By.xpath("//span[@title='Delete']");
    By nextBtn=By.xpath("//button[text()='Next']");
    
    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void addRecord(String fname, String lname, String mail,String ageVal, String sal, String dept) {
        click(addBtn);

        type(firstName, fname);
        type(lastName, lname);
        type(email, mail);
        type(age, ageVal);
        type(salary, sal);
        type(department, dept);

        click(submitBtn);
        searchRecord(fname);
    }

    public void searchRecord(String name) {
        type(searchBox, name);

        By cell=By.xpath("//table//td[contains(text(),'" + name + "')]");
        waitForElement(cell);
    }

    //Validations
    public boolean isRecordPresent(String name) {
        By cell=By.xpath("//table//td[contains(text(),'" + name + "')]");
        try {
            waitForElement(cell);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteRecord(String name) {
        searchRecord(name);
        click(deleteBtn);
    }

    public void goToNextPage() {
        click(nextBtn);
    }
}