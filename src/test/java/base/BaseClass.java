package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver browser;

    public BaseClass(){
        browser = new ChromeDriver();
    }
}
