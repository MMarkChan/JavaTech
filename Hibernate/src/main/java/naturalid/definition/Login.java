package naturalid.definition;


import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Login {
    @EmbeddedId
    private PK pk;
    @Embeddable
    public static class PK implements Serializable {
        private String system;
        private String username;
        //...
    }
    //...
}

