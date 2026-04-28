import appmanager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected ApplicationManager app;

    @BeforeEach
    public void setUp() {
        app = ApplicationManager.getInstance();
    }

}
