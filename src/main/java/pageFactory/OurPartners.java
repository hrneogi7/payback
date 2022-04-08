package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OurPartners {
    public WebDriver webDriver;

    By american_express = By.xpath("//a[@data-title=\"american express\"]");
    By thomas_cook = By.xpath("//a[@data-title=\"Thomascook\"]");
    By bookmyshow = By.xpath("//a[@data-title=\"BookMyShow: Movie Offers\"]");
    By amazon = By.xpath("//a[@data-title=\"Amazon\"]");
    By dyson = By.xpath("//a[@data-title=\"dyson\"]");
    By proceed = By.xpath("//a[@class=\"proceed-store-btn\"]");

    public OurPartners(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getAmerican_express() {
        return webDriver.findElement(american_express);
    }
    public WebElement getThomas_cook() {
        return webDriver.findElement(thomas_cook);
    }
    public WebElement getBookmyshow() {
        return webDriver.findElement(bookmyshow);
    }

    public WebElement getAmazon() {
        return webDriver.findElement(amazon);
    }

    public WebElement getDyson() {
        return webDriver.findElement(dyson);
    }

    public WebElement getProceed() {
        return webDriver.findElement(proceed);
    }
}
