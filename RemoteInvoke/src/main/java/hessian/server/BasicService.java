package hessian.server;
import com.caucho.hessian.server.HessianServlet;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = "/hessian")
public class BasicService extends HessianServlet implements BasicAPI {
    private String _greeting = "Hello, world,cdmdfdfsffs";
    public void setGreeting(String greeting) {
        _greeting = greeting;
    }

    public String hello() {
        return _greeting;
    }
}
