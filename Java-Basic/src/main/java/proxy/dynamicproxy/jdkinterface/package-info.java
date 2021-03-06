/**
 * 动态代理机制特点
 首先是动态生成的代理类本身的一些特点。
 1）包：如果所代理的接口都是 public的，那么它将被定义在顶层包（即包路径为空），
 如果所代理的接口中有非 public 的接口（因为接口不能被定义为 protect 或 private，
 所以除 public 之外就是默认的 package 访问级别），那么它将被定义在该接口所在包
 （假设代理了 com.ibm.developerworks 包中的某非 public 接口 A，
 那么新生成的代理类所在的包就是 com.ibm.developerworks），
 这样设计的目的是为了最大程度的保证动态代理类不会因为包管理的问题而无法被成功定义并访问；

 2）类修饰符：该代理类具有 final和 public修饰符，意味着它可以被所有的类访问，但是不能被再度继承；
 3）类名：格式是“$ProxyN”，其中N是一个逐一递增的阿拉伯数字，代表 Proxy 类第N次生成的动态代理类，
 值得注意的一点是，并不是每次调用 Proxy 的静态方法创建动态代理类都会使得 N 值增加，
 原因是如果对同一组接口（包括接口排列的顺序相同）试图重复创建动态代理类，它会很聪明地返回先前已经
 创建好的代理类的类对象，而不会再尝试去创建一个全新的代理类，这样可以节省不必要的代码重复生成，
 提高了代理类的创建效率。4）类继承关系：该类的继承关系如图

 Proxy 类是它的父类，这个规则适用于所有由 Proxy 创建的动态代理类。而且该类还实现了其所代理的一组接口，
 这就是为什么它能够被安全地类型转换到其所代理的某接口的根本原因。


 每个代理类实例都会关联一个调用处理器对象，可以通过 Proxy提供的静态方法 getInvocationHandler去获得
 代理类实例的调用处理器对象。
 在代理类实例上调用其代理的接口中所声明的方法时，这些方法最终都会由调用处理器的 invoke 方法执行，
 此外，值得注意的是，代理类的根类 java.lang.Object 中有三个方法也同样会被分派到调用处理器的 invoke
 方法执行，它们是 hashCode，equals 和 toString，可能的原因有：
 一是因为这些方法为 public 且非 final 类型，能够被代理类覆盖；
 二是因为这些方法往往呈现出一个类的某种特征属性，具有一定的区分度，所以为了保证代理类与委托类对外的一致性，
 这三个方法也应该被分派到委托类执行。

 当代理的一组接口有重复声明的方法且该方法被调用时，代理类总是从排在最前面的接口中获取Method类型的对象
 并分派给调用处理器，而无论代理类实例是否正在以该接口（或继承于该接口的某子接口）的形式被外部引用，
 因为在代理类内部无法区分其当前的被引用类型。

 被代理的一组接口有哪些特点。
 1、要注意不能有重复的接口，以避免动态代理类代码生成时的编译错误。
 2、这些接口对于类装载器必须可见，否则类装载器将无法链接它们，将会导致类定义失败。
 3、需被代理的所有非 public 的接口必须在同一个包中，否则代理类生成也会失败。
 4、接口的数目不能超过 65535，这是 JVM 设定的限制。

 最后再来了解一下异常处理方面的特点。从调用处理器接口声明的方法中可以看到理论上它能够抛出任何类型的异常，
 因为所有的异常都继承于 Throwable 接口，但事实是否如此呢？答案是否定的，原因是我们必须遵守一个继承原则：
 即子类覆盖父类或实现父接口的方法时，抛出的异常必须在原方法支持的异常列表之内。所以虽然调用处理器理论上
 讲能够，但实际上往往受限制，除非父接口中的方法支持抛 Throwable 异常。那么如果在 invoke 方法中的确产
 生了接口方法声明中不支持的异常，那将如何呢？放心，Java 动态代理类已经为我们设计好了解决方法：它将会抛出
 UndeclaredThrowableException 异常。这个异常是一个 RuntimeException 类型，所以不会引起编译错误。
 通过该异常的 getCause 方法，还可以获得原来那个不受支持的异常对象，以便于错误诊断。


 优点：
 动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理
 （InvocationHandler.invoke）。这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静
 态代理那样每一个方法进行中转。在本示例中看不出来，因为invoke方法体内嵌入了具体的外围业务（
 记录任务处理前后时间并计算时间差），实际中可以类似Spring AOP那样配置外围业务。

 美中不足：
 诚然，Proxy 已经设计得非常优美，但是还是有一点点小小的遗憾之处，那就是它始终无法摆脱仅支持 interface
 代理的桎梏，因为它的设计注定了这个遗憾。回想一下那些动态生成的代理类的继承关系图，它们已经注定有一个
 共同的父类叫 Proxy。Java 的继承机制注定了这些动态代理类们无法实现对 class 的动态代理，原因是多继承在
 Java 中本质上就行不通。
 */
package proxy.dynamicproxy.jdkinterface;