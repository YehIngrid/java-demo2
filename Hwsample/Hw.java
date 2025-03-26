package Hwsample;
import java.lang.*;
public class Hw {

    private String name;
    private Car car;

    public Hw() {
    }
    public Hw(String name) {
        this.name = name;
    }
    public void setName (String name) {
        if (name != null) {
            throw new RuntimeException("name cannot be null");
        }
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void printCarBrand() {
        System.out.println("DoSomething called(): car.brand=" + this.car.getBrand());
    }


    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {

        Hw hw = new Hw("ingrid's java homework");
        //hw.name = null;
        Hw hw1 = new Hw("abc");
        System.out.println("hw.getName():" + hw.getName());
        System.out.println("hw1.getName():" + hw1.getName());
        Car car = new Car();
        car.setBrand("Toyota");
        car.setPower(500);
        hw.setCar(car);
        // String brand = car.getBrand();
        // int power = car.getPower();
        // System.out.println("brand:" + brand);
        // System.out.println("power:" + power);
        hw.printCarBrand();
        //System.out.println("hello");
    }
}
