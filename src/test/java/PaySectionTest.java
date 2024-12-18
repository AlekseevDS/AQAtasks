import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.NoSuchElementException;

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

        WebElement buttonCancelCookie = driver.findElement(By.xpath("//div[@class='cookie__buttons']/button[2]"));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(buttonCancelCookie));
            buttonCancelCookie.click();
        } catch (NoSuchElementException e) {
            System.out.println("Cookies нет.Кнопка 'Отказаться' не найдена.");
        }

        linkDetails = driver.findElement(By.linkText("Подробнее о сервисе"));
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(linkDetails));
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

    @Test
    public void testImgVisaVerif() {
        By imgVerifVisa = By.xpath("//img[@alt='Visa']");
        boolean isElementPresent = !driver.findElements(imgVerifVisa).isEmpty();
        Assert.assertTrue(isElementPresent);
    }

    @Test
    public void testImgMc() {
        By imgMasterCard = By.xpath("//img[@alt='MasterCard']");
        boolean isElementPresent = !driver.findElements(imgMasterCard).isEmpty();
        Assert.assertTrue(isElementPresent);
    }

    @Test
    public void testImgMcSec() {
        By imgMasterCardSec = By.xpath("//img[@alt='MasterCard Secure Code']");
        boolean isElementPresent = !driver.findElements(imgMasterCardSec).isEmpty();
        Assert.assertTrue(isElementPresent);
    }

    @Test
    public void testImgBelCard() {
        By imgBelCard = By.xpath("//img[@alt='Белкарт']");
        boolean isElementPresent = !driver.findElements(imgBelCard).isEmpty();
        Assert.assertTrue(isElementPresent);
    }

    @Test
    public void testLinkDetails() {
        linkDetails.click();
        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
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
