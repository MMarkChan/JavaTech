package basic.componentscan;

import org.springframework.stereotype.Component;

/**
 * 使用@Component注解把此类标注为一个组件，并为Spring创建此类的bean提供线索
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
    public void play() {
        System.out.print("Playing " + title + " by " + artist);
    }
}
