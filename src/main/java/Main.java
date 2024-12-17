import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        WebElement buttonCancelCookie = driver.findElement(By.className("btn btn_gray cookie__cancel"));
        WebElement textNamePayBlock = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        WebElement imgBelCard = driver.findElement(By.xpath("//img[@alt='Белкарт']"));
        WebElement linkDetails = driver.findElement(By.linkText("Подробнее о сервисе"));
        WebElement inputPhoneNumber = driver.findElement(By.id("connection-phone"));
        WebElement inputAmountMoney = driver.findElement(By.id("connection-sum"));
        WebElement buttonSubmitPay = driver.findElement(By.className("button button__default "));

        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).perform();




        //driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        // driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //driver.get("http://redmine.testbase.ru/");

        //WebElement checkBoxes = driver.findElement(By.xpath("//*[@id=\"page#0-0-0\"]/div/div/div/div[2]/div[3]/a"));
        //WebElement submitButton = driver.findElement(By.cssSelector("button"));


        WebElement help = driver.findElement(By.className("help"));

        //textBox.sendKeys("Selenium");
        help.click();

        //driver.quit();
    }
}
