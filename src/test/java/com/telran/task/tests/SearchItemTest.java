package com.telran.task.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchItemTest extends TestBase {


    @Test
    public void searchItemTests() {
        selectMarket();
        switchToNextTab(1);
        selectExpressDepartment();
//      acceptCookies();
        selectCategoryType("elektronika/23282330","smartfony-i-aksessuary/23282379");
        jumpDown();
        filterItem("Xiaomi");
        pause(10000);
        String itemName = getItemNameByOrder(2);
        typeInSearchInputField(itemName);
        pause(10000);
        String foundItemName = getItemNameByOrder(1);
        Assert.assertEquals(foundItemName,itemName);


    }

    public void acceptCookies() {

        clickAcceptCookies();
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

    public void selectCategoryType(String category, String category1) {
        selectElectronicType(category);
        selectSmartphoneType(category1);
    }

    public void switchToNextTab(int number){
        List<String> availableTabs = new ArrayList<>(driver.getWindowHandles());
        if (!availableTabs.isEmpty()){
            driver.switchTo().window(availableTabs.get(number));
        }
    }
    public void selectExpressDepartment(){

        clickExpressButton();
    }

    public void selectMarket(){
        clickAllServiceButton();
        selectServiceType("Маркет");
    }

    //        Открыть браузер и развернуть на весь экран
//        Зайти на yandex.ru
        //.home-link2.services-pinned__item.services-pinned__all
//        Перейти на Яндекс Маркет
        //*[text()="Маркет"]
//        Выбрать раздел Экспресс
        //span[text()='Экспресс']
//        Выбрать раздел Электроника
   //css   [href='/catalog--elektronika/23282330/list?filter-express-delivery=1&searchContext=express']
//        Выбрать раздел Смартфоны
   //      [href='/catalog--smartfony-i-aksessuary/23282379?how=dpop&glfilter=&cvredirect=3&filter-express-delivery=1&searchContext=express&track=srch_ddl']
//        Зайти в расширенный поиск
//        Задать параметр поиска от 20000 до 35000 рублей.
        //css span._1heDd:nth-child(1) [class='_3qxDp']
        //css span._1heDd:nth-child(2) [class='_3qxDp']
//        Выбрать производителя “Apple”
        //span[text()="YAMAHA"]
//        Применить условия поиска
//        Запомнить второй элемент в результатах поиска
//        В поисковую строку ввести запомненное значение.
//        Найти и проверить, что наименование товара соответствует запомненному значению.

}
