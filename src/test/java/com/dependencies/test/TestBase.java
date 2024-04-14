package com.dependencies.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static final ApplicationMagager app = new ApplicationMagager();

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite()
    public void tearDown(){
        app.stop();
    }


}
