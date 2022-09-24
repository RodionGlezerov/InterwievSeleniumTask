package com.telran.task.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {

    ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ya.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void pause(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent2(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void clickBrand(String brand) {  //pmu
        click(By.xpath("//span[text()='"+ brand +"']"));
    }

    public void addPrice() {  //pmu
        type(By.cssSelector("span._1heDd:nth-child(1) [class='_3qxDp']"),"20000");
        type(By.cssSelector("span._1heDd:nth-child(2) [class='_3qxDp']"),"35000");
    }

    public void clickOnSearchButton() { //pmu
        click(By.cssSelector("[data-r='search-button']"));
    }

    public void inputItemNameInSearchField(String itemName) {  //pmu
        type(By.id("header-search"), itemName);
    }

    public void selectSmartphoneType(String category1) { //pmu
        click(By.cssSelector("[href='/catalog--"+ category1 + "?how=dpop&glfilter=&cvredirect=3&filter-express-delivery=1&searchContext=express&track=srch_ddl']"));
    }

    public void selectElectronicType(String category) { //pmu
        click(By.cssSelector("[href='/catalog--" + category + "/list?filter-express-delivery=1&searchContext=express']"));
    }

    public void clickAcceptCookies() {  //pmu
        click(By.cssSelector("[data-id='button-all']"));
    }

    public String findElementNumber(int number) { //pmu
        return elementNumber(number);
    }

    public String elementNumber(int number) {  //pmu
        return driver.findElement(By.cssSelector("div:nth-child(" + number + ") ._2UHry")).getText();
    }

    public void clickExpressButton() { //pmu
        click(By.xpath("//span[text()='Экспресс']"));
    }

    public void clickAllServiceButton() { //pmu
        click(By.cssSelector(".home-link2.services-pinned__item.services-pinned__all"));
    }

    public void selectServiceType(String serviceName) { //pmu Не отрабатвает
        click(By.xpath("//*[text()= " + serviceName + "]"));
    }
}
