package FinalProject_2023;


import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class OtherPostsTest extends AbstractTest {

    @Test
    @DisplayName("Тест-кейс №1: Проверка Get запроса Чужих постов")
    void getSpecifyingRequestDataTest_2() {

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "жаренные сосиски")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "жаренные сосиски")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(1));
    }
    @Test
    @DisplayName("Тест-кейс №2: Проверка Get запроса Чужих постов")
    void getSpecifyingRequestDataTest_2() {

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "жаренные сосиски")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(401);

        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "жаренные сосиски")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(null));
    }
}


