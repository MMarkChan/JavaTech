package creational.abstractfactory;

public class ThickRectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside ThickRectangle::draw() method.");
    }
}