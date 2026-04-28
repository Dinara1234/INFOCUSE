package helpers;
import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationHelper extends HelperBase {
    private String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }


    public void openLoginPage() {
        driver.get("http://localhost/sign-in");
    }

    public void openProfilePage() {
        driver.get("http://localhost/user");
    }

    public void openReferencesPage() {
        driver.get("http://localhost/references");
    }

    public void openPhotostudiosPage() {
        driver.get("http://localhost/user");

        try { Thread.sleep(500); } catch (InterruptedException e) {}

        driver.findElement(By.linkText("Фотостудии")).click();
    }

    public void openPhotoStudiosPage() {driver.get("http://localhost/user/photoStudios");}

}
