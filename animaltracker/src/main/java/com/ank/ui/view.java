package com.ank.ui;

/* 
Nate Wood
view
*/

import com.ank.dto.Herd;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class view {
    private UserIO io;

    public view(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("=== Main Menu ===");
        io.print("1. Add Her");
        io.print("2. Remove Herd");
        io.print("3. Edit Herd");
        io.print("4. List All Herds");
        io.print("5. Search for a Herd by name");
        io.print("6. Exit");

        return io.readInt("Please select from the " + "above choices.");
    }

    public Herd getNewHerdInfo() {
        io.print("=== Create Herd ===");
        String name = io.readString("Please enter the herd name");
        int population = io.readInt("Please enter the number of animals in the herd");
        int health = io.readInt("Please enter the number of healthy animals");
        BigDecimal singleSellPrice = io.bigDecimal("Please enter the sale price of a single animal in the herd");
        Herd currentHerd = new Herd(name);
        currentHerd.setName(name);
        currentHerd.setHealth(health);
        currentHerd.setPopulation(population);
        currentHerd.setSellPrice(singleSellPrice);
        return currentHerd;
    }
    public void displayAddSuccessBanner() {
        io.readString("Herd successfully created. Please press enter to continue");
    }

    public void displayHerdList(List<Herd> herds) {
        io.print("=== Display All Herds ===");
        for (Herd currentHerd : herds) {
            io.print(currentHerd.getName() + ":" +
                    currentHerd.getPopulation() + ":" +
                    currentHerd.getSellPrice() + ":" +
                    currentHerd.getHealth());
        }
        io.readString("Please press enter to continue.");
    }

    public String getHerdName() {
        return io.readString("Please enter the name of the Herd");
    }

    public void displayHerd(Herd Herd) {
        getHerdName();
        io.print("=== Display Herd ===");
        if (Herd !=null) {
            io.print(Herd.getName());
            io.print(Integer.toString(Herd.getPopulation()));
            io.print(Integer.toString(Herd.getHealth()));
            io.print("");
        } else {
            io.print("No such Herd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveHerdBanner() {
        io.print("=== Remove Herd ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Herd successfully removed. Please press enter to continue.");
    }

    public void displayEditHerdBanner() {
        io.print("=== Edit Herd ===");
    }

    public void displayEditSuccessBanner() {
        io.readString("Herd information successfully edited Please press enter to continue");
    }

    public void displayExitBanner() {
        io.print("Good Bye");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayHerdInfoBanner() {
        io.print("=== Herd Info ===");
    }
}

