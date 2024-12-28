import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import common.CommonActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import data.TestData;
import org.testng.annotations.Listeners;
import pages.HomePage;
import pages.PaymentIframePage;

import java.util.Set;

@Listeners({CustomTestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected PaymentIframePage paymentPageIframe;
    protected String testNumber = TestData.getTEST_NUMBER();
    protected String testAmount = TestData.getTEST_AMOUNT();
    protected String url = TestData.getURL();

    @BeforeMethod
    public void setUp() {
        driver = CommonActions.createDriver();
        clearCookiesAndLocalStorage();
        driver.manage().window().maximize();
        open();
        initializePages();
        homePage.closeCookieModal();
    }

    public void open() {
        driver.get(url);
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
        homePage = new HomePage(driver);
        paymentPageIframe = new PaymentIframePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
