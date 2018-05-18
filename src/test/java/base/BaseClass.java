package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver browser;

    public BaseClass(){
        browser = getBrowser();
    }

    // Validate if browser has been instantiated, if not it will initialized it (singleton)
    public WebDriver getBrowser() {
        if(browser == null) {
            browser = new ChromeDriver();
        }
        return browser;
    }
}
