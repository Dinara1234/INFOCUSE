import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class PhotostudioTests extends BaseTest {

    @BeforeEach
    public void ensurePreconditions() {
        app.getNavigation().openLoginPage();

        if (app.getAuth().isLoggedIn()) {
            return;
        }

        app.getAuth().login("dinara.gindullina.kzn@gmail.com", "Dinara2005");
    }

    @Test
    public void testViewStudioGallery() throws InterruptedException {
        app.getNavigation().openPhotostudiosPage();
        Thread.sleep(1000);

        String studioDescription = "просп. Ямашева, 57 • этаж 4: Очень уютная и приятная фотостудия!) В удобном месте и по приемлемой цене. Встретили приветлево.";
        app.getPhotostudio().openStudioByDescription(studioDescription);

        Thread.sleep(1500);

        assertTrue("Галерея фотостудии не загрузилась!", app.getPhotostudio().isGalleryPresent());

        app.getPhotostudio().clickNextPhoto();
        Thread.sleep(500);

        app.getPhotostudio().clickNextPhoto();
        Thread.sleep(500);

    }
}