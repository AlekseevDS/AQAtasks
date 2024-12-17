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
    private WebElement textNamePayBlock;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();

        textNamePayBlock = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));

        //Если появляется окно Cookies
        WebElement buttonCancelCookie = driver.findElement(By.xpath("//div[@class='cookie__buttons']/button[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(buttonCancelCookie));
            buttonCancelCookie.click();
        } catch (NoSuchElementException e) {
            System.out.println("Cookies нет.Кнопка 'Отказаться' не найдена.");
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(textNamePayBlock).perform();
    }

    @AfterTest
    public void tearDown() {
        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testNamePayBlock() {
        Assert.assertEquals(textNamePayBlock.getText(),"Онлайн пополнение\nбез комиссии");
    }


    @Test
    public void testImgVisaVerif() {
        WebElement imgVerifVisa = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
        boolean isElementPresent = !driver.findElements((By) imgVerifVisa).isEmpty();
        Assert.assertTrue(isElementPresent);
    }

    @Test
    public void testImgMc() {
        WebElement imgMasterCard = driver.findElement(By.xpath("//img[@alt='MasterCard']"));
        boolean isElementPresent = !driver.findElements((By) imgMasterCard).isEmpty();
        Assert.assertTrue(isElementPresent);
    }

    @Test
    public void testImgMcSec() {
        WebElement imgMasterCardSec = driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']"));
        boolean isElementPresent = !driver.findElements((By) imgMasterCardSec).isEmpty();
        Assert.assertTrue(isElementPresent);
    }

    @Test
    public void testImgBelCard() {
        WebElement imgBelCard = driver.findElement(By.xpath("//img[@alt='Белкарт']"));
        boolean isElementPresent = !driver.findElements((By) imgBelCard).isEmpty();
        Assert.assertTrue(isElementPresent);
    }


    @Test
    public void testLinkDetails() {
        WebElement linkDetails = driver.findElement(By.linkText("Подробнее о сервисе"));
        linkDetails.click();
        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
    }

    @Test
    public void testPayForm() {
        WebElement inputPhoneNumber = driver.findElement(By.id("connection-phone"));
        WebElement inputAmountMoney = driver.findElement(By.id("connection-sum"));
        WebElement buttonSubmitPay = driver.findElement(By.className("button button__default "));
        WebElement spanSubmitPay = driver.findElement(By.linkText("Оплата: Услуги связи\n" +
                "Номер:375297777777"));

        inputPhoneNumber.sendKeys("297777777");
        inputAmountMoney.sendKeys("30");
        buttonSubmitPay.click();
        Assert.assertEquals(spanSubmitPay.getText(), "Оплата: Услуги связи\n" +
                "Номер:375297777777");
    }
}
