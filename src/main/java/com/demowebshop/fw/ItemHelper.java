package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends TestHelper{
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public static By clickButtonAddToCard() {
        return By.cssSelector(".item-box:nth-child(3) .buttons");
    }

    public static By clickToElementShoopingCard() {
        return By.cssSelector(".ico-cart>.cart-label");
    }

    public int sizeOfCart() {
        if (isElementPresent(By.cssSelector("[title='Show details for 14.1-inch Laptop']"))) {
            return driver.findElements(By.cssSelector("[title='Show details for 14.1-inch Laptop']")).size();
        }
        return 0;
    }
}
