package com.ank.herd;

import javax.swing.text.View;

import com.ank.controller.Controller;
import com.ank.dao.AnimalTrackerDao;
import com.ank.ui.UserIO;
import com.ank.ui.UserIOConsoleImp1;
import com.ank.ui.view;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserIO io = new UserIOConsoleImp1();
        AnimalTrackerDao dao = new AnimalTrackerDao();
        view view = new view(io);
        Controller controller = new Controller(dao, view);
        controller.run();

        // ApplicationContext ctx = 
        //    new ClassPathXmlApplicationContext("applicationContext.xml");
        // Controller controller = 
        //    ctx.getBean("animalController", Controller.class);
        // controller.run();
    }
}

