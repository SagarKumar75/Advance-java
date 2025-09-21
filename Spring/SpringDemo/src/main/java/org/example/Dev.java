package org.example;

public class Dev {


//    private Laptop laptop;
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }



//    int age;
    public Dev(){
        System.out.println("dev constuctor is running...");
    }
//    public Dev(int age) {
//        this.age = age;
//    }
//
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }

    private Computer com;

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void build(){
        System.out.println("running build");
        com.compile();
    }
}
