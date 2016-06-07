#装饰者模式
> 装饰者模式：动态地给一个对象添加一些额外的职责，就增加功能来说，Decorator模式比生成子类更为灵活。

##原理
1、Decorator抽象类中，持有Human接口，方法全部委托给该接口调用，目的是交给该接口的实现类即子类进行调用。

2、Decorator抽象类的子类（具体装饰者），里面都有一个构造方法调用super(human),这一句就体现了抽象类依赖于
子类实现即抽象依赖于实现的原则。因为构造里面参数都是Human接口，只要是该Human的实现类都可以传递进去，即表现出
Decorator dt = new Decorator_second(new Decorator_first(new Decorator_zero(human)));
这种结构的样子。所以当调用dt.wearClothes();dt.walkToWhere()的时候，又因为每个具体装饰者类中
，都先调用super.wearClothes和super.walkToWhere()方法，而该super已经由构造传递并指向了具体的某一个装饰者类
（这个可以根据需要调换顺序），那么调用的即为装饰类的方法，然后才调用自身的装饰方法，即表现出一种装饰、链式的类似于过滤的行为。

3、具体被装饰者类，可以定义初始的状态或者初始的自己的装饰，后面的装饰行为都在此基础上一步一步进行点缀、装饰。
4、装饰者模式的设计原则为：对扩展开放、对修改关闭，这句话体现在我如果想扩展被装饰者类的行为，无须修改装饰者抽象类，
只需继承装饰者抽象类，实现额外的一些装饰或者叫行为即可对被装饰者进行包装。所以：扩展体现在继承、修改体现在子类中，而不是具体的抽象类，
这充分体现了依赖倒置原则，这是自己理解的装饰者模式。

##角色

- 抽象构件(Component)角色：给出一个抽象接口，以规范准备接收附加责任的对象。

- 具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类。

- 装饰(Decorator)角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。

- 具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。


##实现

- ConcreteComponent：让Decorator对象为自己添加功能。有时候使用ConcreteComponent的派生类提供核心功能，
在这种情况就是用ConcreteComponent替代了Component的功能，而且装饰者是继承于ConcreteComponent的子类。

- Component：定义ConcreteComponent和Decorator类要实现的方法，简单来说如果一个类继承于该类就具有装饰或被装饰能力。

- Decorator：具有特定装饰功能的类，用来装饰ConcreteComponent类。

- ConcreteDecorator

##好处

##在Jdk中的应用
    InputStream类就是以抽象组件存在的,而FileInputStream就是具体组件，他实现了抽象组件的所有接口。FilterInputStream类就是装饰角色,
它实现了InputStream类的所有接口，并持有InputStream的对象实例引用；BufferedInputStream是具体的装饰器实现，他给InputStream添加了缓
冲区功能，就是将读取的数据保存在内存中，而提高读取效率。类似的还有LineNumberInputStream类，他的作用就是提高按行读取数据的功能，他们都让
InputStream类的功能得到的了增强。
