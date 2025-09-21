package org.example;

public class Desktop implements Computer {
    public Desktop(){
        System.out.println("Desktop constructor is running...");
    }
    public void compile(){
        System.out.println("compiling in desktop...");
    }
}
