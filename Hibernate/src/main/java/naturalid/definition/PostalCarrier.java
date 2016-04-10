package naturalid.definition;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PostalCarrier {
    @Id
    private Integer id;

    // 使用单个嵌入属性定义自然ID
    @NaturalId
    @Embedded
    private PostalCode postalCode;
    //...
}