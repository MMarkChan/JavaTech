package advanced.runtimevalueinjection;

import advanced.model.BlankDisc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExpressiveConfigTest {
    AnnotationConfigApplicationContext context;
    @BeforeClass
    public void setup(){
        context = new AnnotationConfigApplicationContext(ExpressiveConfig.class);
    }
    @AfterClass
    public void shutdown(){
        context.close();
    }
    @Test
    public void env(){
        BlankDisc disc = (BlankDisc) context.getBean("disc");
        assertNotNull(disc);
        assertEquals("Greatest Hits",disc.getTitle());
        assertEquals("Enrique Iglesias",disc.getArtist());
    }

    @Test
    public void discWithDefaultValue(){
        BlankDisc disc = (BlankDisc) context.getBean("discWithDefaultValue");
        assertNotNull(disc);
        assertEquals("Mark8 Albulm",disc.getTitle());
        assertEquals("Enrique Iglesias",disc.getArtist());
    }

    @Test
    public void requiredProperty(){
        BlankDisc disc = (BlankDisc) context.getBean("requiredProperty");
        assertNotNull(disc);
        assertEquals("Mark8 Albulm",disc.getTitle());
        assertEquals("Enrique Iglesias",disc.getArtist());
    }

}
