/**
 * Created by Mark on 2016/1/19.
 */
package validator.cconstraints;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * 当约束被定义在字段上的时候, 这个字段的值是通过字段访问策略来获取并验证的.
 * 也就是说Bean Validation的实现者会直接访问这个实例变量而不会调用属性的访问器(getter)
 * 即使这个方法存在.
 *
 * 注意：
 * 字段的访问级别( private, protected 或者 public) 对此没有影响.
 *
 * 静态字段或者属性是不会被校验的.
 */
public class FieldConstraints {
    @NotNull
    private String manufacturer;

    @AssertTrue
    private boolean isRegistered;

    public FieldConstraints(String manufacturer, boolean isRegistered) {
        super();
        this.manufacturer = manufacturer;
        this.isRegistered = isRegistered;
    }

    public FieldConstraints(String manufacturer) {
    }
}
