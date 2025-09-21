package com.SagarDev.my_app_2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
//@Primary
public class Laptop implements Computer {

    public void compile(){
        System.out.println("i am compiling in laptop");
    }
}
