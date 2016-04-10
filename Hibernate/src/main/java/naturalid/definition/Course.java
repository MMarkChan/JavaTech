package naturalid.definition;


import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 使用多个持久化属性定义自然ID
 */
@Entity
public class Course {
    @Id
    private Integer id;
    @NaturalId
    @ManyToOne
    private Department department;

    @NaturalId
    private String code;
    //...
}

