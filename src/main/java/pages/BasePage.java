package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
        return wait5;
    }

    protected WebElement find(By locator) {
        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            getWait5().until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
