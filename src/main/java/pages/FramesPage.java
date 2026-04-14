package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class FramesPage extends BasePage {
    By frame1=By.id("frame1");
    By frameText=By.id("sampleHeading");

    By parentFrame=By.id("frame1");
    By childFrame=By.xpath("//iframe[@srcdoc]");
    By childText=By.tagName("p");
    
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public String getFrameText() {
        switchToFrame(frame1);
        String text = getText(frameText);
        switchToDefaultContent();
        return text;
    }

    public String getNestedFrameText() {
        switchToFrame(parentFrame);
        switchToFrame(childFrame);
        String text = getText(childText);

        switchToDefaultContent();
        return text;
    }

    public boolean isMainPageElementVisible() {
        driver.switchTo().defaultContent();
        return driver.findElements(By.xpath("//h1[text()='Frames']")).size() > 0;
    }
}