package com.ank.ui;

import java.math.BigDecimal;
import java.util.List;

/* 
Nate Wood
view
*/

import com.ank.dto.Herd;

public class view {
    private UserIO io;

    public view(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("=== Main Menu ===");
        io.print("1. Add Herd");
        io.print("2. Remove Herd");
        io.print("3. Edit Herd");
        io.print("4. List All Herds");
        io.print("5. Search for a Herd by name");
        io.print("6. Get sell price of a herd");
        io.print("7. Save");
        io.print("8. Load");
        io.print("9. Exit");

        return io.readInt("Please select from the " + "above choices.", 1, 9);
    }

    public Herd getNewHerdInfo() {
        io.print("=== Create Herd ===");
        boolean badIn = true;
        String name = null;
        while (badIn) {
            name = io.readString("Please enter the herd name");
            if (!name.contains("*$*")) {
                badIn = false;
            } else {
                io.print("That was not a valid input, please do not inclue *$*.");
            }
        }
        int population = io.readInt("Please enter the number of animals in the herd");
        int health = io.readInt("Please enter the number of healthy animals");
        BigDecimal singleSellPrice = io.readPosDecimal("Please enter the sale price of a single animal in the herd");
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
            io.print("Name: " + currentHerd.getName() + ":" + "Population: " + currentHerd.getPopulation() + ":"
                    + "Health: " + currentHerd.getHealth() + ":" + "Sell Price: " + currentHerd.getSellPrice());
        }
        io.readString("Please press enter to continue.");
    }

    public String getHerdName() {
        return io.readString("Please enter the name of the Herd");
    }

    public void displayHerd(Herd Herd) {
        io.print("=== Display Herd ===");
        if (Herd != null) {
            io.print("Herd: " + Herd.getName());
            io.print("Population: " + Integer.toString(Herd.getPopulation()));
            io.print("Health: " + Integer.toString(Herd.getHealth()));
            io.print("Sell Price: " + (Herd.getSellPrice()));
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

    public Herd getEditHerdInfo(String name) {
        io.print("=== Edit Herd ===");
        int population = io.readInt("Please enter the number of animals in the herd");
        int health = io.readInt("Please enter the number of healthy animals");
        BigDecimal singleSellPrice = io.readPosDecimal("Please enter the sale price of a single animal in the herd");
        Herd currentHerd = new Herd(name);
        currentHerd.setHealth(health);
        currentHerd.setPopulation(population);
        currentHerd.setSellPrice(singleSellPrice);
        return currentHerd;
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

    public void print(String string) {
        io.print(string);
    }

    public void displaySellPrice(BigDecimal sellPrice) {
        io.print("This herd's healthy animals sell for a total of $" + sellPrice);
    }

    public void displayUnknownCommandBanner() {
        io.print("That was an unknown command");
    }
}
