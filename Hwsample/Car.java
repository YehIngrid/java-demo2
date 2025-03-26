package Hwsample;
    public class Car {
        private String brand;
        private int power;
    
        public Car() {
            System.out.println("Car.");
        }
        public void setBrand(String brand) {
            this.brand = brand;
        }
        public void setPower(int power) {
            this.power = power;
        }
        public String getBrand() {
            return this.brand;
        }
        public int getPower() {
            return this.power;
        }
    }
    

