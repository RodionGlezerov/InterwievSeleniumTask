package com.telran.tasks.fw;


import com.telran.tasks.utils.MyListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

//    WebDriver driver;

    EventFiringWebDriver driver;
    CategoryHelper categoryHelper;
    ItemHelper itemHelper;

    public CategoryHelper getCategoryHelper() {
        return categoryHelper;
    }

    public ItemHelper getItemHelper() {
        return itemHelper;
    }

    public void init() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.get("https://ya.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        categoryHelper = new CategoryHelper(driver);
        itemHelper = new ItemHelper(driver);
        driver.register(new MyListener());

    }

    public void stop() {
        driver.quit();
    }

}
