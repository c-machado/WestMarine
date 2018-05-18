package modules;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import base.BaseClass;

import static constants.Constants.BASE_URL;
import static constants.Constants.DEFAULT_SLEEP_TIME;

public class Login extends BaseClass {

    @Given("^I'm in WestMarine Homepage to login$")
    public void iMInWestMarineHomepageToLogin() throws Throwable {
        browser.navigate().to(BASE_URL);
    }

    @And("^I click on the Sign in button in the top bar$")
    public void iClickOnTheSignInButtonInTheTopBar() throws Throwable {
        browser.findElement(By.linkText("Sign In")).click();
    }

    @Then("^I should see the login form$")
    public void iShouldSeeTheLoginForm() throws Throwable {
        browser.findElement(By.id("my_account_list")).isDisplayed();
    }

    @And("^I fill out the login form with correct information$")
    public void iFillOutTheFormWithCorrectInformationInLoginForm() throws Throwable {
        Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_username")).sendKeys("dcmachado@gmail.com");
        Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_password")).sendKeys("E123?asd");
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
        Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_username")).sendKeys("caro@gmail.com");
        Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_password")).sendKeys("E123?asd");
    }

    @Then("^I should see an error message$")
    public void iShouldSeeAnErrorMessage() throws Throwable {
        String errorMessage = "The login information you supplied appears to be incorrect.";
        Assert.assertTrue(
            "Confirming error when login with wrong credentials",
            browser.findElement(By.xpath("//p[contains(text(),\"" + errorMessage + "\")]")).isDisplayed()
        );
    }

    @And("^I log out$")
    public void iLogOut() throws Throwable {
        browser.findElement(By.cssSelector(".user-account-menu")).click();
        browser.findElement(By.cssSelector("a[href='/logout']")).click();
    }
}
