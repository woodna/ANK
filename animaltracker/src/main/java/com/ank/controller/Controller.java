package com.ank.controller;

import java.util.List;

import com.ank.dao.AnimalTrackerDao;
import com.ank.dao.HerdPersistenceException;
import com.ank.dao.NoSuchHerdException;
import com.ank.dto.Herd;
import com.ank.ui.view;

/* 
Nate Wood
Controller
 */
public class Controller {

    AnimalTrackerDao dao;
    view view;

    public Controller(AnimalTrackerDao dao, view view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        try {
            while (keepGoing) {

                int menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        viewAll();
                        break;
                    case 2:
                        viewHerd();
                        break;
                    case 3:
                        createHerd();
                        break;
                    case 4:
                        updateHerd();
                        break;
                    case 5:
                        removeHerd();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommad();
                }

            }
            exitMessage();
        } catch (HerdPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void viewAll() throws HerdPersistenceException {
        List<Herd> herdList = dao.viewAll();
        //view.
    }

    private void viewHerd() {
        String name = view.getHerdName();
        try {
            Herd herd = dao.viewHerd(name);
        } catch (NoSuchHerdException e) {
            view.print(e.getMessage());
        }
        //view.displayHerd(herd);
    }

    private void createHerd() {
        Herd newHerd = view.getNewHerdInfo();
        dao.addHerd(newHerd.getName(), newHerd);
    }

    private void updateHerd() {
        String name = view.getHerdName();
        Herd currentHerd = dao.viewHerd(name);
        Herd editHerd = view.getEditHerdInfo(currentHerd);
        dao.editHerd(name, editHerd);
    }

    private void removeHerd() {
        String name = view.getHerdName();
        try {
            dao.viewHerd(name);;
        } catch (NoSuchHerdException e) {
            view.print(e.getMessage());
        }
    }

    private void exitMessage() {
        //view.displayExitBanner();
    }

    private void unknownCommad() {
        //view.displayUnknownCommandBanner();
    }
}
