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
import org.openqa.selenium.WebElement;

import static constants.Constants.BASE_URL;
import static constants.Constants.DEFAULT_SLEEP_TIME;

public class Login extends BaseClass {

    @Given("^The login form is displayed in the WestMarine Homepage$")
    public void theLoginFormIsDisplayedInTheWestMarineHomepage() throws Throwable {

        browser.navigate().to(BASE_URL);
        if(browser.findElements(By.cssSelector(".user-account-menu")).size() > 0){
            browser.findElement(By.cssSelector(".user-account-menu")).click();
            browser.findElement(By.cssSelector("a[href='/logout']")).click();
        }
        browser.findElement(By.linkText("Sign In")).click();
        Assert.assertTrue("Confirming login page is visible",browser.getCurrentUrl().contains("login"));
    }

    @When("^I fill out the login form with \"([^\"]*)\" and \"([^\"]*)\" information$")
    public void iFillOutTheLoginFormWithAndInformation(String username, String password) throws Throwable {
        browser.findElement(By.id("j_username")).sendKeys(username);
        browser.findElement(By.id("j_password")).sendKeys(password);
    }

    @When("^I click on the Sign in button in the login form$")
    public void iClickOnTheSignInButtonInTheLoginForm() throws Throwable {
        browser.findElement(By.cssSelector("button.form.secondary")).click();
    }

    @Then("^I'm succesfully logged in$")
    public void iMSuccesfullyLoggedIn() throws Throwable {
        //browser.findElement(By.cssSelector(".user-account-name")).getText().compareTo("Hi 123456");
        Assert.assertTrue("Confirming that user is logged in",browser.getPageSource().contains("Hi 123456"));

    }

    @And("^I fill out the login form with wrong information$")
    public void iFillOutTheLoginFormWithWrongInformation() throws Throwable {
        browser.findElement(By.id("j_username")).sendKeys("caro@gmail.com");
        browser.findElement(By.id("j_password")).sendKeys("E123?asd");
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



    @AfterClass
    public void afterScenario(){
        browser.quit();
    }



}
