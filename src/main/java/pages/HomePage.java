package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Form
	By formLink=By.xpath("//h5[text()='Forms']");
	By practiseForm=By.xpath("//a[@href='/automation-practice-form']");
	public FormPage clickForm() {
		click(formLink);
		click(practiseForm);
		return new FormPage(driver);
	}
	
	//Web Table
	By elements=By.xpath("//h5[text()='Elements']");
	By webTables=By.xpath("//span[text()='Web Tables']");
	public WebTablePage clickWebTable() {
	    click(elements);
	    click(webTables);
	    return new WebTablePage(driver);
	}
	
	// Alerts & Windows
	By alertsFrameWindows=By.xpath("//h5[text()='Alerts, Frame & Windows']");
	By alerts=By.xpath("//span[text()='Alerts']");
	By browserWindows=By.xpath("//span[text()='Browser Windows']");

	public AlertsPage clickAlerts() {
	    click(alertsFrameWindows);
	    click(alerts);
	    return new AlertsPage(driver);
	}

	public WindowPage clickBrowserWindows() {
	    click(alertsFrameWindows);
	    click(browserWindows);
	    return new WindowPage(driver);
	}
	
	// Frames
	By frames=By.xpath("//span[text()='Frames']");
	By nestedFrames=By.xpath("//span[text()='Nested Frames']");

	public FramesPage clickFrames() {
	    click(alertsFrameWindows);
	    click(frames);
	    return new FramesPage(driver);
	}

	public FramesPage clickNestedFrames() {
	    click(alertsFrameWindows);
	    click(nestedFrames);
	    return new FramesPage(driver);
	}
	
	//Widget
	By widgets=By.xpath("//div[@class='card-body']//h5[text()='Widgets']");
	By datePicker=By.xpath("//span[text()='Date Picker']");
	By slider=By.xpath("//span[text()='Slider']");
	By accordian=By.xpath("//span[text()='Accordian']");

	public WidgetsPage clickDatePicker() {
	    click(widgets);
	    click(datePicker);
	    return new WidgetsPage(driver);
	}

	public WidgetsPage clickSlider() {
	    click(widgets);
	    click(slider);
	    return new WidgetsPage(driver);
	}

	public WidgetsPage clickAccordian() {
	    click(widgets);
	    waitForElement(accordian);
	    click(accordian);
	    return new WidgetsPage(driver);
	}
}
