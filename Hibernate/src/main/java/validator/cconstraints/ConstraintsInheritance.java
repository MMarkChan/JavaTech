/**
 * Created by Mark on 2016/1/19.
 */
package validator.cconstraints;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 如果要验证的对象继承于某个父类或者实现了某个接口,那么定义在父类或者接口中的约束会在验证
 * 这个对象的时候被自动加载,如同这些约束定义在这个对象所在的类中一样.
 *
 * 注意：
 * 如果类ConstraintsInheritance 重写了父类FieldConstraints的getManufacturer()方法,
 * 那么定义在父类的这个方法上的约束和子类这个方法上定义的约束都会被校验.
 */

public class ConstraintsInheritance extends FieldConstraints {
    private String rentalStation;

    public ConstraintsInheritance(String manufacturer, String rentalStation) {
        super(manufacturer);
        //super(manufacturer);
        this.rentalStation = rentalStation;
    }

    @NotNull
    public String getRentalStation() {
        return rentalStation;
    }

    public void setRentalStation(String rentalStation) {
        this.rentalStation = rentalStation;
    }

}
