package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonActions {
    public static WebDriver createDriver() {
        return new ChromeDriver();
    }
}
