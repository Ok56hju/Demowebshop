package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class UsertHelper extends TestHelper{
    public UsertHelper(WebDriver driver) {
        super(driver);
    }



    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
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
