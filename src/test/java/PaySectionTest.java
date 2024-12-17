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

import java.util.NoSuchElementException;

public class PaySectionTest {

    WebElement buttonCancelCookie = driver.findElement(By.className("btn btn_gray cookie__cancel"));
    WebElement textNamePayBlock = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
    WebElement imgVisa = driver.findElement(By.xpath("//img[@alt='Visa']"));
    WebElement imgVerifVisa = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
    WebElement imgMasterCard = driver.findElement(By.xpath("//img[@alt='MasterCard']"));
    WebElement imgMasterCardSec = driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']"));
    WebElement imgBelCard = driver.findElement(By.xpath("//img[@alt='Белкарт']"));
    WebElement linkDetails = driver.findElement(By.linkText("Подробнее о сервисе"));
    WebElement inputPhoneNumber = driver.findElement(By.id("connection-phone"));
    WebElement inputAmountMoney = driver.findElement(By.id("connection-sum"));
    WebElement buttonSubmitPay = driver.findElement(By.className("button button__default "));
    WebElement spanSubmitPay = driver.findElement(By.linkText("Оплата: Услуги связи\n" +
            "Номер:375297777777"));

    @BeforeTest

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        Actions actions = new Actions(driver);
        actions.moveToElement(textNamePayBlock).perform();

        //Если появляется окно Cookies
        /*WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(buttonCancelCookie));
            buttonCancelCookie.click();
        } catch (NoSuchElementException e) {
            System.out.println("Cookies нет.Кнопка 'Отказаться' не найдена.");
        }*/
    }

    @Test
    public void testNamePayBlock() {
        //Assert.assertEquals(textNamePayBlock.getText(),"Онлайн пополнение");
        System.out.println(textNamePayBlock.getText());
    }

    //TODO Сделать отдельно для картинок, если будет время, то собрать в Map в один тест

    @Test
    public void testImgVisa() {
        boolean isElementPresent = !driver.findElements(imgVisa).isEmpty();
        Assert.assertTrue(isElementPresent);
    }

    //*****
    //*****
    //*****
    //*****

    @Test
    public void testLinkDetails() {
        linkDetails.click();
        //Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
        System.out.println(driver.getTitle());

    }

    @Test
    public void testPayForm() {
        inputPhoneNumber.sendKeys("297777777");
        inputAmountMoney.sendKeys("30");
        buttonSubmitPay.click();
        Assert.assertEquals(spanSubmitPay.getText(), "Оплата: Услуги связи\n" +
                "Номер:375297777777");
    }

    @AfterTest
    public void tearDown() {
        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
