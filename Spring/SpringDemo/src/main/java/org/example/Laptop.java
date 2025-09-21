package org.example;

public class Laptop implements Computer{
    public Laptop(){
        System.out.println("Laptop constructor is running...");
    }

    public void compile(){
        System.out.println("compiling in laptop...");
    }
}
