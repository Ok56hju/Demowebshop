package com.dependencies.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {

    static WebDriver driver;


    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterSuite(enabled = false)
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

    public int sizeOfCart() {
        if (isElementPresent(By.cssSelector("[title='Show details for 14.1-inch Laptop']"))) {
            return driver.findElements(By.cssSelector("[title='Show details for 14.1-inch Laptop']")).size();
        }
        return 0;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeContact() {
        click(By.cssSelector("[name='removefromcart']"));
        click(By.cssSelector("[class='button-2 update-cart-button']"));
    }
}
