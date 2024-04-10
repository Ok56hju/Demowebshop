package com.dependencies.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    UserHelper user;
    AccountHelper account;

    public static void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper();
        account = new AccountHelper();


    }

    public static void stop() {
        driver.quit();
    }

}
