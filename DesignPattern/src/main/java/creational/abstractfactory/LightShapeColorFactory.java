package creational.abstractfactory;

public class LightShapeColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(Shape.Type type){
        switch (type){
            case SQUARE: return new LightSquare();
            case RECTANGLE: return new LightRectangle();
            case CIRCLE: return new LightCircle();
            default:return null;
        }
    }

    @Override
    Color getColor(Color.Type type) {
        switch (type){
            case RED: return new LightRed();
            case GREEN: return new LightGreen();
            case BLUE: return new LightBlue();
            default:return null;
        }
    }
}