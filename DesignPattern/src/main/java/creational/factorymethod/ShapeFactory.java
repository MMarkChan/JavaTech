package creational.factorymethod;
public class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(Shape.Type type){
        switch (type){
            case CIRCLE: return new Circle();
            case RECTANGLE: return new Rectangle();
            case SQUARE: return new Square();
            default: return null;
        }
    }
}
