import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class HomePageTest extends BaseTest {

    @Epic(value = "Оплата услуг")
    @Feature(value = "Блок платежей (Main Page)")
    @Test
    @Description(value = "Тест проверяет текст заголовка блока платежей")
    public void testNamePayBlock() {
        String payBlockName = homePage.getPayBlockText();
        Assert.assertEquals(payBlockName, "Онлайн пополнение\n" + "без комиссии");
    }

    @Epic(value = "Оплата услуг")
    @Feature(value = "Блок платежей (Main Page)")
    @Test
    @Description(value = "Тест проверяет отображение логотипов платежных систем")
    @Step("Количество лого в платежном блоке на главной странице: {actualLogoCount}")
    public void testPaymentsLogos() {

        SoftAssert softAssert = new SoftAssert();

        List<String> logoTypes = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        logoTypes.forEach(logo -> {
            boolean isDisplayed = homePage.isLogoDisplayed(logo);
            softAssert.assertTrue(isDisplayed, "Логотип '" + logo + "' не отображается.");
        });

        int actualLogoCount = homePage.getPaymentLogosCount();
        softAssert.assertEquals(actualLogoCount, 5, "Количество логотипов не соответствует ожидаемому.");
        softAssert.assertAll();
    }

    @Epic(value = "Оплата услуг")
    @Feature(value = "Блок платежей (Main Page)")
    @Test
    @Description(value = "Тест проверяет работу ссылки 'Подробнее о сервисе'")
    public void testLinkDetails() {
        homePage.clickDetailsLink();
        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
        Assert.assertTrue(homePage.isHeaderDetailsPageDisplayed());
        saveScreenshotPNG(driver);
    }

    @Epic(value = "Оплата услуг")
    @Feature(value = "Блок платежей (Main Page)")
    @Test
    @Description(value = "Тест проверяет отображение плейсхолдеров в полях блока платежей (Main Page)")
    public void testPlaceholdersForAllPaymentOptions() {
        SoftAssert softAssert = new SoftAssert();

        List<Map<String, String>> paymentOptions = List.of(
                Map.of(
                        "number", "1",
                        "option", "Услуги связи",
                        "numberPlaceholder", "Номер телефона",
                        "amountPlaceholder", "Сумма",
                        "emailPlaceholder", "E-mail для отправки чека"),
                Map.of(
                        "number", "2",
                        "option", "Домашний интернет",
                        "numberPlaceholder", "Номер абонента",
                        "amountPlaceholder", "Сумма",
                        "emailPlaceholder", "E-mail для отправки чека"),
                Map.of(
                        "number", "3",
                        "option", "Рассрочка",
                        "numberPlaceholder", "Номер счета на 44",
                        "amountPlaceholder", "Сумма",
                        "emailPlaceholder", "E-mail для отправки чека"),
                Map.of(
                        "number", "4",
                        "option", "Задолженность",
                        "numberPlaceholder", "Номер счета на 2073",
                        "amountPlaceholder", "Сумма",
                        "emailPlaceholder", "E-mail для отправки чека")
        );

        paymentOptions.forEach(option -> {
            String optionNumber = option.get("number");
            String optionName = option.get("option");
            String numberPlaceholder = option.get("numberPlaceholder");
            String amountPlaceholder = option.get("amountPlaceholder");
            String emailPlaceholder = option.get("emailPlaceholder");

            homePage.selectPaymentOption(optionNumber, optionName);

            softAssert.assertTrue(
                    homePage.isPlaceholderCorrect(homePage.getFirstPlaceholderField(), numberPlaceholder),
                    String.format("Плейсхолдер '%s' для номера в '%s' некорректен.", numberPlaceholder, optionName)
            );
            softAssert.assertTrue(
                    homePage.isPlaceholderCorrect(homePage.getSecondPlaceholderField(), amountPlaceholder),
                    String.format("Плейсхолдер '%s' для суммы в '%s' некорректен.", amountPlaceholder, optionName)
            );
            softAssert.assertTrue(
                    homePage.isPlaceholderCorrect(homePage.getThirdPlaceholderField(), emailPlaceholder),
                    String.format("Плейсхолдер '%s' для email в '%s' некорректен.", emailPlaceholder, optionName)
            );
        });

        softAssert.assertAll();
    }
}
