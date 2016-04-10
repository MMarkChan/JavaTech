package naturalid.definition;


import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NaturalIdCache
public class Company {
    @Id
    private Integer id;
    // 使用单个基本属性定义自然ID
    @NaturalId
    private String taxIdentifier;
    //...
}

