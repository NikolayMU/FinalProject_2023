package FinalProject_2023;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MyOwnPostsTest extends AbstractTest {

    @Test
    @DisplayName("Тест-кейс №1: Проверка Get запроса Своих постов")
    void test_1() {

        given()
                .header("X-Auth-Token", getToken())
                .queryParam("title", "Potatoes Free")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);
    }
    @Test
    @DisplayName("Тест-кейс №2: Проверка Get запроса Своих постов")
    void test_2() {

        given()
                .header("X-Auth-Token", getToken())
                .queryParam("id", "10952")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .header("X-Auth-Token", getToken())
                .queryParam("id", "10952")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(null));
    }

    @Test
    @DisplayName("Тест-кейс №3: Проверка Get запроса Своих постов")
    void test_3() {

        given()
                .queryParam("id", "10952")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(401);

        JsonPath response = given()
                .queryParam("id", "10952")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(null));
    }
    @Test
    @DisplayName("Тест-кейс №4: Проверка Get запроса Своих постов")
    void test_4() {

        given()
                .header("X-Auth-Token", getToken())
                .queryParam("Title", "Рис с овощами")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);

    }
    @Test
    @DisplayName("Тест-кейс №5: Проверка Get запроса Своих постов")
    void test_5() {

        given()
                .header("X-Auth-Token", getToken())
                .queryParam("title", "Рис с овощами")
                .queryParam("discription", "Рис с овощами")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(200);

    }
}
