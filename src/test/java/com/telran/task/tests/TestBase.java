package com.telran.task.tests;

import com.telran.tasks.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }


    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }

}
