package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    public WebDriver webDriver;

    By phoneNumber = By.id("pb-card-number");
    By pin = By.id("pb-pin-number");
    By login_button = By.xpath("//button[text()='LOGIN']");

    public Login(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getPhoneNumber() {
        return webDriver.findElement(phoneNumber);
    }

    public WebElement getPin() {
        return webDriver.findElement(pin);
    }

    public WebElement getLogin_button() {
        return webDriver.findElement(login_button);
    }
}
