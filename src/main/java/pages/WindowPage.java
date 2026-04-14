package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class WindowPage extends BasePage {
    By newTabBtn=By.id("tabButton");
    By sampleText=By.id("sampleHeading");

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    public void openNewTab() {
        click(newTabBtn);
    }

    public void switchToNewWindow() {
        String parent=driver.getWindowHandle();
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
            }
        }
    }

    public String getSampleText() {
        return getText(sampleText);
    }
}