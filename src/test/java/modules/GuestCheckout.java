package modules;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import base.BaseClass;
import org.openqa.selenium.By;

public class GuestCheckout extends BaseClass {

    @When("^I press the Checkout as guest button$")
    public void iPressTheCheckoutAsGuestButton() throws Throwable {
        //Thread.sleep(DEFAULT_SLEEP_TIME);
        browser.findElement(By.id("guest.email")).sendKeys("dcmachado@gmail.com");
        browser.findElement(By.cssSelector("#guestForm button")).click();

    }

    @Given("^I go to the WestMarine Homepage$")
    public void iGoToTheWestMarineHomepage() throws Throwable {
        browser.navigate().to("https://www.westmarine.com/");
    }
}
