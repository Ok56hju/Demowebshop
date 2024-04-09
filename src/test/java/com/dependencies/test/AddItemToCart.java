package com.dependencies.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){

        clickOnLoginLink();
        fillLoginRegistracionForm(new User().setEmail("tested1@gm.com").setPassword("Qwe1234$"));
        clickOnSaveButton();
    }

    @Test
    public void fillProduductPositivTest(){

        int sizeBefore = sizeOfCart();

        click(By.cssSelector(".item-box:nth-child(3) .buttons"));
        click(By.cssSelector(".ico-cart>.cart-label"));

        pause(2000);

        int sizeAfter = sizeOfCart();
        Assert.assertEquals(sizeAfter,sizeBefore+1);
    }
    @AfterMethod
    public void postCondition() {
        removeContact();
    }


}


