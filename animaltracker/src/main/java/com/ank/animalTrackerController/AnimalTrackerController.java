package com.ank.animalTrackerController;

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
public class AnimalTrackerController {

    AnimalTrackerDao dao;
    view view;

    public AnimalTrackerController(AnimalTrackerDao dao, view view) {
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
                        createHerd();
                        break;
                    case 2:
                        removeHerd();
                        break;
                    case 3:
                        updateHerd();
                        break;
                    case 4:
                        viewAll();
                        break;
                    case 5:
                        viewHerd();
                        break;
                    case 6:
                        viewHerdPrice();
                        break;
                    case 7:
                        save();
                        break;
                    case 8:
                        load();
                        break;
                    case 9:
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

    private void load() {
        try {
            dao.load();
        } catch(HerdPersistenceException e){
            view.print(e.getMessage());
        }
    }

    private void save() {
        try {
            dao.save();
        } catch(HerdPersistenceException e) {
            view.print(e.getMessage());
        }
    }

    private void viewHerdPrice() {
        view.displaySellPrice(dao.getSellPrice(view.getHerdName()));
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void viewAll() throws HerdPersistenceException {
        List<Herd> herdList = dao.viewAll();
        view.displayHerdList(herdList);
    }

    private void viewHerd() {
        String name = view.getHerdName();
        Herd herd = null;
        try {
            herd = dao.viewHerd(name);
        } catch (NoSuchHerdException e) {
            view.print(e.getMessage());
        }
        view.displayHerd(herd);
    }

    private void createHerd() {
        Herd newHerd = view.getNewHerdInfo();
        boolean check = dao.checkLocation(newHerd);
        if (!check) {
            try {
                dao.addHerd(newHerd.getName(), newHerd);
            } catch (NoSuchHerdException e) {
                view.print(e.getMessage());
            }
        } else {
            changeLocation(newHerd);
            view.print(newHerd.getLocation().toString());
            try {
                dao.addHerd(newHerd.getName(), newHerd);
            } catch (NoSuchHerdException e) {
                view.print(e.getMessage());
            }
        }
    }

    private void updateHerd() {
        try {
            String name = view.getHerdName();
            dao.editHerd(name, view.getEditHerdInfo(name));
        } catch (NoSuchHerdException e) {
            view.print(e.getMessage());
        }
    }

    private void removeHerd() {
        String name = view.getHerdName();
        try {
            dao.viewHerd(name);
            ;
        } catch (NoSuchHerdException e) {
            view.print(e.getMessage());
        }
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommad() {
        view.displayUnknownCommandBanner();
    }
}
