package proxy.dynamicproxy.jdkinterface;

import java.awt.event.ActionListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        ClassLoader cl = ProxyTest.class.getClassLoader();
        Class[] interfaces = new Class[]{ ActionListener.class };

        // 创建代理
        ActionListener listenerProxy = (ActionListener)Proxy.newProxyInstance(cl, interfaces, new InvocationHandler() {

            /**
             * 所有对ActionListener接口的调用最终都会触发此方法的调用
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String name = method.getName();

                if(name.equals("toString")) {

                    return "toString was called";
                }
                else if(name.equals("actionPerformed")) {

                    System.out.println("actionPerformed was called");

                    return null;
                }

                throw new RuntimeException("no method found");
            }
        });

        listenerProxy.actionPerformed(null);
    }
}