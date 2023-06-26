package by.itacademy.tatjana.balashevich.ui;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UiLoginFormTests {

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
        String expectedGreetingText = "Welcome, Tomara \uD83D\uDC4B";
        WebElement actualMessageTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Tomara \uD83D\uDC4B')]"));
        String actualGreetingText = actualMessageTextElement.getText();
        Assertions.assertEquals(expectedGreetingText, actualGreetingText);
        driver.quit();
    }

    @Test
    public void toFillLoginFormByEmptyEmail() throws InterruptedException {
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
        emailInputField.sendKeys("");
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("testinG@2579!");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Log in')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        String expectedErrorText = "Error: \nEmail is required";
        WebElement actualErrorTextElement = driver.findElement(By.xpath("//div[@id='email-error']"));
        String actualErrorText = actualErrorTextElement.getText();
        Assertions.assertEquals(expectedErrorText, actualErrorText);
        driver.quit();
    }

    @Test
    public void toFillLoginFormByEmptyPassword() throws InterruptedException {
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
        pwdInputField.sendKeys("");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Log in')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        String expectedErrorText = "Error: \nPassword is required";
        WebElement actualErrorTextElement = driver.findElement(By.xpath("//div[@id='current-password-error']"));
        String actualErrorText = actualErrorTextElement.getText();
        Assertions.assertEquals(expectedErrorText, actualErrorText);
        driver.quit();
    }

    @Test
    public void toFillLoginFormByInvalidEmail() throws InterruptedException {
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
        emailInputField.sendKeys("@@@");
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("testinG@2579!");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Log in')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        String expectedErrorText = "Error: \nEmail has invalid format";
        WebElement actualErrorTextElement = driver.findElement(By.xpath("//div[@id='email-error']"));
        String actualErrorText = actualErrorTextElement.getText();
        Assertions.assertEquals(expectedErrorText, actualErrorText);
        driver.quit();
    }
    @Test
    public void toFillLoginFormByNotCreatedUser() throws InterruptedException {
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
        Faker faker = new Faker();
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys(Util.generateEmail());
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys(Util.generatePWD());
        String submitLoginFormButtonLocator = "//button[contains(text(),'Log in')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        //todo temporary hint error is displayed JS
        //driver.quit();
    }
}
