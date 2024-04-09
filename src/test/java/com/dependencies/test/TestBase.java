package com.dependencies.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text !=null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locato) {
       return driver.findElements(locato).size()>0;
    }
    public void clickOnLoginLink(){
        click(By.cssSelector("[class='ico-login']"));
    }

    public void fillLoginRegistracionForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }
    public void clickOnSaveButton(){
        click(By.cssSelector("[class='button-1 login-button']"));
    }
    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector("css - .ico-cart>.cart-label"))) {
            return driver.findElements(By.cssSelector("css - .ico-cart>.cart-label")).size();
        }
        return 0;
    }
}
