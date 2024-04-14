package com.dependencies.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.isLoginLinkPresent()){
            app.clickOnSignOutButton();
        }
    }

    @Test()
    public void createNewAccountPositiveTest(){
        int i = app.random();

        app.clickOnRegistrationButton();

        app.fillDateToAccaontForm(i);

        click(By.id("register-button"));
//        click(By.cssSelector("[value='Continue']"));
        //assert Sing Out button is present
        Assert.assertTrue(app.isAccountPresent());

    }

}
