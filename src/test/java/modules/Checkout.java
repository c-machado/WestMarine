package modules;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import global.CommonSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout{
    WebDriver browser = new ChromeDriver();

    @Given("^I'm logged in the west marine home page$")
    public void iMLoggedInTheWestMarineHomePage() throws Throwable {
        browser.navigate().to("https://www.westmarine.com/");
        browser.findElement(By.linkText("Sign In")).click();
        browser.findElement(By.id("my_account_list")).isDisplayed();
        browser.findElement(By.id("header_j_username")).sendKeys("dcmachado@gmail.com");
        Thread.sleep(2000);
        browser.findElement(By.id("header_j_password")).sendKeys("E123?asd");
        browser.findElement(By.cssSelector("#my_account_list .form.secondary")).click();
        Assert.assertTrue("Confirming that user is logged in",browser.getPageSource().contains("Hi 123456"));
    }


    @When("^I type 'boat shoes' in the search field$")
    public void iTypeBoatShoesInTheSearchField() throws Throwable {
        browser.findElement(By.id("search")).sendKeys("boat shoes");
    }

    @And("^I click on the search button$")
    public void iClickOnTheSearchButton() throws Throwable {
        browser.findElement(By.cssSelector("form[name='search_form'] .button")).click();
    }
}
