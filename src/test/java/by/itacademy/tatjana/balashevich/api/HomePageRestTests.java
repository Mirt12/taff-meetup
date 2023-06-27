package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class HomePageRestTests {
    WebDriver driver = new ChromeDriver();

    @Test
    public void OpenHomePageTest() {
        String url = "https://www.meetup.com";
        given().
                when().get(url).
                then().assertThat().
                statusCode(200).log().body();
        driver.quit();
    }
}
