package com.ank;

import com.ank.controller.Controller;

import org.springframework.beans.factory.config.BeanReference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = 
           ctx.getBean("animalController", Controller.class);
        controller.run();
    }
}

