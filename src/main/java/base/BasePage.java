package base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void handleAds() {
        try {
            if (driver.getCurrentUrl().contains("google_vignette")) {
                driver.navigate().back();
            }
        } catch (Exception e) {
            // ignore
        }
    }

    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void waitForTextToAppear(By locator, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public Alert switchToAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void click(By locator) {
    	handleAds();
        WebElement element=waitForElement(locator);
        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
        }
    }

    public void type(By locator, String text) {
        WebElement element=waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return waitForElement(locator).isDisplayed();
    }
    
    public void switchToFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}