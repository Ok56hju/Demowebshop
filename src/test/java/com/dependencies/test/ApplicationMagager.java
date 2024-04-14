package com.dependencies.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class ApplicationMagager {
    WebDriver driver;

    public void stop() {
        driver.quit();
    }

    public static By clickButtonAddToCard() {
        return By.cssSelector(".item-box:nth-child(3) .buttons");
    }

    public static By clickToElementShoopingCard() {
        return By.cssSelector(".ico-cart>.cart-label");
    }

    int random() {
       Random random = new Random();
       int i = random.nextInt(1000)+1000;
       return i;
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

    public void pause(int millis) {
       try {
           Thread.sleep(millis);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }

    public  void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public int sizeOfCart() {
        if (isElementPresent(By.cssSelector("[title='Show details for 14.1-inch Laptop']"))) {
            return driver.findElements(By.cssSelector("[title='Show details for 14.1-inch Laptop']")).size();
        }
        return 0;
    }

    public void removeContact() {
        click(By.cssSelector("[name='removefromcart']"));
        click(By.cssSelector("[class='button-2 update-cart-button']"));
    }

    public boolean isAccountPresent() {
        return isElementPresent(By.cssSelector("div[class='header-links'] a[class='account']"));
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector("[href='/register']"));
    }

    public void fillDateToAccaontForm(int i) {
        type(By.id("FirstName"),"Test");
        type(By.id("LastName"),"Testing");
        type(By.id("Email"), "tested1" + i + "@gm.com");
        type(By.name("Password"), "Qwe1234$");
        type(By.name("ConfirmPassword"), "Qwe1234$");
    }

    public void clickOnLoginLink(){
        click(By.cssSelector("[class='ico-login']"));
    }

    public void clickOnSaveButton(){
        click(By.cssSelector("[class='button-1 login-button']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[class='ico-login']"));
    }

    public void clickOnSignOutButton() {
        click(By.cssSelector("[class='ico-logout']"));
    }
}
