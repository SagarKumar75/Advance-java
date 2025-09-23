package com.sagarDev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1=new Student();

        s1.setId(3);
        s1.setName("Sohan");
        s1.setTech("cloud");

        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

        // add data to the database

//        session.persist(s1);
//        transaction.commit();

        // retrieve data

//        Student s2=session.find(Student.class,3); // eager fetching
//
//        System.out.println(s2);

        // update data

//        session.merge(s1);  // if the data is not found, it inserted the data
//        transaction.commit();

        // delete data

//        Student s2=session.find(Student.class,3);
//        session.remove(s2);
//        transaction.commit();







        session.close();
        factory.close();






    }
}