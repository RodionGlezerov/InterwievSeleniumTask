package com.telran.tasks.utils;

import com.telran.tasks.fw.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener(){
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Start find element -->" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("The element with locator" + by + " was found!");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.info("We have throwable --> " + throwable.getMessage());
        logger.info("We have a throwable --> " + throwable.getCause());
        logger.info("We have a throwable --> " + throwable.getStackTrace());

        int index = (int)((System.currentTimeMillis()/1000)%3600);
        String link = "screenshots/screen" + index + ".png";

        HelperBase base = new HelperBase(driver);
        base.takeScreenshot(link);

        logger.info("This is the link of your screen with error -->" + link);
    }
}
