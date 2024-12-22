package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentIframePage extends BasePage {

    private final By confirmationTextAmount = By.xpath("//div[@class='pay-description__cost']/span");
    private final By confirmationTextButtonAmount = By.xpath("//div[@class='card-page__card']/button");
    private final By confirmationPhoneNumber = By.xpath("//div[@class='pay-description__text']/span");

    //Placeholders для полей ввода
    private final By cardNumberInput = By.xpath("//input[@id='cc-number']/following-sibling::label[1]");
    private final By cardExpirationInput = By.xpath("//input[@formcontrolname='expirationDate']/following-sibling::label[1]");
    private final By cardCVCInput = By.xpath("//input[@formcontrolname='cvc']/following-sibling::label[1]");
    private final By cardHolderInput = By.xpath("//input[@formcontrolname='holder']/following-sibling::label[1]");

    // Локатор для иконок платёжных систем
    private final By paymentIconsIframe = By.xpath("//div[contains(@class, 'icons-container')]//img");

    public PaymentIframePage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationTextAmount() {
        return find(confirmationTextAmount).getText();
    }

    public String getConfirmationTextButtonAmount() {
        return find(confirmationTextButtonAmount).getText();
    }

    public String getConfirmationPhoneNumber() {
        return find(confirmationPhoneNumber).getText();
    }

    public String getCardNumberPlaceholder() {
        return find(cardNumberInput).getText();
    }

    public String getCardExpirationPlaceholder() {
        return find(cardExpirationInput).getText();
    }

    public String getCardCVCPlaceholder() {
        return find(cardCVCInput).getText();
    }

    public String getCardHolderPlaceholder() {
        return find(cardHolderInput).getText();

    }

    public boolean isLogoDisplayedIframe(String logoSvg) {
        By logoLocator = By.xpath(String.format("//img[@src='assets/images/payment-icons/card-types/%s.svg']", logoSvg));
        return isElementDisplayed(logoLocator);
    }

    // Метод для получения количества логотипов
    public int getPaymentLogosCountIframe() {
        return getDriver().findElements(paymentIconsIframe).size();
    }
}