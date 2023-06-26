package by.itacademy.tatjana.balashevich.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginFormRestTests {
    @Test
    public void openLoginForm() throws InterruptedException {
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
        //open LoginForm:
        String homePageInloggenLinkLocator = "//header//span[@class='u-show-block@screen-xl-up' and contains(text(),'Inloggen')]";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageInloggenLinkLocator));
        loginFormLink.click();
        //to check GET response
        driver.quit();
    }
    @Test
    public void toFillLoginFormByCorrectData() throws InterruptedException {
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
        String homePageLogInLinkLocator = "//a[@id='login-link']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLogInLinkLocator));
        loginFormLink.click();
        String loginFormInputEmailLocator = "//input[@id='email']";
        String loginFormInputPwdLocator = "//input[@id='current-password']";
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys("tbalashevich@bk.ru");
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("testinG@2579!");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Log in')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
//        String expectedGreetingText = "Welcome, Tomara \uD83D\uDC4B";
//        WebElement actualMessageTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Tomara \uD83D\uDC4B')]"));
//        String actualGreetingText = actualMessageTextElement.getText();
//        Assertions.assertEquals(expectedGreetingText, actualGreetingText);
        //to check POST response
        //todo
        driver.quit();
    }
    @Test
    public void toFillLoginFormByEmptyData() throws InterruptedException {
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
        String homePageLogInLinkLocator = "//a[@id='login-link']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLogInLinkLocator));
        loginFormLink.click();
        //to fill the form
        String loginFormInputEmailLocator = "//input[@id='email']";
        String loginFormInputPwdLocator = "//input[@id='current-password']";
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys("");
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Log in')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        //to check POST response
        //todo
        driver.quit();
    }
}
