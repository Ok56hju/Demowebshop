package com.dependencies.test;

import com.demowebshop.fw.ItemHelper;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){

        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("tested1@gm.com").setPassword("Qwe1234$"));
        app.getUser().clickOnSaveButton();
    }

    @Test
    public void fillProduductPositivTest(){

        app.getItem().click(ItemHelper.clickButtonAddToCard());

        int sizeBefore = app.getItem().sizeOfCart();

        app.getItem().click(ItemHelper.clickToElementShoopingCard());

        app.getItem().pause(1000);

        int sizeAfter = app.getItem().sizeOfCart();
        Assert.assertEquals(sizeAfter,sizeBefore+1);
    }

    @AfterMethod
    public void postCondition() {
        app.getUser().removeContact();
    }


}


