package creational.abstractfactory;

public abstract class AbstractFactory {
    enum Style{
        THICK,LIGHT;
    }
    abstract Color getColor(Color.Type type);
    abstract Shape getShape(Shape.Type type) ;
}