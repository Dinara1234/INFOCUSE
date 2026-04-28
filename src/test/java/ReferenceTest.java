import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReferenceTest extends BaseTest {

    @BeforeEach
    public void ensurePreconditions() {
        app.getNavigation().openLoginPage();

        if (app.getAuth().isLoggedIn()) {
            return;
        }

        app.getAuth().login("dinara.gindullina.kzn@gmail.com", "Dinara2005");
    }

    @Test
    public void testSearchReference() throws InterruptedException {
        app.getNavigation().openReferencesPage();

        Thread.sleep(1000);

        String searchQuery = "природа";

        app.getReference().searchFor(searchQuery);

        Thread.sleep(1500);

        String actualResultText = app.getReference().getSearchResultText();

        String expectedText = searchQuery;
        assertEquals( expectedText, actualResultText);

    }
}
