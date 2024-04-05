package com.dependencies.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTest extends TestBase{

    @Test()
    public void createNewAccountPositiveTest(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        // click on Login link
        click(By.cssSelector("[href='/register']"));
        type(By.id("FirstName"),"Test");
        type(By.id("LastName"),"Testing");
        //enter email
        type(By.id("Email"), "tested1" + i + "@gm.com");
        //enter password
        type(By.name("Password"), "Qwe1234$");
        type(By.name("ConfirmPassword"), "Qwe1234$");
        //click on Registration button
        click(By.id("register-button"));
        click(By.cssSelector("[value='Continue']"));
        //assert Sing Out button is present
        Assert.assertTrue(isElementPresent(By.xpath("//div:nth-child(2)>a")));

    }

}
