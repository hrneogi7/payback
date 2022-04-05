package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.*;
import pageFactory.*;
import utils.*;

import java.io.*;

public class StepDefinitions {
    @Given("The WebDriver is initialized")
    public void the_web_driver_is_initialized() {
        InitializeWebDriver.initializeWebDriver();
        System.out.println("GIVEN PASSED\n");
    }

    @When("Navigates to GitHub using {string} link")
    public void navigates_to_git_hub_using_link(String link) {
        LandingPage.navigateToLink(InitializeWebDriver.webDriver, link);
        System.out.println("WHEN PASSED\n");
    }

    @When("Navigates to Google using {string} link")
    public void navigates_to_google_using_link(String link) {
        LandingPage.navigateToLink(InitializeWebDriver.webDriver, link);
        System.out.println("WHEN PASSED\n");
    }

    @Then("Fetch the page title of GitHub")
    public void fetch_the_page_title_of_git_hub() {
        final String expectedTitle = "GitHub: Where the world builds software · GitHub";
        String title = LandingPage.fetchPageTitle(InitializeWebDriver.webDriver);
        System.out.println("PAGE TITLE: " + title);
        Assert.assertEquals(title, expectedTitle);
        System.out.println("THEN PASSED\n");
    }

    @Then("Fetch the page title of Google")
    public void fetch_the_page_title_of_google() {
        final String expectedTitle = "Google";
        String title = LandingPage.fetchPageTitle(InitializeWebDriver.webDriver);
        System.out.println("PAGE TITLE: " + title);
        Assert.assertEquals(title, expectedTitle);
        System.out.println("THEN PASSED\n");
    }

    @When("Searches Google for {string}")
    public void searches_google_for(String text) {
        GoogleStuff.searchGoogleFor(InitializeWebDriver.webDriver, text);
        System.out.println("WHEN PASSED\n");
    }

    @Then("Successfully translates {string} from English to {string}")
    public void successfully_translates_text_from_english_to_german(String text, String targetLang) {
        String translatedText = GoogleStuff.translateText(InitializeWebDriver.webDriver, text, targetLang);
        System.out.println("TRANSLATED TEXT: " + translatedText);
        boolean puncture = text.contains("!");
        Assert.assertFalse(puncture);
        System.out.println("THEN PASSED\n");
    }

    @Then("Takes a screenshot and saves it locally")
    public void takes_a_screenshot_and_saves_it_locally() {
        String filePath = ScreenshotUtil.takeScreenshot();
        File screenshot = new File(filePath);
        boolean fileExists = screenshot.exists() && screenshot.isFile();
        Assert.assertTrue(fileExists);
        System.out.println("SCREENSHOT SAVED AT: " + filePath);
        System.out.println("THEN PASSED\n");
    }
}
