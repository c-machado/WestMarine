package common;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import base.BaseClass;

public class Common extends BaseClass {
    @Then("^I should be at the \"([^\"]*)\" page$")
    public void iShouldBeAtThePage(String pagePath) throws Throwable {
        Assert.assertTrue("confirming the url contains this path: "+ pagePath, browser.getCurrentUrl().contains(pagePath));
    }

}
