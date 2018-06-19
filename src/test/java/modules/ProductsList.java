package modules;

import base.BaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsList  extends BaseClass {

    String productIitle = "";
    @When("^I click one of the products$")
    public void iClickOneOfTheProducts() throws Throwable {
        /**
         * Checks if the pagination element is visible.
         * If it is it looks for a random .pageNum element and clicks it.
         */
        if(browser.findElement(By.cssSelector(".pageNums")).isDisplayed()){
            List<WebElement> pageButtons = browser.findElements(By.cssSelector(".pageNum"));
            Random rand = new Random();
            int randomPageNumber = rand.nextInt(pageButtons.size());
            pageButtons.get(randomPageNumber).click();
        }
        /**
         * Selects an aleatory product from the product list and clicks on it
         * */
        List<WebElement> products = browser.findElements(By.cssSelector(".prod_grid"));
        Random randProducts = new Random();
        int randomProductNumber = randProducts.nextInt(products.size());
        WebElement product = products.get(randomProductNumber);
        productIitle = product.findElement(By.cssSelector(".prod_grid .productName a")).getAttribute("title");
        product.click();
    }

    @Then("^I should be at the product page$")
    public void iShouldBeAtTheProductPage() throws Throwable {
        String bodyClass = browser.findElement(By.cssSelector("body")).getAttribute("class");
        System.out.println("productTitle " + productIitle);
        String productDetailTitle = browser.findElement(By.cssSelector("#productDetailsPageTitle .title-desc")).getText();
        System.out.println("productDetailTitle " + productDetailTitle);

        Assert.assertTrue("Confirming navigation to product detail page", bodyClass.contains("page-productDetails"));
        Assert.assertTrue("Confirming product title is the same as requested", productDetailTitle.equals(productIitle));
    }
}
