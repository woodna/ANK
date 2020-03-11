package com.ank.herd;

import java.lang.ModuleLayer.Controller;

import com.ank.animalTrackerController.AnimalTrackerController;
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
        AnimalTrackerController controller = new AnimalTrackerController(dao, view);
        controller.run();

        // ApplicationContext ctx = 
        //    new ClassPathXmlApplicationContext("applicationContext.xml");
        // AnimalTrackerController controller = 
        //    ctx.getBean("animalTrackerController", AnimalTrackerController.class);
        // controller.run();
    }
}

