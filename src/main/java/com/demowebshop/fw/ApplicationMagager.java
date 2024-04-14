package com.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationMagager  {

    String browser;
    WebDriver driver;
    UsertHelper user;
    ItemHelper item;

    public ApplicationMagager(String browser) {
        this.browser = browser;
    }

    public  void init() {

        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
                

        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UsertHelper(driver);
        item = new ItemHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UsertHelper getUser() {
        return user;
    }

    public ItemHelper getItem() {
        return item;
    }
}
