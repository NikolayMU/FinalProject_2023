package FinalProject_2023;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoggingTest extends AbstractTest {

        @BeforeAll
        static void setUp(){

            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        }

        @Test
        void getRequestLogTest() {
            given()
                    .contentType("multipart/form-data")
                    .multiPart("username", "1234")
                    .multiPart("password", "81dc9bdb52")
                    .when()
                    .post("https://test-stand.gb.ru/login")
                    .then()
                    .statusCode(200);

            System.out.println("Запрос выполнен");

        }
/* Передаем валидные значения для авторизации пользователя*/
        @Test
        void postResponseLogTest(){
            given()
                    .contentType("multipart/form-data")
                    .multiPart("username", "1234")
                    .multiPart("password", "81dc9bdb52")
                    .when()
                    .post("https://test-stand.gb.ru/gateway/login")
                    .then()
                    .statusCode(200);


        }

    /* Передаем невалидные значения для авторизации пользователя*/
    @Test
    void InvalidLogTest(){

            given()
                    .contentType("multipart/form-data")
                    .multiPart("username", "1234")
                    .multiPart("password", "81dc9bdb51")
                    .when()
                    .post("https://test-stand.gb.ru/gateway/login")
                    .then()
                    .statusCode(401);
    }

        @Test
        void getErrorTest(){
            given()
                    .queryParam("apiKey", getApiKey())
                    .when()
                    .post("https://test-stand.gb.ru/gateway/login")
                    .then().statusCode(400);
        }
    }

