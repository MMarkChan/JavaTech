package jerseyrestful;

import com.sun.deploy.util.SessionState;
import com.sun.javaws.Main;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @BeforeTest
    public void setUp() throws Exception {
        server = Main.startServer();

        SessionState.Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @AfterTest
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
}