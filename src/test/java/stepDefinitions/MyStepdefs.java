package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageFactory.Explore;
import pageFactory.Login;
import pageFactory.OurPartners;
import pageFactory.PaybackPlus;
import utils.ExcelReader;
import utils.InitializeWebDriver;
import utils.ScreenshotUtil;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyStepdefs extends InitializeWebDriver {

    @Before
    public void initializeWebDriver(Scenario currentScenario) throws IOException {
        setCurrentScenario(currentScenario.getName());
        super.initializeWebDriver();
    }

    @After
    public void closeAllBrowserWindows() {
        String ssPath = ScreenshotUtil.takeScreenshot(webDriver);
        ScreenshotUtil.setLastScreenshotFilename(ssPath);
        super.closeAllBrowserWindows();
    }

    @Given("Users can navigate to payback using {string} link")
    public void usersCanNavigateToPaybackUsingLink(String link) {
        webDriver.get(link);
    }
    @Given("Users can hover over to {string} tab")
    public void usersCanHoverOverToTab(String arg0) {
        Explore explore = new Explore(webDriver);
        explore.getExplore().click();
    }

//    @When("click on {string} from dropdown list")
//    public void clickOnButtonFromDropdownList(String button) {
//        Explore explore = new Explore(webDriver);
//        if(button.equals("PaybackPlus")){
//            explore.getPaybackPlus().click();
//        }
//        if(button.equals("Offers")){
//            explore.getOffers().click();
//        }
//        if(button.equals("OurPartners")){
//            explore.getOurPartners().click();
//        }
//        if(button.equals("InstantVouchers")){
//            explore.getInstantVouchers().click();
//            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            ArrayList<String> tab = new ArrayList<>(webDriver.getWindowHandles());
//            webDriver.switchTo().window(tab.get(1));
//        }
//        if(button.equals("KnowAboutPayback")){
//            explore.getKnowAboutPayback().click();
//        }
//    }

//    @Then("Respective {string} is fetched")
//    public void respectiveIsFetched(String arg0) {
//        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        Assert.assertEquals(arg0,webDriver.getCurrentUrl());
//    }

    @When("Click on Buy button of the brand {string}")
    public void clickOnBuyButtonOfTheBrand(String button) {
        PaybackPlus paybackPlus = new PaybackPlus(webDriver);
        if(button.equals("1mg")){
            paybackPlus.getButton2().click();
        }
        if(button.equals("The man company")){
            paybackPlus.getButton1().click();
        }
        webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Then("the respective {string} webpage should open in new tab")
    public void theRespectiveShouldOpenInNewTab(String brandWebPage) {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        String url = webDriver.getTitle();
        int x=0;
        if(url.contains(brandWebPage)){
            x=1;
        }
        Assert.assertEquals(x,1);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("User clicked on Upgrade with Points button")
    public void userClickedOnUpgradeWithPointsButton() {
        PaybackPlus paybackPlus = new PaybackPlus(webDriver);
        paybackPlus.getUpgrade_points().click();
        webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @When("When user clicked on Upgrade with Points + pay button")
    public void whenUserClickedOnUpgradeWithPointsPayButton() {
        PaybackPlus paybackPlus = new PaybackPlus(webDriver);
        paybackPlus.getUpgrade_points_pay().click();
        webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
    }

    @Then("Fetch the page with link {string}")
    public void fetchThePageWithLink(String webPage) {

        String url = webDriver.getCurrentUrl();

        Assert.assertEquals(webPage,url);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("User is logged in using {string} and {string}")
    public void userIsLoggedInUsingAnd(String phoneNumber, String pin) {
        webDriver.get("https://www.payback.in/login");
        Login login = new Login(webDriver);

        login.getPhoneNumber().sendKeys(phoneNumber);
        login.getPin().sendKeys(pin);

        new WebDriverWait(webDriver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(login.getLogin_button())).click();
        login.getLogin_button().click();
    }

    @And("Then Hover over to Explore tab and clicked on Our partner")
    public void thenHoverOverToExploreTabAndClickedOnOurPartner() {
        Explore explore = new Explore(webDriver);
        explore.getExplore().click();
        explore.getOurPartners().click();
        webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }


    @When("User clicked on Details button of brand {string}")
    public void userClickedOnDetailsButtonOfBrand(String details) {
        OurPartners ourPartners = new OurPartners(webDriver);

        if(details.equals("American Express")){
            ourPartners.getAmerican_express().click();
        }
        if(details.equals("Thomas Cook")){
            ourPartners.getThomas_cook().click();
        }
        if(details.equals("Book my show")){
            ourPartners.getBookmyshow().click();
        }
        webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Then("It fetch the partner brand page {string}")
    public void itFetchThePartnerBrandPage(String partner_brand) {
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals(partner_brand,url);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @When("User clicked on Shop button under {string}")
    public void userClickedOnShopButtonUnder(String shop) {
        OurPartners ourPartners = new OurPartners(webDriver);

        if(shop.equals("Amazon")){
            ourPartners.getAmazon().click();
        }
        if(shop.equals("Dyson")){
            ourPartners.getDyson().click();
        }
        webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        System.out.println(tabs);
        webDriver.switchTo().window(tabs.get(0));
    }

    @And("Clicked on Proceed after that in the intermediate landing page")
    public void clickedOnProceedAfterThatInTheIntermediateLandingPage() {

        OurPartners ourPartners = new OurPartners(webDriver);
        ourPartners.getProceed().click();
        webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

    @Then("User is taken to {string} Website")
    public void userIsTakenToWebsite(String webPage) {
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals(url,webPage);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("click on button from Test Sheet {string} and row {int}")
    public void clickOnButtonFromTestSheetAndRowRow_number(String SheetName,int rowNumber) {
        ExcelReader excelReader = new ExcelReader();
        Row row = excelReader.getRowBySheetAndIndex(SheetName,rowNumber);
        String button = excelReader.getCellData(row,0);

        Explore explore = new Explore(webDriver);
        if(button.equals("Payback Plus")){
            explore.getPaybackPlus().click();
        }
        if(button.equals("Offers")){
            explore.getOffers().click();
        }
        if(button.equals("Our Partners")){
            explore.getOurPartners().click();
        }
        if(button.equals("Instant Vouchers")){
            explore.getInstantVouchers().click();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            ArrayList<String> tab = new ArrayList<>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tab.get(1));
        }
        if(button.equals("Know About Payback")){
            explore.getKnowAboutPayback().click();
        }
    }

    @Then("Respective Webpage is fetched from Test Sheet {string} and row {int}")
    public void respectiveWebpageIsFetchedFromTestSheetAndRowRow_number(String SheetName,int rowNumber) {
        ExcelReader excelReader = new ExcelReader();
        Row row = excelReader.getRowBySheetAndIndex(SheetName,rowNumber);
        String link = excelReader.getCellData(row,1);

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(webDriver.getCurrentUrl(),link);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
