package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaybackPlus {
    public WebDriver webDriver;

    By button1 = By.xpath("//a[@data-title=\"The man company\"]");
    By button2 = By.xpath("//a[@data-title=\"1mg\"]");
    By upgrade_points = By.linkText("Upgrade with Points");
    By upgrade_points_pay = By.linkText("Upgrade with Points + Pay");

    public PaybackPlus(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getButton1(){
        return webDriver.findElement(button1);
    }
    public WebElement getButton2(){
        return webDriver.findElement(button2);
    }

    public WebElement getUpgrade_points() {
        return webDriver.findElement(upgrade_points);
    }

    public WebElement getUpgrade_points_pay() {
        return webDriver.findElement(upgrade_points_pay);
    }
}
