package basic.autowire;

import basic.componentscan.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;
    @Autowired
    public CDPlayer(CompactDisc cd, DataSource dataSource) {
        this.cd = cd;
        this.dataSource = dataSource;


    }
    public void play() {
        cd.play();
    }


    private DataSource dataSource;
}