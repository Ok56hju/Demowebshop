package com.dependencies.test;

import com.demowebshop.fw.ApplicationMagager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static final ApplicationMagager app = new ApplicationMagager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite()
    public void tearDown(){
        app.stop();
    }


}
