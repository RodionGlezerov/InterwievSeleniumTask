package com.telran.tasks.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ItemHelper extends HelperBase {

    public ItemHelper(WebDriver driver) {
        super(driver);
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

    public String findElementNumber(int number) { //pmu
        return elementNumber(number);
    }

    public String elementNumber(int number) {  //pmu
        return driver.findElement(By.cssSelector("div:nth-child(" + number + ") ._2UHry")).getText();
    }

    public void typeInSearchInputField(String itemName) {
        inputItemNameInSearchField(itemName);
        clickOnSearchButton();
    }

    public String getItemNameByOrder(int number) {
        return findElementNumber(number);


    }

    public void filterItem(String brand) {
        addPrice();
        clickBrand(brand);
    }

    public void jumpDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void switchToNextTab(int number){
        List<String> availableTabs = new ArrayList<>(driver.getWindowHandles());
        if (!availableTabs.isEmpty()){
            driver.switchTo().window(availableTabs.get(number));
        }
    }
}
