package com.dependencies.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {
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

        click(ApplicationMagager.clickButtonAddToCard());

        int sizeBefore = app.sizeOfCart();

        click(ApplicationMagager.clickToElementShoopingCard());

        app.pause(1000);

        int sizeAfter = app.sizeOfCart();
        Assert.assertEquals(sizeAfter,sizeBefore+1);
    }

    @AfterMethod
    public void postCondition() {
        app.removeContact();
    }


}


