package validator.cconstraints;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean Validation API不仅能够用来校验单个的实例对象,
 * 还能够用来校验完整的对象图.要使用这个功能,只需要在一个有关联关系的字段或者属性上标注@Valid.
 * 这样,如果一个对象被校验,那么它的所有的标注了@Valid的关联对象都会被校验.
 *
 * 如果校验Car的实例对象的话,因为它的driver属性标注了@Valid, 那么关联的Person也会被校验. 所以,如果对象Person的name属性如果是null的话,那么校验会失败.
 *
 * 关联校验也适用于集合类型的字段, 也就是说,任何下列的类型:
 * >数组
 * >实现了java.lang.Iterable接口( 例如Collection, List 和 Set)
 * >实现了java.util.Map接口
 */
public class ObjectGraph {
    @NotNull
    @Valid
    private Person driver;

    public ObjectGraph(Person driver) {
        this.driver = driver;
    }

    // 如果标注了@Valid, 那么当主对象被校验的时候,这些集合对象中的元素都会被校验.
    @NotNull
    @Valid
    private List<Person> passengers = new ArrayList<Person>();

}
