package com.dependencies.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test()
    public void createNewAccountPositiveTest(){
        int i = app.getUser().random();

        app.getUser().clickOnRegistrationButton();

        app.getUser().fillDateToAccaontForm(i);

        app.getUser().click(By.id("register-button"));
//        click(By.cssSelector("[value='Continue']"));
        //assert Sing Out button is present
        Assert.assertTrue(app.getUser().isAccountPresent());

    }

}
