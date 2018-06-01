package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver browser;

    public BaseClass(){
        browser = getBrowser();
    }

    // Validate if browser has been instantiated, if not it will initialized it (singleton)
    public WebDriver getBrowser() {
        if(browser == null) {
            browser = new ChromeDriver();
            browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return browser;
    }
}
