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
                    .queryParam("apiKey", getApiKey())
                    .log().method()
                    .log().params()
                    .when()
                    .post(" https://test-stand.gb.ru/gateway/login");

            System.out.println("Запрос выполнен");

        }
/* Передаем валидные значения для авторизации пользователя*/
        @Test
        void postResponseLogTest(){
            given()
                    .auth().form("1234", "81dc9bdb52")
                    .log().all()
                    .when()
                    .post("https://test-stand.gb.ru/gateway/login")
                    .then().statusCode(200);
        }

    /* Передаем невалидные значения для авторизации пользователя*/
    @Test
    void InvalidLogTest(){
        given()
                .queryParam("apiKey_2", getApiKey())
                .log().all()
                .when()
                .post("https://test-stand.gb.ru/gateway/login")
                .prettyPeek();
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

