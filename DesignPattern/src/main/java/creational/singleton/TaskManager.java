package creational.singleton;

public class TaskManager
{
    /**
     * (2) 将构造函数改为 private 修饰后该如何创建对象呢？不要着急，
     * 虽然类的外部无法再使用 new 来创建对象，但是在 TaskManager 的内部还是可以创建的，
     * 可见性只对类外有效。因此，我们可以在 TaskManager 中创建并保存这个唯一实例。
     * 为了让外界可以访问这个唯一实例，需要在 TaskManager 中定义一个静态的 TaskManager
     * 类型的私有成员变量
     */
    private static TaskManager tm = null;

    /**
     * (1) 由于每次使用 new 关键字来实例化 TaskManager 类时都将产生一个新对象，
     * 为了确保 TaskManager 实例的唯一性，我们需要禁止类的外部直接使用 new 来创建对象，
     * 因此需要将 TaskManager 的构造函数的可见性改为 private
     */
    private TaskManager() {} //初始化窗口
    public void  displayProcesses() {} //显示进程
    public void  displayServices() {} //显示服务

    /**
     * (3) 为了保证成员变量的封装性，我们将 TaskManager 类型的 tm 对象的可见性设置为 private，
     * 但外界该如何使用该成员变量并何时实例化该成员变量呢？答案是增加一个公有的静态方法
     *
     * 这就是一个静态工厂方法
     * @return
     */
    public static TaskManager getInstance() {
        if (tm == null) {
            tm = new TaskManager();
        }
        return tm;
    }
}