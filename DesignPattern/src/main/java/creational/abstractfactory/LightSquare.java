package creational.abstractfactory;

public class LightSquare implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside LightSquare::draw() method.");
    }
}