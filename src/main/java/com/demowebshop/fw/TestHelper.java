package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class TestHelper {
    WebDriver driver;

    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public void type(By locator, String text) {
       if (text !=null) {
           click(locator);
           driver.findElement(locator).clear();
           driver.findElement(locator).sendKeys(text);
       }
   }

    public boolean isElementPresent(By locato) {
       return driver.findElements(locato).size()>0;
   }

    public void pause(int millis) {
       try {
           Thread.sleep(millis);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }

    public int random() {
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        return i;
    }

}
