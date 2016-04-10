package creational.abstractfactory;

public class LightRectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside LightRectangle::draw() method.");
    }
}