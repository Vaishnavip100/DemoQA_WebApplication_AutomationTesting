package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class AlertsPage extends BasePage {
    By simpleAlertBtn=By.id("alertButton");
    By confirmAlertBtn=By.id("confirmButton");
    By promptAlertBtn=By.id("promtButton");

    By resultText=By.id("confirmResult");
    By promptResult=By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }
    
    
    public void triggerSimpleAlert() {
        click(simpleAlertBtn);
    }

    public void acceptAlert() {
        switchToAlert().accept();
    }
    
    public void triggerConfirmAlert() {
        click(confirmAlertBtn);
    }

    public void dismissAlert() {
        switchToAlert().dismiss();
    }
    
    public void triggerPromptAlert() {
        click(promptAlertBtn);
    }

    public void enterTextInAlert(String text) {
        switchToAlert().sendKeys(text);
        switchToAlert().accept();
    }
    
    //Validations
    public String getConfirmResult() {
        return getText(resultText);
    }

    public String getPromptResult() {
        return getText(promptResult);
    }
}