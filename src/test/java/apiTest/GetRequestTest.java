package apiTest;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static specification.Specifications.requestSpecification;

public class GetRequestTest {

    @Test
    @DisplayName("Тестирование запроса Get c проверкой key/value") //TODO DelIfNotUse  DinU DU
    public void testGetRequestCheckResponseJsonBody() {
        RestAssured.given()
                .spec(requestSpecification())
                .accept("*/*")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                //.log().all()
                .get("/get")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                // Проверка ключей в секции args
                .body("args.foo1", Matchers.is("bar1"))
                .body("args.foo2", Matchers.is("bar2"))
                // Проверка ключей в секции headers
                .body("headers.host", Matchers.is("postman-echo.com"))
                .body("headers['x-request-start']", Matchers.startsWith("t")) // Проверяем, что начинается с "t"
                .body("headers.connection", Matchers.is("close"))
                .body("headers['x-forwarded-proto']", Matchers.is("https"))
                .body("headers['x-forwarded-port']", Matchers.is("443"))
                .body("headers['x-amzn-trace-id']", Matchers.startsWith("Root=")) // Проверяем, что начинается с "Root="
                .body("headers['user-agent']", Matchers.containsString("PostmanRuntime")) // Проверяем наличие строки "PostmanRuntime"
                .body("headers.accept", Matchers.is("*/*"))
                //postman-token не проверяется,т.к. запрос через RestAssured
                //.body("headers['postman-token']", Matchers.notNullValue()) // Проверяем, что токен существует
                // Проверка ключа url
                .body("url", Matchers.is("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));

    }
}
