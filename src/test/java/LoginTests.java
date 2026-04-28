
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;

public class LoginTests extends BaseTest {


    @BeforeEach
    public void ensurePreconditions() {
        app.getNavigation().openLoginPage();

        if (app.getAuth().isLoggedIn()) {
            app.getAuth().logout();
            app.getNavigation().openLoginPage();
        }
    }

    @Test
    public void test1_ValidLogin() throws InterruptedException {

        app.getAuth().login("dinara.gindullina.kzn@gmail.com", "Dinara2005");

        Thread.sleep(2000);

        app.getNavigation().openProfilePage();

        assertTrue(app.getAuth().isLoggedIn(), "Пользователь не смог авторизоваться!");

    }

    @Test
    public void test2_Logout() throws InterruptedException {
        if (!app.getAuth().isLoggedIn()) {
            app.getNavigation().openLoginPage();
            app.getAuth().login("dinara.gindullina.kzn@gmail.com", "Dinara2005");
            Thread.sleep(2000);
        }

        app.getNavigation().openProfilePage();
        Thread.sleep(1000);

        app.getAuth().logout();
        Thread.sleep(2000);

        assertFalse("Пользователь всё ещё авторизован!", app.getAuth().isLoggedIn());
    }
}
