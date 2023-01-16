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
    void getSpecifyingRequestDataTest_1() {

        given()
                .header("X-Auth-Token", getToken())
                .queryParam("query", "жаренные сосиски")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("query", "жаренные сосиски")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(null));
    }
    @Test
    @DisplayName("Тест-кейс №2: Проверка Get запроса Чужих постов")
    void getSpecifyingRequestTest_2() {

        given()
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
    @Test
    @DisplayName("Тест-кейс №3: Проверка Get запроса Чужих постов")
    void getSpecifyingRequestDataTest_3() {

        given()
                .header("X-Auth-Token", getToken())
                .queryParam("id", "11038")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("id", "11038")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC&page=1")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(null));
    }
    @Test
    @DisplayName("Тест-кейс №4: Проверка Get запроса Чужих постов")
    void getSpecifyingRequestDataTest_4() {

        given()
                .header("X-Auth-Token", getToken())
                .queryParam("title", "Русские пельмени")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("title", "Русские пельмени")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(null));
    }
    @Test
    @DisplayName("Тест-кейс №5: Проверка Get запроса Чужих постов")
    void getSpecifyingRequestDataTest_5() {

        given()
                .header("X-Auth-Token", getToken())
                .queryParam("description", "")
                .queryParam("id", "11038")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("description", "")
                .queryParam("id", "11038")
                .when()
                .get("https://test-stand.gb.ru/api/posts?owner=notMe")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(null));
    }
}


