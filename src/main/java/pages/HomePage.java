package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Локаторы для обработки модального окна cookie
    private final By buttonCancelCookie = By.xpath("//div[@class='cookie__buttons']/button[2]");

    //Заголовок страницы Подробнее о сервисе
    private final By linkDetails = By.linkText("Подробнее о сервисе");
    private final By detailsPageHeader = By.xpath("//h3[contains(text()," +
            " 'Оплата банковской картой')]");

    //Заголовок блока оплаты
    private final By payBlockText = By.xpath("//div[@class='pay__wrapper']/h2");

    // Локаторы для вариантов оплаты и Placeholders для полей ввода
    private final By paymentDropdown = By.xpath("//button[@class='select__header']");
    private final By firstPlaceholderField = By.xpath("//form[contains(@class, 'opened')]/div[1]/input");
    private final By secondPlaceholderField = By.xpath("//form[contains(@class, 'opened')]/div[2]/input");
    private final By thirdPlaceholderField = By.xpath("//form[contains(@class, 'opened')]/div[3]/input");

    // Локаторы для полей ввода
    private final By phoneInput = By.xpath("//input[@class='phone']");
    private final By amountInput = By.xpath("//input[@class='total_rub']");

    // Локаторы для кнопки "Продолжить"
    private final By submitButton = By.xpath("//form[@class='pay-form opened']/button");

    // Локатор iFrame
    private final By confirmationFrame = By.xpath("//iframe[@class='bepaid-iframe']");

    // Локатор для иконок платёжных систем
    private final By paymentIcons = By.xpath("//div[@class='pay__partners']//img");

    public void closeCookieModal() {
        if (isElementDisplayed(buttonCancelCookie)) {
            click(buttonCancelCookie);
        }
    }

    public String getPayBlockText() {
        return find(payBlockText).getText();
    }

    public void clickDetailsLink() {
        click(linkDetails);
    }

    // Метод для проверки отображения заголовка
    public boolean isHeaderDetailsPageDisplayed() {
        return isElementDisplayed(detailsPageHeader);
    }

    public void fillPaymentForm(String phone, String amount) {
        sendKeys(phoneInput, phone);
        sendKeys(amountInput, amount);
        click(submitButton);
    }

    public void switchToConfirmationFrame() {
        getWait5().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(confirmationFrame));
    }

    public boolean isLogoDisplayed(String logoAltText) {
        By logoLocator = By.xpath(String.format("//img[@alt='%s']", logoAltText));
        return isElementDisplayed(logoLocator);
    }

    public int getPaymentLogosCount() {
        return getDriver().findElements(paymentIcons).size();
    }

    public void selectPaymentOption(String optionNumber, String optionName) {

        click(paymentDropdown);
        By optionLocator = By.xpath(String.format("//ul[@class='select__list']/li[%s]/p[contains(text(),'%s')]",
                optionNumber, optionName));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement element = find(optionLocator);
        js.executeScript("arguments[0].click();", element);
    }

    public boolean isPlaceholderCorrect(By fieldLocator, String expectedPlaceholder) {
        WebElement field = find(fieldLocator);
        String actualPlaceholder = (String) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].getAttribute('placeholder');", field);
        return expectedPlaceholder.equals(actualPlaceholder);
    }

    public By getFirstPlaceholderField() {
        return firstPlaceholderField;
    }

    public By getSecondPlaceholderField() {
        return secondPlaceholderField;
    }

    public By getThirdPlaceholderField() {
        return thirdPlaceholderField;
    }
}



