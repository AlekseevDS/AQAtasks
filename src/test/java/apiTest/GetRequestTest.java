package apiTest;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static specification.Specifications.requestSpecification;

public class GetRequestTest {

    @Test
    @DisplayName("Тестирование GET Request Woops c проверкой key/value")
    public void testGetRequestCheckResponseJsonBody() {
        RestAssured.given()
                .spec(requestSpecification())
                .accept("*/*")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/get")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("args.foo1", Matchers.is("bar1"))
                .body("args.foo2", Matchers.is("bar2"))
                .body("headers.host", Matchers.is("postman-echo.com"))
                .body("headers['x-request-start']", Matchers.startsWith("t"))
                .body("headers.connection", Matchers.is("close"))
                .body("headers['x-forwarded-proto']", Matchers.is("https"))
                .body("headers['x-forwarded-port']", Matchers.is("443"))
                .body("headers['x-amzn-trace-id']", Matchers.startsWith("Root="))
                .body("headers['user-agent']", Matchers.containsString("PostmanRuntime"))
                .body("headers.accept", Matchers.is("*/*"))
                //postman-token не проверяется,т.к. запрос через RestAssured
                .body("url", Matchers.is("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));

    }

    @Test
    @DisplayName("Тестирование POST Raw Text с проверкой key/value")
    public void testPostRawRequestCheckResponseJsonBody() {
        RestAssured.given()
                .spec(requestSpecification())
                .accept("*/*")
                .contentType("text/plain")
                .header("Accept-Encoding", "gzip, deflate, br")
                .body("{\n    \"test\": \"value\"\n}")
                .post("/post")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("args", Matchers.anEmptyMap())
                .body("data", Matchers.is("{\n    \"test\": \"value\"\n}"))
                .body("files", Matchers.anEmptyMap())
                .body("form", Matchers.anEmptyMap())
                .body("headers.host", Matchers.is("postman-echo.com"))
                .body("headers['x-request-start']", Matchers.startsWith("t"))
                .body("headers.connection", Matchers.is("close"))
                .body("headers['content-length']", Matchers.is("23"))
                .body("headers['x-forwarded-proto']", Matchers.is("https"))
                .body("headers['x-forwarded-port']", Matchers.is("443"))
                .body("headers['x-amzn-trace-id']", Matchers.startsWith("Root="))
                .body("headers['content-type']", Matchers.containsString("text/plain"))
                .body("headers['user-agent']", Matchers.containsString("PostmanRuntime"))
                .body("headers.accept", Matchers.is("*/*"))
                //postman-token не проверяется,т.к. запрос через RestAssured
                .body("headers['accept-encoding']", Matchers.is("gzip, deflate, br"))
                .body("json", Matchers.nullValue())
                .body("url", Matchers.is("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("Тестирование POST Form Data с проверкой key/value")
    public void testPostFoemRequestCheckResponseJsonBody() {
        RestAssured.given()
                .spec(requestSpecification())
                .accept("*/*")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .header("Accept-Encoding", "gzip, deflate, br")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .post("/post")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("args", Matchers.anEmptyMap())
                .body("data", Matchers.is(""))
                .body("files", Matchers.anEmptyMap())
                .body("form.foo1", Matchers.is("bar1"))
                .body("form.foo2", Matchers.is("bar2"))
                .body("headers.host", Matchers.is("postman-echo.com"))
                .body("headers['x-request-start']", Matchers.startsWith("t"))
                .body("headers.connection", Matchers.is("close"))
                .body("headers['content-length']", Matchers.is("19"))
                .body("headers['x-forwarded-proto']", Matchers.is("https"))
                .body("headers['x-forwarded-port']", Matchers.is("443"))
                .body("headers['x-amzn-trace-id']", Matchers.startsWith("Root="))
                .body("headers['content-type']", Matchers.containsString("application/x-www-form-urlencoded"))
                .body("headers['user-agent']", Matchers.containsString("PostmanRuntime"))
                .body("headers.accept", Matchers.is("*/*"))
                //postman-token не проверяется,т.к. запрос через RestAssured
                .body("headers['accept-encoding']", Matchers.is("gzip, deflate, br"))
                .body("json.foo1", Matchers.is("bar1"))
                .body("json.foo2", Matchers.is("bar2"))
                .body("url", Matchers.is("https://postman-echo.com/post"));
    }
}

