package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Explore {
    public WebDriver driver;

    By explore = By.xpath("//*[@id=\"myNavbar\"]/ul[2]/li[4]/a");
    By PaybackPlus = By.xpath("//a[@data-clicktext=\"PAYBACK Plus\"]");
    By KnowAboutPayback = By.xpath("//a[@data-clicktext=\"Know about PAYBACK\"]");
    By OurPartners = By.xpath("//*[@id=\"myNavbar\"]/ul[2]/li[4]/ul/li[3]/a");
    By Offers = By.xpath("//a[@data-clicktext=\"Offers\"]");
    By InstantVouchers = By.xpath("//*[@id=\"myNavbar\"]/ul[2]/li[4]/ul/li[6]/a");

    public Explore(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getExplore(){
        return driver.findElement(explore);
    }
    public WebElement getPaybackPlus(){
        driver.findElement(explore).click();
        return driver.findElement(PaybackPlus);
    }

    public WebElement getKnowAboutPayback(){
        driver.findElement(explore).click();
        return driver.findElement(KnowAboutPayback);
    }

    public WebElement getOurPartners(){
        driver.findElement(explore).click();
        return driver.findElement(OurPartners);
    }

    public WebElement getOffers(){
        driver.findElement(explore).click();
        return driver.findElement(Offers);
    }

    public WebElement getInstantVouchers(){
        driver.findElement(explore).click();
        return driver.findElement(InstantVouchers);
    }

}
