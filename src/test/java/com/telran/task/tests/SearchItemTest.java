package com.telran.task.tests;

import com.telran.tasks.models.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {


    @Test
    public void searchItemTests() {
        app.getCategoryHelper().selectMarket();
        app.getItemHelper().switchToNextTab(1);
        app.getCategoryHelper().selectExpressDepartment();
//      acceptCookies();
        app.getCategoryHelper().selectCategoryType(new Category().setCategory("elektronika/23282330").setCategory("smartfony-i-aksessuary/23282379"));
        app.getItemHelper().jumpDown();
        app.getItemHelper().filterItem("Xiaomi");
        app.getItemHelper().pause(10000);
        String itemName = app.getItemHelper().getItemNameByOrder(2);
        app.getItemHelper().typeInSearchInputField(itemName);
        app.getItemHelper().pause(10000);
        String foundItemName = app.getItemHelper().getItemNameByOrder(1);
        Assert.assertEquals(foundItemName,itemName);


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
