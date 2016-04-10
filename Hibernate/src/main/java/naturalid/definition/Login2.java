package naturalid.definition;


import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Login2 {
    @EmbeddedId
    private PK pk;
    @Embeddable
    public static class PK implements Serializable {
        @ManyToOne
        private System system;
        private String username;
        //...
    }
    //...
}

