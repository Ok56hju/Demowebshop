package com.dependencies.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart  {
    @BeforeMethod
    public void ensurePrecondition(){

        if (!app.isLoginLinkPresent()){
            app.clickOnSignOutButton();
        }

        app.clickOnLoginLink();
        app.fillLoginForm(new User().setEmail("tested1@gm.com").setPassword("Qwe1234$"));
        app.clickOnSaveButton();
    }

    @Test
    public void fillProduductPositivTest(){

        app.click(By.cssSelector(".item-box:nth-child(3) .buttons"));

        int sizeBefore = app.sizeOfCart();

        app.click(By.cssSelector(".ico-cart>.cart-label"));

        app.pause(1000);

        int sizeAfter = app.sizeOfCart();
        Assert.assertEquals(sizeAfter,sizeBefore+1);
    }
    @AfterMethod
    public void postCondition() {
        app.removeContact();
    }


}


