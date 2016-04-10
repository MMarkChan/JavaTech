package asynchronous;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
    urlPatterns = {"/simple"},
    asyncSupported = true,
    loadOnStartup = -1,
    name = "SimpleServlet",
    displayName = "ss",
    initParams = {@WebInitParam(name = "username", value = "tom")}
)
public class AnnotationTest extends HttpServlet {}
