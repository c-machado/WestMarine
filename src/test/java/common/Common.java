package common;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import base.BaseClass;
import org.openqa.selenium.By;

import static constants.Constants.DEFAULT_SLEEP_TIME;

public class Common extends BaseClass {
    @Then("^I should be at the \"([^\"]*)\" page$")
    public void iShouldBeAtThePage(String pagePath) throws Throwable {
        System.out.println("url "+browser.getCurrentUrl());
        System.out.println("path "+pagePath);
        System.out.println("assert "+browser.getCurrentUrl().contains("checkout/singlePage"));
        Assert.assertTrue("confirming the url contains this path: "+ pagePath, browser.getCurrentUrl().contains(pagePath));
    }

    @When("^I type \"([^\"]*)\" in the search field$")
    public void iTypeInTheSearchField(String keyword) throws Throwable {
        Thread.sleep(DEFAULT_SLEEP_TIME/2);
        System.out.println("key in ckeckout guest"+keyword);
        browser.findElement(By.id("search")).sendKeys(keyword);
    }

    @And("^I click on the search button$")
    public void iClickOnTheSearchButton() throws Throwable {
        browser.findElement(By.cssSelector("form[name='search_form'] .button")).click();
    }

    @Then("^I should see results for the item searched$")
    public void iShouldSeeResultsForSearchedItem() throws Throwable {
        browser.findElement(By.cssSelector(".total-records")).isDisplayed();
    }

    @After("@web")
    public void afterScenario(){
        browser.quit();
    }


}
