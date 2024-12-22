import org.testng.Assert;
import org.testng.annotations.Test;

import data.TestData;

public class PaymentPageIframeTest extends BaseTest {

    @Test
    public void testConfirmationText() {
        // Заполняем форму оплаты на основной странице
        homePage.fillPaymentForm(testNumber, testAmount);

        // Переключаемся на iframe подтверждения
        homePage.switchToConfirmationFrame();
//        PaymentPageIframe paymentIframe = new PaymentPageIframe(driver);

        String confirmationAmount = paymentPageIframe.getConfirmationAmount();
        String confirmationPhoneNumber = paymentPageIframe.getConfirmationPhoneNumber();


        Assert.assertTrue(confirmationAmount.contains(testAmount), "Сумма не соответствует ожидаемой.");
        Assert.assertTrue(confirmationPhoneNumber.contains("375" + testNumber), "Номер телефона не соответствует ожидаемому.");
//TODO Написать проверку платежек в iframe  (переиспользование?)
        //Assert.assertTrue(homePage.arePaymentIconsDisplayed(), "Иконки платёжных систем не отображаются.");
//TODO проверка плейсхолдеров в незаполненных полях ввода карты (переиспользование?)

    }
}
