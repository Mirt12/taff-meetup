package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePageRestTests {
    @Test
    public void openBrowserTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.meetup.com/");
        Thread.sleep(2000);
        String homePageAcceptCookiesBtnLocator = "//button[@id='onetrust-accept-btn-handler']";
        WebElement submitCookiesBtn = driver.findElement(By.xpath(homePageAcceptCookiesBtnLocator));
        submitCookiesBtn.click();
        //to check GET response
        driver.quit();
    }
}
