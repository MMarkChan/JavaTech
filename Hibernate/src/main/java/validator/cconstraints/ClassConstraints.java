/**
 * Created by Mark on 2016/1/19.
 */
package validator.cconstraints;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 一个约束也能够被放在类级别上. 当一个约束被标注在一个类上的时候,
 * 这个类的实例对象被传递给ConstraintValidator. 当需要同时校验多个
 * 属性来验证一个对象或者一个属性在验证的时候需要另外的属性的信息的时候,
 * 类级别的约束会很有用. 在例 2.3 “类级别约束”中, 我们给类Car添加了一个passengers的属性.
 * 并且我们还标注了一个PassengerCount约束在类级别上. 稍后会看到我们是如何创建这个
 * 自定义的约束的(第 3 章 创建自己的约束规则). 现在,我们可以知道,PassengerCount会保证这
 * 个车里乘客的数量不会超过它的座位数.
 *
 * 注意：
 * 如果要定义约束在属性级别上的话,那么只能定义在访问器(getter)上面,不能定义在修改器(setter)上.
 */
//@PassengerCount
public class ClassConstraints {
    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;

    private List<Person> passengers;

    public ClassConstraints(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

}
