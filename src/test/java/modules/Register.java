package modules;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static constants.Constants.BASE_URL;
import static java.lang.Thread.sleep;

public class Register extends BaseClass {

    Select country;
    Select state;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");

    @Given("^I'm in WestMarine Homepage$")
    public void iMInWestMarineHomepage() throws Throwable {
        browser.navigate().to(BASE_URL);
    }

    @And("^I click to sign in$")
    public void iClickToSignIn() throws Throwable {
        browser.findElement(By.linkText("Sign In")).click();

    }

    @And("^I have to choose create option$")
    public void iHaveToChooseCreateOption() throws Throwable {
        sleep(2000);
        browser.findElement(By.linkText("Create An Account")).click();
    }

    @And("^I fill out the form with correct information$")
    public void iFillOutTheFormWithCorrectInformation() throws Throwable {
        browser.findElement(By.id("register.email")).sendKeys("dcmachadou+"+dateFormat.format(date)+"@gmail.com");
        browser.findElement(By.id("password")).sendKeys("E123?asdf");
        browser.findElement(By.id("register.firstName")).sendKeys("123456");
        browser.findElement(By.id("register.lastName")).sendKeys("123456");
        browser.findElement(By.cssSelector("label[for='register.activeEmailOffers']")).click();
        /*
        browser.findElement(By.id("register.checkPwd")).sendKeys("E123?asdf");
        country = new Select(browser.findElement(By.id("address.country")));
        country.selectByValue("CA");
        browser.findElement(By.id("address.line1")).sendKeys("601 Sherwood Ave, San Bernardino");
        browser.findElement(By.id("address.townCity")).sendKeys("Sterd");
        sleep(2000);
        state = new Select(browser.findElement(By.id("address.region")));
        state.selectByValue("CA-ON");
        browser.findElement(By.id("address.postcode")).sendKeys("111111");
        browser.findElement(By.id("register.phone")).sendKeys("545354658889088");
        */
    }

    @When("^I click on the Register button$")
    public void iClickOnTheRegisterButton() throws Throwable {
        Assert.assertTrue("confirming the user has selected news option",
                browser.findElement(By.id("register.activeEmailOffers")).isSelected());
        browser.findElement(By.cssSelector("#registerWithAddressForm .form.primary")).click();
    }

    @Then("^I'm succesfully registered$")
    public void iMSuccesfullyRegistered() throws Throwable {
        Assert.assertTrue("",browser.getPageSource().contains("Thank you for completing registration!"));

    }


}
