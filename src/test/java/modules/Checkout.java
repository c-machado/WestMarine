package modules;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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


    @When("^I type \"([^\"]*)\" in the search field$")
    public void iTypeInTheSearchField(String keyword) throws Throwable {
        browser.findElement(By.id("search")).sendKeys(keyword);
    }

    @And("^I click on the search button$")
    public void iClickOnTheSearchButton() throws Throwable {
        browser.findElement(By.cssSelector("form[name='search_form'] .button")).click();
    }

    @Then("^I should see results for 'boat shoes'$")
    public void iShouldSeeResultsForBoatShoes() throws Throwable {
        browser.findElement(By.cssSelector(".total-records")).isDisplayed();
    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelect(String productId) throws Throwable {
        browser.findElement(By.cssSelector("div[data-pcode='" + productId + "'] > .prod_grid > a")).click();
        Assert.assertTrue("Confirming navigation to product page",browser.getCurrentUrl().contains(productId) );
    }

    @And("^I select size '(\\d+)'$")
    public void iSelectSize(int size) throws Throwable {
        browser.findElement(By.cssSelector("a[data-size-name='" + size + "']")).click();

    }



}
