package com.dependencies.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestHelper {
    WebDriver driver;



    public void click(By locator) {
       driver.findElement(locator).click();
   }
}
