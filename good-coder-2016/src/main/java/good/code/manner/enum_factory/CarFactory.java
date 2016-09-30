package good.code.manner.enum_factory;

import good.code.manner.enum_factory.Car;

/**
 * Created by long.yl
 * Created in 2016/9/29
 * Created on Basara_good.code.manner
 */
public enum CarFactory {
    // 定义生产类能生产汽车的类型
    BenziCar, AudiCar;

    // 生产汽车
    public Car create() {
        switch (this) {
            case AudiCar:
                return new Car.AudiCar();
            case BenziCar:
                return new Car.BenziCar();
            default:
                throw new AssertionError("无效参数");
        }
    }

    /**
     * 性能好，使用简洁：枚举类型的计算时以int类型的计算为基础的，这是最基本的操作，性能当然会快，至于使用便捷，注意看客户端的调用，代码的字面意思就是" 汽车工厂，我要一辆别克汽车，赶快生产"。
     * 降低类间耦合：不管生产方法接收的是Class、String还是int的参数，都会成为客户端类的负担，这些类并不是客户端需要的，而是因为工厂方法的限制必须输入的，例如Class参数，对客户端main方法来说，他需要传递一个FordCar.class参数才能生产一辆福特汽车，除了在create方法中传递参数外，业务类不需要改Car的实现类。这严重违背了迪米特原则(Law of Demeter  简称LoD),也就是最少知识原则：一个对象应该对其它对象有最少的了解。
     * 而枚举类型的工厂方法就没有这种问题了，它只需要依赖工厂类就可以生产一辆符合接口的汽车，完全可以无视具体汽车类的存在。
     * */

}
