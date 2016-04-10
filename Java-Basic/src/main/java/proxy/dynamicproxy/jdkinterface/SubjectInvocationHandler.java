package proxy.dynamicproxy.jdkinterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类对应的调用处理程序类
 */
public class SubjectInvocationHandler implements InvocationHandler {

    //代理类持有一个委托类的对象引用
    private Object delegate;

    public SubjectInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    /**
     * 此方法由代理类调用，并传入参数
     *
     *  步骤2、反射获取代理类中当前被调用的方法对应的Method对象，把它和代理对象本身及调用参数一起
     *  传入此方法中，此方法中把对代理对象的Method对象代表的方法的调用转化为对真实对象的对应方法的调用，
     *
     *  因此这个方法是代理对象与真实对象的对接点
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long stime = System.currentTimeMillis();
        //利用反射机制将请求分派给委托类处理。Method的invoke返回Object对象作为方法执行结果。
        //因为示例程序没有返回值，所以这里忽略了返回值处理
        method.invoke(delegate, args);
        long ftime = System.currentTimeMillis();
        System.out.println("执行任务耗时"+(ftime - stime)+"毫秒");

        return null;
    }
}
