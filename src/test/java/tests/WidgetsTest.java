package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.WidgetsPage;

public class WidgetsTest extends BaseTest {

    //Date Picker
    @Test
    public void testDatePicker() {
        HomePage hp=new HomePage(getDriver());
        WidgetsPage widget=hp.clickDatePicker();

        widget.selectDate("10/11/2004");

        Assert.assertEquals(widget.getSelectedDate(),"10/11/2004","Date not selected correctly");
    }

    //Slider
    @Test
    public void testSlider() {
        HomePage hp=new HomePage(getDriver());
        WidgetsPage widget=hp.clickSlider();

        widget.moveSlider(5);

        Assert.assertTrue(Integer.parseInt(widget.getSliderValue()) > 0,"Slider did not move");
    }

    //Accordian
    @Test
    public void testAccordian() {
        HomePage hp=new HomePage(getDriver());
        WidgetsPage widget=hp.clickAccordian();

        widget.clickSection2();

        Assert.assertTrue(widget.isSection2Expanded(),"Accordian not expanded");
    }
}