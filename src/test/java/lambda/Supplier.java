package lambda;

import java.util.Arrays;
import java.util.List;


public interface Supplier {
    void get(String msg);
    default void put(){};
}

class Car {

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
//    public static lambda.Car create(final lambda.Supplier<lambda.Car> supplier) {
//        return supplier.get();
//    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
//        final lambda.Car car = lambda.Car.create( lambda.Car::new );
//        final List< lambda.Car > cars = Arrays.asList(car );
//        cars.forEach( lambda.Car::repair);
            Supplier supplier =x -> System.out.println("Hello"+x);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}