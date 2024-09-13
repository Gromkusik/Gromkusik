import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoToRestAssuredTest {
    @Test(priority = 1)
    public void requestGet_Status200() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .when()
                .get("/get/?foo1=bar1&foo2=bar2")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));
    }

    @Test(priority = 2)
    public void requestPostRaw_Status200() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test(priority = 3)
    public void requestPostForm_Status200() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"));
    }

    @Test(priority = 4)
    public void requestPut_Status200() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test(priority = 5)
    public void requestPatch_Status200() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test(priority = 6)
    public void requestDelete_Status200() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then().log().body()
                .assertThat()
                .statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}