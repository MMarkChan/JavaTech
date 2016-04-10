package advanced.model;

import advanced.beanscope.*;

/**
 * Created by Mark on 2016/3/25.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;

    /**
     * 使用set注入,一定要给类提供一个无参的构造函数,否则Spring不能实例化类
     */
    public BlankDisc(){}
    public BlankDisc(String title,String artist){
        this.artist = artist;
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void play() {

    }
}
