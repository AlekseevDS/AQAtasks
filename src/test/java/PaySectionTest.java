import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class PaySectionTest {

    private WebDriver driver;
    private WebElement linkDetails;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement buttonCancelCookie = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='cookie__buttons']/button[2]")));
            buttonCancelCookie.click();
        } catch (TimeoutException e) {
            System.out.println("Cookies нет.Кнопка 'Отказаться' не найдена.");
        }
        linkDetails = driver.findElement(By.linkText("Подробнее о сервисе"));
        Actions actions = new Actions(driver);
        actions.moveToElement(linkDetails).perform();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testNamePayBlock() {
        WebElement textNamePayBlock = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        Assert.assertEquals(textNamePayBlock.getText(), "Онлайн пополнение\nбез комиссии");
    }

    @Test(enabled = false) // оптимизированный тест содержится в testPaymentsLogosSergei()
    public void testPaymentsLogos() {
        SoftAssert softAssert = new SoftAssert();

        By imgVisa = By.xpath("//img[@alt='Visa']");
        By imgVerifiedByVisa = By.xpath("//img[@alt='Verified By Visa']");
        By imgMasterCard = By.xpath("//img[@alt='MasterCard']");
        By imgMasterCardSecureCode = By.xpath("//img[@alt='MasterCard Secure Code']");
        By imgBelCard = By.xpath("//img[@alt='Белкарт']");

        softAssert.assertTrue(isElementDisplayed(imgVisa), "Логотип 'Visa' не отображается.");
        softAssert.assertTrue(isElementDisplayed(imgVerifiedByVisa), "Логотип 'Verified By Visa' не отображается.");
        softAssert.assertTrue(isElementDisplayed(imgMasterCard), "Логотип 'MasterCard' не отображается.");
        softAssert.assertTrue(isElementDisplayed(imgMasterCardSecureCode), "Логотип 'MasterCard Secure Code' не отображается.");
        softAssert.assertTrue(isElementDisplayed(imgBelCard), "Логотип 'Белкарт' не отображается.");

        int expectedLogoCount = 5;
        int actualLogoCount = driver.findElements(By.xpath("//div[@class='pay__partners']//img")).size();
        softAssert.assertEquals(actualLogoCount, expectedLogoCount, "Количество логотипов не соответствует ожидаемому.");

        softAssert.assertAll();
    }

    @Test
    public void testPaymentsLogosSergei() {
        SoftAssert softAssert = new SoftAssert();

        List<String> logoTypes = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        logoTypes.forEach(logo -> {
            softAssert.assertTrue(isElementDisplayed(By.xpath(String.format("//img[@alt='%s']", logo))));
        });

        int actualLogoCount = driver.findElements(By.xpath("//div[@class='pay__partners']//img")).size();
        softAssert.assertEquals(actualLogoCount, 5, "Количество логотипов не соответствует ожидаемому.");
        softAssert.assertAll();
    }

    private boolean isElementDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Test
    public void testLinkDetails() {
        linkDetails.click();
        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");

        WebElement expectedContent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(), 'Оплата банковской картой')]")));
        Assert.assertTrue(expectedContent.isDisplayed(), "Ожидаемый контент на странице не отображается.");
    }

    @Test
    public void testPayForm() {
        WebElement inputPhoneNumber = driver.findElement(By.xpath("//input[@class='phone']"));
        WebElement inputAmountMoney = driver.findElement(By.xpath("//input[@class='total_rub']"));
        WebElement buttonSubmitPay = driver.findElement(By.xpath("//form[@class='pay-form opened']/button"));

        inputPhoneNumber.sendKeys("297777777");
        inputAmountMoney.sendKeys("30");
        buttonSubmitPay.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
        System.out.println(driver.getTitle());

        WebElement spanSubmitPay =  wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay-description__text']/span")));

        Assert.assertEquals(spanSubmitPay.getText(), "Оплата: Услуги связи Номер:375297777777");
    }
}
