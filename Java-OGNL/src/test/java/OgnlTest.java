import domain.Department;
import domain.User;
import ognl.Ognl;
import ognl.OgnlException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OgnlTest {
    @Test
    public void test() throws OgnlException {
        User user = new User();
        Department department = new Department();
        user.setDepartment(department);
        Ognl.setValue("department.name", user, "dev");

        System.out.println(user.getDepartment().getName());

        Map<String,Object> context = new HashMap<>();
        Ognl.setValue(Ognl.parseExpression("department.name"), context, user, "otherDev");

        System.out.println(user.getDepartment().getName());

        Ognl.setValue(Ognl.parseExpression("name"),context,department,"cdm");
        System.out.println(department.getName());

        context.put("myname","Mark8");
        System.out.println(Ognl.getValue("#myname",context,department));
    }
}

/**
 * 1. 表达式（Expression）
 　　表达式是整个OGNL的核心，所有的OGNL操作都是对表达式解析后执行的。
    表达式会规定此次OGNL操作到底要干什么。我们可以看到，在上面的测试中，
    name、department.name等都是表达式，表示取name或者department中的name的值。
    OGNL支持很多类型的表达式，之后我们会看到更多。

 2. 根对象（Root Object）
 　　根对象可以理解为OGNL的操作对象。在表达式规定了“干什么”以后，你还需要指定到底“对谁干”。
 　　在上面的测试代码中，user就是根对象。这就意味着，我们需要对user这个对象去取name这个属性的值
    （对user这个对象去设置其中的department中的name属性值）。

 3. 上下文环境（Context）
 　　有了表达式和根对象，我们实际上已经可以使用OGNL的基本功能。例如，根据表达式对根对象进行取值
    或者设值工作。不过实际上，在OGNL的内部，所有的操作都会在一个特定的环境中运行，这个环境就是
    OGNL的上下文环境（Context）。说得再明白一些，就是这个上下文环境（Context），将规定OGNL的
    操作“在哪里干”。
 　　OGNL的上下文环境是一个Map结构，称之为OgnlContext。上面我们提到的根对象（Root Object），
    事实上也会被加入到上下文环境中去，并且这将作为一个特殊的变量进行处理，具体就表现为针对根对象
    （Root Object）的存取操作的表达式是不需要增加#符号进行区分的。
    OgnlContext不仅提供了OGNL的运行环境。在这其中，我们还能设置一些自定义的parameter到Context
    中，以便我们在进行OGNL操作的时候能够方便的使用这些parameter。不过正如我们上面反复强调的，
    我们在访问这些parameter时，需要使用#作为前缀才能进行。

 在struts2中，根对象ValueStack的实现类为OgnlValueStack，该对象不是我们想像的只存放单个值，
 而是存放一组对象。在OgnlValueStack类里有一个List类型的root变量，就是使用他存放一组对象在
 root变量中处于第一位的对象叫栈顶对象。通常我们在OGNL表达式里直接写上属性的名称即可访问root变量
 里对象的属性，搜索顺序是从栈顶对象开始寻找，如果栈顶对象不存在该属性，就会从第二个对象寻找，如果
 没有找到就从第三个对象寻找，依次往下访问，直到找到为止。
 大家注意： Struts2中，OGNL表达式需要配合Struts标签才可以使用。如：<s:property value="name"/>

 **/