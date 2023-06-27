package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class LoginFormRestTests {
    WebDriver driver = new ChromeDriver();

    @Test
    public void OpenLoginFormTest() {
        //how to open login Form?
        String url = "https://www.meetup.com";
        given().
                when().get(url).
                then().assertThat().
                statusCode(200).log().body();
        driver.quit();
    }

    @Test
    public void SubmitLoginFormTest() {
        String url = "https://www.meetup.com/gql";
        String body = "{\n" +
                "    \"operationName\": \"requireCaptcha\",\n" +
                "    \"variables\": {\n" +
                "        \"captchaType\": \"LOGIN\"\n" +
                "    },\n" +
                "    \"query\": \"query requireCaptcha($captchaType: CaptchaType) {\\n  requireCaptcha(captchaType: $captchaType) {\\n    requireCaptcha\\n    error {\\n      ...Error\\n      __typename\\n    }\\n    __typename\\n  }\\n}\\n\\nfragment Error on PayloadError {\\n  code\\n  message\\n  field\\n  __typename\\n}\\n\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).
                when().post(url).
                then().assertThat().
                statusCode(200).log().body();
        driver.quit();
    }
}
