package com.ank.animalTrackerController;

import java.util.Arrays;
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
                        moveHerd();
                        createHerd();
                        break;
                    case 2:
                        moveHerd();
                        removeHerd();
                        break;
                    case 3:
                        moveHerd();
                        updateHerd();
                        break;
                    case 4:
                        moveHerd();
                        viewAll();
                        break;
                    case 5:
                        moveHerd();
                        viewHerd();
                        break;
                    case 6:
                        moveHerd();
                        viewHerdPrice();
                        break;
                    case 7:
                        moveHerd();
                        getAnimalStatus();
                    case 8:
                        moveHerd();
                        save();
                        break;
                    case 9:
                        moveHerd();
                        load();
                        break;
                    case 10:
                        keepGoing = false;
                        break;
                    case 11:
                        moveHerd();
                        setAnimalStatus();
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
            dao.changeLocation(newHerd);
            view.print("Herd already exists there, location changed to: " + Arrays.toString(newHerd.getLocation()));
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

    private void moveHerd() {
        List<Herd> list = dao.viewAll();
        for (Herd herd : list) {
            dao.changeLocation(herd);
        }
    }

    private void getAnimalStatus() {
        boolean status = dao.getAnimal(view.getHerdName(), view.getAnimalIndex());
        view.displayStatus(status);
    }

    private void setAnimalStatus() {
        dao.setAnimalStatus(view.getHerdName(), view.getAnimalIndex(), view.getStatus());
    }


    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommad() {
        view.displayUnknownCommandBanner();
    }
}
