package proxy.dynamicproxy.javassit;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.awt.event.MouseAdapter;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws Exception {

        ProxyFactory factory = new ProxyFactory();
        // 为抽象类创建代理
        factory.setSuperclass(MouseAdapter.class);

        factory.setHandler(new MethodHandler() {

            public Object invoke(Object arg0, Method method, Method arg2, Object[] arg3) throws Throwable {

                String name = method.getName();

                if(name.equals("toString")) {

                    return "toString was called";
                }
                else if(name.equals("mouseClicked")) {

                    System.out.println("mouseClicked was called");

                    return null;
                }

                throw new RuntimeException("no method found");
            }
        });

        Class c = factory.createClass();

        Object object = c.newInstance();

        ((MouseAdapter) object).mouseClicked(null);
    }
}