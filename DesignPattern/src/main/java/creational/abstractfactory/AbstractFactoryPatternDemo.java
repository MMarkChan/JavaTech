package creational.abstractfactory;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {

        //获取形状工厂
        AbstractFactory factory = FactoryProducer.getFactory(AbstractFactory.Style.LIGHT);
        //获取形状为 ThickCircle 的对象
        Shape shape = factory.getShape(Shape.Type.CIRCLE);
        //调用 ThickCircle 的 draw 方法
        shape.draw();

        //获取形状为 ThickRectangle 的对象
        shape = factory.getShape(Shape.Type.RECTANGLE);
        //调用 ThickRectangle 的 draw 方法
        shape.draw();

        //获取形状为 ThickSquare 的对象
        shape = factory.getShape(Shape.Type.SQUARE);
        //调用 ThickSquare 的 draw 方法
        shape.draw();

        //获取颜色为 ThickRed 的对象
        Color color = factory.getColor(Color.Type.RED);
        //调用 ThickRed 的 fill 方法
        color.fill();

        //获取颜色为 ThickGreen 的对象
        color = factory.getColor(Color.Type.GREEN);
        //调用 ThickGreen 的 fill 方法
        color.fill();

        //获取颜色为 ThickBlue 的对象
        color = factory.getColor(Color.Type.BLUE);
        //调用 ThickBlue 的 fill 方法
        color.fill();
    }
}