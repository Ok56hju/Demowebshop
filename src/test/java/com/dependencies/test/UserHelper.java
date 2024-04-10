package com.dependencies.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {


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
