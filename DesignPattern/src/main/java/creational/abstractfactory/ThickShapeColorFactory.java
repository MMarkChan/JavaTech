package creational.abstractfactory;

/**
 * 厚边框浓色彩风格
 */
public class ThickShapeColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(Shape.Type type){
        switch (type){
            case SQUARE: return new ThickSquare();
            case RECTANGLE: return new ThickRectangle();
            case CIRCLE: return new ThickSquare();
            default:return null;
        }
    }

    @Override
    Color getColor(Color.Type type) {
        switch (type){
            case RED: return new ThickRed();
            case GREEN: return new ThickGreen();
            case BLUE: return new ThickBlue();
            default:return null;
        }
    }
}