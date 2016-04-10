package creational.simplefactory;

class Factory {
    enum Type{
        A,B;
    }
    //静态工厂方法
    public static Product getProduct(Type type) {
        switch (type){
            case A: return new ConcreteProductA();
            case B: return new ConcreteProductB();
            default:return null;
        }
    }
}