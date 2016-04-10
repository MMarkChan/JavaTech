package methodarea;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * java 6 VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * java 8 VM Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 *
 * 注意：在Java8中持久化已经被彻底删除了，取代它的是一个叫做元空间的内存区域
 元空间快速简介：
 	它是堆的一部分
 	调整参数：-XX:MetaspaceSize、-XX:MaxMetaspaceSize
 	达到-XX:MaxMetaspaceSize所指定的阈值时会对该区域进行清理
 	空间不足会抛出java.lang.OutOfMemoryError:Metadata space错误信息
 	持久代相关参数（-XX:PermSize、-XX:MaxPermSize）会被忽略掉

 */
public class MethodAreaOOM {
    public static void main(String [] args){
        while (true){
            Enhancer enhancer = new Enhancer();
            /**
             * 设置CGLIB所生成的类将要继承的类，为了方便，如果所提供的类是一个真正的接口，
             * 则会调用setInterfaces()并传入适当的参数。非接口不能声明为final，必须有一个可访问的构造器。
             */
            enhancer.setSuperclass(OOMObject.class);
            /**
             * 是否使用并更新所生成的类静态缓存使得与原始父类的属性相同，默认值是true
             */
            enhancer.setUseCache(false);
            /**
             * 设置要使用的单个Callback，如果使用createClass()方法，则会忽略这个回调
             * @param callback 所有方法使用的回调
             * @see #setCallbacks
             */
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    /**
                     * 调用指定对象的原始（超类）方法
                     * @param obj 被增强对象, must be the object passed as the first
                     * argument to the MethodInterceptor
                     * @param args the arguments passed to the intercepted method; you may substitute a different
                     * argument array as long as the types are compatible
                     * @see MethodInterceptor#intercept
                     * @throws Throwable the bare exceptions thrown by the called method are passed through
                     * without wrapping in an <code>InvocationTargetException</code>
                     *
                     */
                    return proxy.invokeSuper(obj,args);
                }
            });
            enhancer.create();
        }
    }
}
class OOMObject{}
