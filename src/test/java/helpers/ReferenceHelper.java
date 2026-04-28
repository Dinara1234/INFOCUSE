package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;

public class ReferenceHelper extends HelperBase {

    public ReferenceHelper(ApplicationManager manager) {
        super(manager);
    }

    public void searchFor(String query) {
        driver.findElement(By.id("query")).click();
        driver.findElement(By.id("query")).clear();
        driver.findElement(By.id("query")).sendKeys(query);

        driver.findElement(By.xpath("//input[@value='Найти']")).click();
    }

    public String getSearchResultText() {

        return driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Что ищем?'])[1]/following::span[1]")).getText();
    }
}