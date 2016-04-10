/**
 * Created by Mark on 2016/1/19.
 */
package validator.cconstraints;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * 如果你的模型遵循JavaBeans规范的话,
 * 你还可以把约束标注在属性上. 例 2.2 “属性级约束”和例 2.1 “字段级(field level) 约束”
 * 的唯一不同就是它的约束是定义在属性级别上的.
 *
 * 当使用属性级别的约束时，访问被验证的属性值是通过属性访问方法获取的
 * 使用属性级别比字段级别的优势在于，约束已经成为了被约束的类型的API的一部分，用户不必看到类的实现就可知道所存在的约束
 *
 * 在同一个类中最好只使用字段或属性级别中的一种，不推荐在字段和getter方法上都加验证注解，因为这会导致字段被重复验证
 *
 * 注意：
 * 如果要定义约束在属性级别上的话,那么只能定义在访问器(getter)上面,不能定义在修改器(setter)上.
 */
public class PropertyConstraints {
    private String manufacturer;

    private boolean isRegistered;

    public PropertyConstraints(String manufacturer, boolean isRegistered) {
        super();
        this.manufacturer = manufacturer;
        this.isRegistered = isRegistered;
    }

    @NotNull
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @AssertTrue
    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
}
