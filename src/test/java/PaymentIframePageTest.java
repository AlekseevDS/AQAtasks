import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class PaymentIframePageTest extends BaseTest {

    @Epic(value = "Оплата услуг")
    @Feature(value = "Блок платежей. Детали оплаты (iFrame)")
    @Test
    @Owner("AlekseevDS")
    @Description(value = "Тест проверяет отображение текста и корректных данных подтверждения оплаты")

    public void testPaymentConfirmationTextAndAmount() {
        homePage.fillPaymentForm(testNumber, testAmount);
        homePage.switchToConfirmationFrame();

        String confirmationAmount = paymentPageIframe.getConfirmationTextAmount();
        String confirmationPhoneNumber = paymentPageIframe.getConfirmationPhoneNumber();
        String confirmationTextButtonAmount = paymentPageIframe.getConfirmationTextButtonAmount();

        Assert.assertTrue(confirmationAmount.contains(testAmount + " BYN"), "Сумма не соответствует ожидаемой.");
        Assert.assertTrue(confirmationPhoneNumber.contains("Оплата: Услуги связи Номер:375" + testNumber),
                "Номер телефона не соответствует ожидаемому.");
        Assert.assertEquals(confirmationTextButtonAmount, "Оплатить " + testAmount + " BYN");
    }

    @Epic(value = "Оплата услуг")
    @Feature(value = "Блок платежей. Детали оплаты (iFrame)")
    @Test
    @Owner("AlekseevDS")
    @Description(value = "Тест проверяет отображение плейсхолдеров в полях данных платежной карты")
    public void testCardInputPlaceholders() {
        homePage.fillPaymentForm(testNumber, testAmount);
        homePage.switchToConfirmationFrame();

        Map<String, String> placeholders = Map.of(
                paymentPageIframe.getCardNumberPlaceholder(), "Номер карты",
                paymentPageIframe.getCardExpirationPlaceholder(), "Срок действия",
                paymentPageIframe.getCardCVCPlaceholder(), "CVC",
                paymentPageIframe.getCardHolderPlaceholder(), "Имя держателя (как на карте)"
        );

        placeholders.forEach((actualPlaceholder, expectedPlaceholder) -> {
            boolean isCorrect = expectedPlaceholder.equals(actualPlaceholder);
            Assert.assertTrue(isCorrect,
                    String.format("Ожидаемый плейсхолдер: '%s' не соответствует актуальному: '%s'.",
                            expectedPlaceholder, actualPlaceholder));
        });
    }

    @Epic(value = "Оплата услуг")
    @Feature(value = "Блок платежей. Детали оплаты (iFrame)")
    @Test
    @Owner("AlekseevDS")
    @Description(value = "Тест проверяет отображение логотипов платежных систем")
    @Step("Количество лого в платежном блоке на главной странице: {actualLogoCount}")
    public void testPaymentsLogos() {
        homePage.fillPaymentForm(testNumber, testAmount);
        homePage.switchToConfirmationFrame();

        SoftAssert softAssert = new SoftAssert();

        List<String> logoTypes = List.of(
                "visa-system",
                "mastercard-system",
                "belkart-system",
                "maestro-system",
                "mir-system");

        for (String logo : logoTypes) {

            boolean isDisplayed = paymentPageIframe.isLogoDisplayedIframe(logo);
            softAssert.assertTrue(isDisplayed, "Логотип '" + logo + "' не отображается.");
        }

        int actualLogoCount = paymentPageIframe.getPaymentLogosCountIframe();
        softAssert.assertEquals(actualLogoCount, 5, "Количество логотипов не соответствует ожидаемому.");
        softAssert.assertAll();
    }
}
