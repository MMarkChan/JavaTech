package naturalid.definition;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@IdClass( LogFile.PK.class )
public class LogFile {
    @Id
    private String name;
    @Id
    private LocalDate date;
    @Id
    @GeneratedValue
    private Integer uniqueStamp;
    public static class PK implements Serializable {
        private String name;
        private LocalDate date;
        private Integer uniqueStamp;
        //...
    }
    //...
}

