package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class IncorrectPhoneNumberTests {



    @Test
    public void IsEmptyPhoneNumber() {
        String requestBody = "{\n" +
                "  \"phone\": \n" +
                "  \"device_type\": 2,\n" +
                "  \"resend\": true,\n" +
                "  \"country\": \"RU\",\n" +
                "  \"device_uuid\": \"2924f202-e89c-4136-ac2f-bde9819e9329\"\n" +
                "}";

        Response response = given()
                .body(requestBody)
                .when()
                .post("https://ext-courier-stage.wb.ru/gw/api/v1/login")
                .then()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
        System.out.println("response.statusCode() " + response.statusCode());
        System.out.println(response.body().asString());

    }
    @Test
    public void testTooLongPhoneNumber() {
        String requestBody = "{\n" +
                "  \"phone\": 793988135698,\n" +
                "  \"device_type\": 2,\n" +
                "  \"resend\": true,\n" +
                "  \"country\": \"RU\",\n" +
                "  \"device_uuid\": \"2924f202-e89c-4136-ac2f-bde9819e9329\"\n" +
                "}";

        Response response = given()
                .and()
                .body(requestBody)
                .when()
                .post("https://ext-courier-stage.wb.ru/gw/api/v1/login")
                .then()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
        System.out.println("response.statusCode() " + response.statusCode());
        System.out.println(response.body().asString());
    }


    @Test
    public void testTooShortPhoneNumber() {
        String requestBody = "{\n" +
                "  \"phone\": 7939881356,\n" +
                "  \"device_type\": 2,\n" +
                "  \"resend\": true,\n" +
                "  \"country\": \"RU\",\n" +
                "  \"device_uuid\": \"2924f202-e89c-4136-ac2f-bde9819e9329\"\n" +
                "}";

        Response response = given()
                .and()
                .body(requestBody)
                .when()
                .post("https://ext-courier-stage.wb.ru/gw/api/v1/login")
                .then()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
        System.out.println("response.statusCode() " + response.statusCode());
        System.out.println(response.body().asString());
    }
    @Test
    public void checkUzNumberFromRu() {
        String requestBody = "{\n" +
                "  \"phone\": 998714444444,\n" +
                "  \"device_type\": 2,\n" +
                "  \"resend\": true,\n" +
                "  \"country\": \"RU\",\n" +
                "  \"device_uuid\": \"2924f202-e89c-4136-ac2f-bde9819e9329\"\n" +
                "}";

        Response response = given()
                .and()
                .body(requestBody)
                .when()
                .post("https://ext-courier-stage.wb.ru/gw/api/v1/login")
                .then()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
        System.out.println("response.statusCode() " + response.statusCode());
        System.out.println(response.body().asString());
    }

    @Test
    public void checkRuNumberFromUz() {
        String requestBody = "{\n" +
                "  \"phone\": 79398813569,\n" +
                "  \"device_type\": 2,\n" +
                "  \"resend\": true,\n" +
                "  \"country\": \"UZ\",\n" +
                "  \"device_uuid\": \"2924f202-e89c-4136-ac2f-bde9819e9329\"\n" +
                "}";

        Response response = given()
                .and()
                .body(requestBody)
                .when()
                .post("https://ext-courier-stage.wb.ru/gw/api/v1/login")
                .then()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
        System.out.println("response.statusCode() " + response.statusCode());
        System.out.println(response.body().asString());
    }



}
