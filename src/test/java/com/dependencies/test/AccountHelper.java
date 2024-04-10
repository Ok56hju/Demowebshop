package com.dependencies.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountHelper extends BaseHelper{


    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public int sizeOfCart() {
        if (isElementPresent(By.cssSelector("[title='Show details for 14.1-inch Laptop']"))) {
            return ApplicationManager.driver.findElements(By.cssSelector("[title='Show details for 14.1-inch Laptop']")).size();
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
}
