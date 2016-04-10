package asynchronous;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/jdkwebservice", asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        final PrintWriter out = resp.getWriter();
        out.println("进入Servlet的时间：" + new Date() + ".");
        out.flush();

        //在子线程中执行业务调用，并由其负责输出响应，主线程退出
        /**
         * 让当前请求进入异步模式，并使用未包装过的ServletRequest和ServletResponse来
         * 初始化它的异步上下文AsyncContext
         *
         * 调用此方法将导致相关的响应延迟，直到所返回的AsyncContext的complete被调用或者异步操作超时为止。
         *
         * 调用所返回的AsyncContext的hasOriginalRequestAndResponse()会返回true。
         * 在请求进入异步模式后，在出站方向被调用的任何过滤器可以使用这个值作为指示，
         * 任何在入站调用时所添加的请求或响应包装器在异步操作期间不需要等待，
         * 因此它们相关的资源可以被释放。
         *
         * 这个方法会清楚由于前一个startAsync方法调用并调用每个AsyncListener的onStartAsync
         * 方法而被注册的AsyncListener实例列表
         *
         * 后续对此方法的调用，或对其重载方法的调用，都会返回同一个SyncContext实例，适当的时候会重新初始化
         *
         * */
        AsyncContext ctx = req.startAsync();
        ctx.addListener(new AsyncListener() {
            public void onComplete(AsyncEvent event) throws IOException {
                out.print("我在异步监听器中打印！");
            }

            public void onTimeout(AsyncEvent event) throws IOException {

            }

            public void onError(AsyncEvent event) throws IOException {

            }

            public void onStartAsync(AsyncEvent event) throws IOException {

            }
        });
        new Thread(new Executor(ctx)).start();

        out.println("结束Servlet的时间：" + new Date() + ".");
        out.flush();
    }
}

