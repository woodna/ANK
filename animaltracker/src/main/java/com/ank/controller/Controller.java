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
        
        

    public void run() {
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        viewAll();
                        break;
                    case 2:
                        viewHerd();
                        break;
                    case 3:
                        addHerd();
                        break;
                    case 4:
                        editHerd();
                        break;
                    case 5:
                        removeHerd();
                        break;
                    case 6:
                        getSellPrice;
                        break;
                    case 7:
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
    
    private void viewAll() throws HerdPersistenceException{
        List<Herd> vendingItemList = dao.viewAll();
        //view.
    }
    
    private void viewHerd() throws NoSuchHerdException{
        String name = view.getHerdName();
        Herd herd = dao.viewHerd(name);
        //view.displayHerd(herd);
    }
    
    private void createHerd() throws HerdPersistenceException {
        Herd newHerd = view.getNewHerdInfo();
        dao.addHerd(newHerd.getName(), newHerd);
    }
    
    private void updateHerd() throws HerdPersistenceException {
        String name = view.getHerdName();
        Herd currentHerd = dao.viewHerd(name);
        Herd editHerd = view.getEditHerdInfo(currentHerd);
        dao.editHerd(name, editHerd);
    }
    
    private void removeHerd() throws NoSuchHerdException{
        String name = view.getHerdName();
        dao.viewHerd(name);
    }
    
    private void exitMessage(){
        //view.displayExitBanner();
    }
    private void unknownCommad(){
        //view.displayUnknownCommandBanner();
    }
}

