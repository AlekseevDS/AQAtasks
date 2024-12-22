import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class PaymentIframePageTest extends BaseTest {

    @Test
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

    @Test
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

    @Test
    public void testPaymentsLogos() {
        homePage.fillPaymentForm(testNumber, testAmount);
        homePage.switchToConfirmationFrame();

        SoftAssert softAssert = new SoftAssert();

        List<String> logoTypes = List.of(
                "visa-system",
                "mastercard-system",
                "belkart-system",
                "maestro-system",
                "mir-system-ru");

        for (String logo : logoTypes) {

            boolean isDisplayed = paymentPageIframe.isLogoDisplayedIframe(logo);
            softAssert.assertTrue(isDisplayed, "Логотип '" + logo + "' не отображается.");
        }

        int actualLogoCount = paymentPageIframe.getPaymentLogosCountIframe();
        softAssert.assertEquals(actualLogoCount, 5, "Количество логотипов не соответствует ожидаемому.");
        softAssert.assertAll();
    }

}
