package creational.factorymethod;
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside ThickRectangle::draw() method.");
    }
}
