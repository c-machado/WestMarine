package modules;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import static constants.Constants.BASE_URL;
import static constants.Constants.DEFAULT_SLEEP_TIME;


public class Checkout extends BaseClass {
    Select state;

    @Given("^I'm logged in the west marine home page$")
    public void iMLoggedInTheWestMarineHomePage() throws Throwable {
        browser.navigate().to(BASE_URL);
        browser.findElement(By.linkText("Sign In")).click();
        browser.findElement(By.id("my_account_list")).isDisplayed();

        Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_username")).sendKeys("dcmachado@gmail.com");
        Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("header_j_password")).sendKeys("E123?asd");
        browser.findElement(By.cssSelector("#my_account_list .form.secondary")).click();
        Assert.assertTrue("Confirming that user is logged in",browser.getPageSource().contains("Hi 123456"));
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
    public void iShouldSeeResultsForBoatShoes() throws Throwable {
        browser.findElement(By.cssSelector(".total-records")).isDisplayed();
    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelect(String productName) throws Throwable {
        // I'm searching for the div that has the product Id as an attribute, then inside of it I'm looking
        // for the actual link that opens the product detail page.
        // browser.findElement(By.cssSelector("div[data-pcode='" + productId + "'] > .prod_grid > a")).click();
        browser.findElement(By.xpath("//a[contains(text(), \"" + productName + "\")]")).click();
        Assert.assertTrue("Confirming navigation to product page",browser.getCurrentUrl().contains("buy") );

    }

    @And("^I select size '(\\d+)'$")
    public void iSelectSize(int size) throws Throwable {
        browser.findElement(By.cssSelector("a[data-size-name='" + size + "']")).click();

    }

    @And("^I add the item to the Shopping cart$")
    public void iAddTheItemToTheShoppingCart() throws Throwable {
        browser.findElement(By.id("addToCartButton")).click();
        Thread.sleep(DEFAULT_SLEEP_TIME);
        Assert.assertTrue("Confirming popup cart is being displayed",browser.findElement(By.id("cartInfoWrap")).isDisplayed());
    }

    @And("^I go the Shopping cart$")
    public void iGoTheShoppingCart() throws Throwable {
        browser.findElement(By.cssSelector("#cartInfoWrap a[href='/cart']")).click();
        Assert.assertTrue("confirming the url is updated", browser.getCurrentUrl().contains("/cart"));
    }

    @And("^I press the checkout button$")
    public void iPressTheCheckoutButton() throws Throwable {
        browser.findElement(By.id("checkoutButtonBottom")).click();

    }

    @Then("^I should be at the \"([^\"]*)\" page$")
    public void iShouldBeAtThePage(String pagePath) throws Throwable {
        Assert.assertTrue("confirming the url contains this path: "+ pagePath, browser.getCurrentUrl().contains(pagePath));
    }

    @And("^I press the Save button$")
    public void iPressTheSaveButton() throws Throwable {
        browser.findElement(By.cssSelector(".edit button.data-set-address")).click();
        Thread.sleep(DEFAULT_SLEEP_TIME);
        Assert.assertTrue("confirming the delivery form is being displayed", browser
                .findElement(By.id("selectDeliveryMethodForm")).isDisplayed());
    }

    @And("^I choose the delivery method$")
    public void iChooseTheDeliveryMethod() throws Throwable {
        browser.findElement(By.cssSelector("label[for='dm_7']")).click();
    }

    @And("^I press the delivery Save button$")
    public void iPressTheDeliverySaveButton() throws Throwable {
        browser.findElement(By.cssSelector(".edit button.data-set-shipping")).click();
        Thread.sleep(DEFAULT_SLEEP_TIME);
        Assert.assertTrue("confiming credit card form is being displayed",browser
                .findElement(By.id("creditCardSection")).isDisplayed());
    }

    @And("^I fill out the payment method form$")
    public void iFillOutThePaymentMethodForm() throws Throwable {
        Select month;
        Select year;
        browser.findElement(By.id("cardNumber")).sendKeys("378282246310005");
        browser.findElement(By.id("ExpiryMonth")).sendKeys("378282246310005");
        month = new Select(browser.findElement(By.id("ExpiryMonth")));
        month.selectByValue("01");
        year = new Select(browser.findElement(By.id("ExpiryYear")));
        year.selectByValue("2019");
        browser.findElement(By.id("cardHolderName")).sendKeys("Carolina");
        browser.findElement(By.id("cardSecurityCode")).sendKeys("9866");
    }


    @And("^I press the Payment Save button$")
    public void iPressThePaymentSaveButton() throws Throwable {
        browser.findElement(By.cssSelector(".edit button.data-set-payment")).click();
        Thread.sleep(DEFAULT_SLEEP_TIME);
        Assert.assertTrue("confiming credit card form is being displayed",browser
                .findElement(By.cssSelector(".edit button.submit-your-order")).isDisplayed());
    }

    @Then("^I Submit the order$")
    public void iSubmitTheOrder() throws Throwable {
        browser.findElement(By.cssSelector(".edit button.submit-your-order")).click();
        Assert.assertTrue("Confirming error message",browser
                .findElement(By.xpath("//p[contains(text(),\"We were unable to process your credit card. Please check your credit card information and resubmit your order or contact your banking institution.\")]"))
                .isDisplayed());
    }

    @And("^I fill out with correct information the shipping address form$")
    public void iFillOutWithCorrectInformationTheShippingAddressForm() throws Throwable {
        browser.findElement(By.id("address.firstName")).sendKeys("Carolina");
        browser.findElement(By.id("address.surname")).sendKeys("Machado");
        browser.findElement(By.id("address.line1")).sendKeys("45 Main St, 3rd Floor");
        browser.findElement(By.id("address.postcode")).sendKeys("11201");
        browser.findElement(By.id("address.townCity")).sendKeys("Brooklyn, NY");
        Thread.sleep(DEFAULT_SLEEP_TIME);
        state = new Select(browser.findElement(By.id("address.region")));
        state.selectByValue("US-NY");
        browser.findElement(By.id("address.phoneNumber_del")).sendKeys("+1 718 625 4843");
        browser.findElement(By.cssSelector(".edit button.data-set-address"));
    }
}