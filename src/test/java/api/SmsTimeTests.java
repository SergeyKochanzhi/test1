package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;



public class SmsTimeTests {

    @BeforeAll
    public static void setUp() throws InterruptedException {
        Thread.sleep(61000);
    }

    private int delay = 61000;

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(delay);
    }

    @Test
    public void checkSecondSms1() throws InterruptedException {
        delay = 50000;
        sendRequest();

        Thread.sleep(10000);

        Response response2 = sendRequest();

        Assertions.assertEquals(400, response2.statusCode());
        System.out.println("response.statusCode() " + response2.statusCode());
        System.out.println(response2.body().asString());



    }

    public Response sendRequest(){
        String requestBody = "{\n" +
                "  \"phone\": 79398813569,\n" +
                "  \"device_type\": 2,\n" +
                "  \"resend\": true,\n" +
                "  \"country\": \"RU\",\n" +
                "  \"device_uuid\": \"2924f202-e89c-4136-ac2f-bde9819e9329\"\n" +
                "}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("https://ext-courier-stage.wb.ru/gw/api/v1/login")
                .then()
                .extract().response();
        return response;
    }

    @Test
    public void checkSms2() throws InterruptedException {
        delay = 32000;
        sendRequest();

        Thread.sleep(30000);

        Response secondResponse = sendRequest();


        Assertions.assertEquals(400, secondResponse.statusCode());
        System.out.println("response.statusCode() " + secondResponse.statusCode());
        System.out.println(secondResponse.body().asString());

    }
    @Test
    public void checkSms3() throws InterruptedException {
        delay = 12000;
        sendRequest();

        Thread.sleep(50000);

        Response secondResponse = sendRequest();

        Assertions.assertEquals(400, secondResponse.statusCode());
        System.out.println("response.statusCode() " + secondResponse.statusCode());
        System.out.println(secondResponse.body().asString());
    }
    @Test
    public void checkSecondSms4() throws InterruptedException {
        delay = 61000;
        sendRequest();

        Thread.sleep(61000);

        Response secondResponse = sendRequest();

        Assertions.assertEquals(200, secondResponse.statusCode());
        System.out.println("response.statusCode() " + secondResponse.statusCode());
        System.out.println(secondResponse.body().asString());


    }

}
