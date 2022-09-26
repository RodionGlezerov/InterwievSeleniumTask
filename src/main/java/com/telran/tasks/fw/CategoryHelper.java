package com.telran.tasks.fw;

import com.telran.tasks.models.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryHelper extends HelperBase {
    public CategoryHelper(WebDriver driver) {
        super(driver);
    }

    public void selectSmartphoneType(String category1) { //pmu
        click(By.cssSelector("[href='/catalog--" + category1 + "?how=dpop&glfilter=&cvredirect=3&filter-express-delivery=1&searchContext=express&track=srch_ddl']"));
    }

    public void selectElectronicType(String category) { //pmu
        click(By.cssSelector("[href='/catalog--" + category + "/list?filter-express-delivery=1&searchContext=express']"));
    }

    public void clickAcceptCookies() {  //pmu
        click(By.cssSelector("[data-id='button-all']"));
    }

    public void clickExpressButton() { //pmu
        click(By.xpath("//span[text()='Экспресс']"));
    }

    public void clickAllServiceButton() { //pmu
        click(By.cssSelector(".home-link2.services-pinned__item.services-pinned__all"));
    }

    public void selectServiceType(String serviceName) { //pmu Не отрабатвает
        click(By.xpath("//*[text()= '" + serviceName + "']"));
    }

    public void acceptCookies() {

        clickAcceptCookies();
    }

    public void selectCategoryType(Category category2) {
        selectElectronicType(category2.getCategory());
        selectSmartphoneType(category2.getCategory1());
    }

    public void selectExpressDepartment() {

        clickExpressButton();
    }

    public void selectMarket() {
        clickAllServiceButton();
        selectServiceType("Маркет");
    }
}
