/**简单工厂
 * 工厂模式是最常用的一类创建型设计模式，通常我们所说的工厂模式是指工厂方法模式，它也是使用频率最高的工厂模式。
 * 简单工厂模式是工厂方法模式的“小弟”，它不属于 GoF 23 种设计模式，但在软件开发中应用也较为频繁，
 * 通常将它作为学习其他工厂模式的入门。此外，工厂方法模式还有一位“大哥”——抽象工厂模式。这三种工厂模式各具特色，
 * 难度也逐个加大，在软件开发中它们都得到了广泛的应用，成为面向对象软件中常用的创建对象的工具。
 *
 * 它的设计思想很简单，其基本流程如下：

 首先将需要创建的各种不同对象的相关代码封装到不同的类中，这些类称为具体产品类，
 而将它们公共的代码进行抽象和提取后封装在一个抽象产品类中，每一个具体产品类都是抽象产品类的子类；
 然后提供一个工厂类用于创建各种产品，在工厂类中提供一个创建产品的工厂方法，该方法可以根据所传入的参数不同创建不同的具体产品对象；
 客户端只需调用工厂类的工厂方法并传入相应的参数即可得到一个产品对象。

 简单工厂模式定义如下：
    定义一个工厂类，它可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类。
    因为在简单工厂模式中用于创建实例的方法是静态（static）方法，
    因此简单工厂模式又被称为静态工厂方法（Static Factory Method）模式，它属于类创建型模式。

 简单工厂模式的要点在于：当你需要什么，只需要传入一个正确的参数，就可以获取你所需要的对象，而无须知道其创建细节。
 简单工厂模式结构比较简单，其核心是工厂类的设计


 在简单工厂模式结构图中包含如下几个角色：
     Factory（工厂角色）：
         工厂角色即工厂类，它是简单工厂模式的核心，负责实现创建所有产品实例的内部逻辑；
         工厂类可以被外界直接调用，创建所需的产品对象；在工厂类中提供了静态的工厂方法 factoryMethod()，
         它的返回类型为抽象产品类型 Product。

     Product（抽象产品角色）：
         它是工厂类所创建的所有对象的父类，封装了各种产品对象的公有方法，它的引入将提高系统的灵活性，
         使得在工厂类中只需定义一个通用的工厂方法，因为所有创建的具体产品对象都是其子类对象。

     ConcreteProduct（具体产品角色）：
        它是简单工厂模式的创建目标，所有被创建的对象都充当这个角色的某个具体类的实例。
        每一个具体产品角色都继承了抽象产品角色，需要实现在抽象产品中声明的抽象方法。

 在简单工厂模式中，客户端通过工厂类来创建一个产品类的实例，而无须直接使用 new 关键字来创建对象，它是工厂模式家族中最简单的一员。

 在使用简单工厂模式时，首先需要对产品类进行重构，不能设计一个包罗万象的产品类，而需根据实际情况设计一个产品层次结构，
 将所有产品类公共的代码移至抽象产品类，并在抽象产品类中声明一些抽象方法，以供不同的具体产品类来实现
 */
package creational.simplefactory;