package helpers;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }
    public void login(String username, String password) {
        if (!isElementPresent(By.id("email"))) {
            return;
        }

        driver.findElement(By.id("email")).click(); // Иногда клик нужен для снятия фокуса или активации JS
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);

        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void logout() {
        if (isElementPresent(By.xpath("//input[@value='Выйти']"))) {
            driver.findElement(By.xpath("//input[@value='Выйти']")).click();
        } else {
            driver.get("http://localhost/sign-in?logout");
        }
    }
    public boolean isLoggedIn() {
        return !isElementPresent(By.id("email"));
    }

    public String getLoggedInUserEmail() {
        return driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email:'])[1]/preceding::h2[1]")).getText();
    }
}
