package com.ank.controller;

import com.ank.service.ServiceLayer;
import com.ank.ui.view;
import java.util.List;

/* 
Nate Wood
Controller
 */
public class Controller {

    ServiceLayer service;
    view view;

    public Controller(ServiceLayer service, view view) {
        this.service = service;
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
        List<Herd> vendingItemList = service.viewAll();
        //view.
    }
    
    private void viewHerd() throws NoSuchHerdException{
        String name = view.getHerdName();
        Herd herd = service.getHerd(name);
        //view.displayHerd(herd);
    }
    
    private void createHerd() throws HerdPersistenceException {
        Herd newHerd = view.getNewHerdInfo();
        service.addHerd(newHerd.getName(), newHerd);
    }
    
    private void updateHerd() throws HerdPersistenceException {
        String name = view.getHerdName();
        Herd currentHerd = service.getHerd(name);
        Herd editHerd = view.getEditHerdInfo(currentHerd);
        service.editHerd(name, editHerd);
    }
    
    private void removeHerd() throws NoSuchHerdException{
        String name = view.getHerdName();
        service.getHerd(name);
    }
    
    private void exitMessage(){
        //view.displayExitBanner();
    }
    private void unknownCommad(){
        //view.displayUnknownCommandBanner();
    }
}

