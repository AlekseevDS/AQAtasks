package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPageIframe extends BasePage {

    private final By confirmationText = By.xpath("//div[@class='pay-description__text']/span");
//    TODO xpath найти
    private final By confirmationAmount = By.xpath("//div[@class='pay-description__text']/span");
//    TODO xpath найти
    private final By confirmationPhoneNumber = By.xpath("//div[@class='pay-description__text']/span");
    //    TODO для плейс холдеров или в map по аналогии с homePage
    private final By cardNumberInput = By.xpath("//input[@class='card-number']");
    private final By cardHolderInput = By.xpath("//input[@class='card-holder']");
    private final By cardExpirationInput = By.xpath("//input[@class='card-expiration']");
    private final By cardCVCInput = By.xpath("//input[@class='card-cvc']");

    public PaymentPageIframe(WebDriver driver) {
        super(driver);
    }

    // Метод для получения текста подтверждения
    public String getConfirmationText() {
        return find(confirmationText).getText();
    }

    public String getConfirmationAmount() {
        return find(confirmationAmount).getText();
    }

    public String getConfirmationPhoneNumber() {
        return find(confirmationPhoneNumber).getText();
    }
}