package appmanager;

import helpers.LoginHelper;
import helpers.NavigationHelper;
import helpers.PhotostudioHelper;
import helpers.ReferenceHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    private static ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private WebDriver driver;
    private String baseUrl;

    private NavigationHelper navigation;
    private LoginHelper auth;
    private ReferenceHelper reference;
    private PhotostudioHelper photostudio;


    private ApplicationManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "http://localhost";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        auth = new LoginHelper(this);
        navigation = new NavigationHelper(this, baseUrl);
        reference = new ReferenceHelper(this);
        photostudio = new PhotostudioHelper(this);
    }

    public static ApplicationManager getInstance() {
        if (app.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.getNavigation().openLoginPage();
            app.set(newInstance);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    newInstance.getDriver().quit();
                } catch (Exception e) {

                }
            }));
        }
        return app.get();
    }

    public WebDriver getDriver() { return driver; }
    public NavigationHelper getNavigation() { return navigation; }
    public LoginHelper getAuth() { return auth; }
    public ReferenceHelper getReference() {return reference;}
    public PhotostudioHelper getPhotostudio() {return photostudio;}

}