package creational.factorymethod;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 ThickCircle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape(Shape.Type.CIRCLE);

        //调用 ThickCircle 的 draw 方法
        shape1.draw();

        //获取 ThickRectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape(Shape.Type.RECTANGLE);

        //调用 ThickRectangle 的 draw 方法
        shape2.draw();

        //获取 ThickSquare 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape(Shape.Type.SQUARE);

        //调用 ThickSquare 的 draw 方法
        shape3.draw();
    }
}