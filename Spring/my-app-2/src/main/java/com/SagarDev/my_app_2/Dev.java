package com.SagarDev.my_app_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component

public class Dev {


    @Autowired
//    @Qualifier("laptop")
    @Qualifier("desktop")
    private Computer comp;



    public void greet(){
        comp.compile();
        System.out.println("Welcome to Spring world");
    }
}
