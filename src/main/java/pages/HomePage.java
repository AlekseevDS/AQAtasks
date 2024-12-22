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

    //TODO перенести в отдельные классы локаторы и тестовые методв для iframe

    //Локаторы для обработки модального окна cookie
    private final By buttonCancelCookie = By.xpath("//div[@class='cookie__buttons']/button[2]");

    //Заголовок страницы Подробнее о сервисе
    private final By linkDetails = By.linkText("Подробнее о сервисе");
    private final By detailsPageHeader = By.xpath("//h3[contains(text()," +
            " 'Оплата банковской картой')]");

    //Заголовок блока оплаты
    private final By payBlockText = By.xpath("//div[@class='pay__wrapper']/h2");

    // Локаторы для вариантов оплаты и input PlaceholderField
    private final By paymentDropdown = By.xpath("//button[@class='select__header']");
    private final By firstPlaceholderField = By.xpath("//form[contains(@class, 'opened')]/div[1]/input");
    private final By secondPlaceholderField = By.xpath("//form[contains(@class, 'opened')]/div[2]/input");
    private final By thirdPlaceholderField = By.xpath("//form[contains(@class, 'opened')]/div[3]/input");

    // Локаторы для полей ввода
    private final By phoneInput = By.xpath("//input[@class='phone']");
    private final By amountInput = By.xpath("//input[@class='total_rub']");


    // Локаторы для кнопки "Продолжить"
    private final By submitButton = By.xpath("//form[@class='pay-form opened']/button");

    // Локаторы для проверки данных в окне подтверждения
    private final By confirmationFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By confirmationAmount = By.xpath("//div[@class='pay-description__text']/span[contains(text(), 'Сумма')]");
    private final By confirmationPhoneNumber = By.xpath("//div[@class='pay-description__text']/span[contains(text(), 'Номер')]");

    // Локатор для иконок платёжных систем
    private final By paymentIcons = By.xpath("//div[@class='pay__partners']//img");

    public void open() {
        driver.get("https://www.mts.by/");
    }

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
        getWait10().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(confirmationFrame));
    }

    public String getConfirmationAmount() {
        return find(confirmationAmount).getText();
    }

    public String getConfirmationPhoneNumber() {
        return find(confirmationPhoneNumber).getText();
    }

    // Метод для проверки отображения логотипа по alt-тексту
    public boolean isLogoDisplayed(String logoAltText) {
        By logoLocator = By.xpath(String.format("//img[@alt='%s']", logoAltText));
        return isElementDisplayed(logoLocator);
    }

    // Метод для получения количества логотипов
    public int getPaymentLogosCount() {
        return driver.findElements(paymentIcons).size();
    }


    // Метод для выбора варианта оплаты из выпадающего меню
    public void selectPaymentOption(String optionNumber, String optionName) {

        click(paymentDropdown);
        By optionLocator = By.xpath(String.format("//ul[@class='select__list']/li[%s]/p[contains(text(),'%s')]",
                optionNumber,optionName));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = find(optionLocator);
        js.executeScript("arguments[0].click();", element);


    }

    // Проверка плейсхолдеров в незаполненных полях

    public boolean isPlaceholderCorrect(By fieldLocator, String expectedPlaceholder) {
        WebElement field = find(fieldLocator);
        String actualPlaceholder = (String) ((JavascriptExecutor) driver)
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



