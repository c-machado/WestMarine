package modules;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import base.BaseClass;

import static constants.Constants.BASE_URL;

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

    @And("^I fill out the form with correct information in login form$")
    public void iFillOutTheFormWithCorrectInformationInLoginForm() throws Throwable {
        Thread.sleep(4000);
        browser.findElement(By.id("header_j_username")).sendKeys("dcmachado@gmail.com");
        Thread.sleep(4000);
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
}
