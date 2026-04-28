package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;

public class PhotostudioHelper extends HelperBase {

    public PhotostudioHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openStudioByDescription(String text) {
        driver.findElement(By.linkText(text)).click();
    }


    public void clickNextPhoto() {
        driver.findElement(By.linkText("❯")).click();
    }

    public boolean isGalleryPresent() {
        return isElementPresent(By.linkText("❯"));
    }
}