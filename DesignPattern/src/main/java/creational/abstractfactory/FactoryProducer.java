package creational.abstractfactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(AbstractFactory.Style style){
        switch (style){
            case THICK:return new ThickShapeColorFactory();
            case LIGHT:return new LightShapeColorFactory();
            default:return null;
        }
    }
}