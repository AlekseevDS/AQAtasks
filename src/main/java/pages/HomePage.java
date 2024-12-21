package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By buttonCancelCookie = By.xpath("//div[@class='cookie__buttons']/button[2]");
    private final By payBlockHeader = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By linkDetails = By.linkText("Подробнее о сервисе");
    private final By phoneInput = By.xpath("//input[@class='phone']");
    private final By amountInput = By.xpath("//input[@class='total_rub']");
    private final By submitButton = By.xpath("//form[@class='pay-form opened']/button");
    private final By confirmationFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By confirmationAmount = By.xpath("//div[@class='pay-description__text']/span[contains(text(), 'Сумма')]");
    private final By confirmationPhoneNumber = By.xpath("//div[@class='pay-description__text']/span[contains(text(), 'Номер')]");
    private final By paymentIcons = By.xpath("//div[@class='pay__partners']//img");

    //TODO добавить open URL?

    public void closeCookiesPopup() {
        try {
            if (isElementDisplayed(buttonCancelCookie)) {
                click(buttonCancelCookie);
                System.out.println("Кнопка 'Отказаться' нажата.");
            }
        } catch (Exception e) {
            System.out.println("Cookies нет. Кнопка 'Отказаться' не найдена.");
        }
    }

    public String getPayBlockHeaderText() {
        return find(payBlockHeader).getText();
    }

    public void clickDetailsLink() {
        click(linkDetails);
    }

    public void fillPaymentForm(String phone, String amount) {
        sendKeys(phoneInput, phone);
        sendKeys(amountInput, amount);
        click(submitButton);
        driver.switchTo().frame(find(confirmationFrame));
    }

    public String getConfirmationAmount() {
        return find(confirmationAmount).getText();
    }

    public String getConfirmationPhoneNumber() {
        return find(confirmationPhoneNumber).getText();
    }

    public boolean arePaymentIconsDisplayed() {
        return !driver.findElements(paymentIcons).isEmpty();
    }
}



