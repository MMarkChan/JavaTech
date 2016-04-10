package naturalid.definition;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@IdClass( Login3.PK.class )
public class Login3 {
    @Id
    @ManyToOne
    private String system;
    @Id
    private String username;
    public static class PK implements Serializable {
        private String system;
        private String username;
        //...
    }
    //...
}

