package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class YvesRocherLoginRestTests {

    @Test
    public void SubmitLoginFormTest() {
        String url = "https://api.y-r.by/api/v1/token";
        String body = "{\n" +
                "    \"email\": \"tbalashevich@bk.ru\",\n" +
                "    \"password\": \"PostinG@2579!\",\n" +
                "    \"remember\": true\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).
                when().post(url).
                then().assertThat().
                statusCode(200).log().body();
    }
}
