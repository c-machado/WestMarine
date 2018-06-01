package modules;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import base.BaseClass;

import static constants.Constants.BASE_URL;
import static constants.Constants.DEFAULT_SLEEP_TIME;

public class Login extends BaseClass {

    @Given("^The login form is displayed in the WestMarine Homepage$")
    public void theLoginFormIsDisplayedInTheWestMarineHomepage() throws Throwable {
        browser.navigate().to(BASE_URL);
        browser.findElement(By.linkText("Sign In")).click();
        browser.findElement(By.id("my_account_list")).isDisplayed();
    }

    @When("^I fill out the login form with \"([^\"]*)\" and \"([^\"]*)\" information$")
    public void iFillOutTheLoginFormWithAndInformation(String username, String password) throws Throwable {
        //Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_username")).sendKeys(username);
        //Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_password")).sendKeys(password);
    }

    @When("^I click on the Sign in button in the login form$")
    public void iClickOnTheSignInButtonInTheLoginForm() throws Throwable {
        browser.findElement(By.cssSelector("#my_account_list .form.secondary")).click();
    }

    @Then("^I'm succesfully logged in$")
    public void iMSuccesfullyLoggedIn() throws Throwable {
        //browser.findElement(By.cssSelector(".user-account-name")).getText().compareTo("Hi 123456");
        Assert.assertTrue("Confirming that user is logged in",browser.getPageSource().contains("Hi 123456"));

    }

    @And("^I fill out the login form with wrong information$")
    public void iFillOutTheLoginFormWithWrongInformation() throws Throwable {
        //Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_username")).sendKeys("caro@gmail.com");
        //Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_password")).sendKeys("E123?asd");
    }

    @Then("^I should see an error message$")
    public void iShouldSeeAnErrorMessage() throws Throwable {
        String errorMessage = "The login information you supplied appears to be incorrect.";
        Assert.assertTrue(
            "Confirming error when login with wrong credentials",
            browser.findElement(By.xpath("//p[contains(text(),\"" + errorMessage + "\")]")).isDisplayed()
        );
        afterScenario();
    }

    @When("^I click the log out button$")
    public void iClickTheLogOutButton() throws Throwable {
        browser.findElement(By.cssSelector(".user-account-menu")).click();
        browser.findElement(By.cssSelector("a[href='/logout']")).click();
    }

    @Then("^The system logs me out$")
    public void theSystemLoggedMeOut() throws Throwable {
        //Thread.sleep(DEFAULT_SLEEP_TIME/2);
        Assert.assertTrue("confirming the user has been logged out", browser.findElement(By.linkText("Sign In")).isDisplayed());

    }

    @AfterClass
    public void afterScenario(){
        browser.quit();
    }



}
