package creational.abstractfactory;

public interface Shape {
    void draw();
    enum Type {
        SQUARE,RECTANGLE,CIRCLE;
    }
}