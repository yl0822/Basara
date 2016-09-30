package good.code.manner.enum_factory;

/**
 * Created by long.yl
 * Created in 2016/9/29
 * Created on Basara_good.code.manner.enum_factory
 */
public interface Car {

    public void sayHello();

    class AudiCar implements Car{
        @Override
        public void sayHello() {
            System.out.println("I am Audi car;");
        }
    }

    class BenziCar implements Car{
        @Override
        public void sayHello() {
            System.out.println("I am Benzi car;");
        }
    }
}
