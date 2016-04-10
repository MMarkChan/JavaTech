package proxy.dynamicproxy.jdkinterface;

public class Client {

    public static void main(String[] args) {
        Subject proxy = DynProxyFactory.getInstance();
        // 步骤1、调用触发（导致调用处理器中的invoke()方法被调用）
        proxy.dealTask("DBQueryTask");
    }

}