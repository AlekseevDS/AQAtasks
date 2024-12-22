import org.openqa.selenium.Cookie;
import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import data.TestData;
import pages.HomePage;
import pages.PaymentPageIframe;

import java.util.Set;

public class BaseTest {
    protected WebDriver driver;
//    protected BasePage basePage;
    protected HomePage homePage;
    protected PaymentPageIframe paymentPageIframe;
    protected String testNumber = TestData.getTEST_NUMBER();
    protected String testAmount = TestData.getTEST_AMOUNT();


    @BeforeMethod
    public void setUp() {
        driver = CommonActions.createDriver();
        clearCookiesAndLocalStorage();
        driver.manage().window().maximize();
        initializePages();
        homePage.closeCookieModal();
    }

    private void clearCookiesAndLocalStorage() {
        Set<Cookie> cookies = driver.manage().getCookies();
        if(!cookies.isEmpty()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    private void initializePages() {
//        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        paymentPageIframe = new PaymentPageIframe(driver);
        homePage.open();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
