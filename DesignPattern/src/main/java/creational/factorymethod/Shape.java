package creational.factorymethod;

public interface Shape {
    void draw();
    enum Type{
        CIRCLE,RECTANGLE,SQUARE;
    }
}