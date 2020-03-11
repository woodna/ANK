package com.ank.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

import com.ank.dto.Herd;

/* 
Nate Wood
AnimalTrackerDao
*/

public class AnimalTrackerDao {

    HashMap<String, Herd> herds;

    public AnimalTrackerDao() {
        herds = new HashMap<>();
    }

    public void addHerd(String name, int numAnimals, int numHealthy, BigDecimal sellPrice) throws NoSuchHerdException{
        Herd newHerd = new Herd(name);
        newHerd.setName(name);
        newHerd.setNumAnimals(numAnimals);
        newHerd.setHealthy(numHealthy);
        LocalDate date = LocalDate.now();
        newHerd.setDate(LocalDate.now());
        newHerd.sellSetPrice(sellPrice);
        
        if (herds.containsKey(name)){
            throw new NoSuchHerdException("A herd by that name is already stored");
        } else {
            herds.put(name, newHerd);
        }
    }

    public Herd viewHerd(String name){
        return herds.get(name);
    }

    public HashMap<String, Herd> viewAll(){
        return herds;
    }

    public void editHerd(String name, int numAnimals, int numHealthy, BigDecimal sellPrice) throws NoSuchHerdException {
        Herd editHerd = new Herd(name);
        editHerd.setName(name);
        editHerd.setNumAnimals(numAnimals);
        editHerd.setHealthy(numHealthy);
        LocalDate date = LocalDate.now();
        editHerd.setDate(LocalDate.now());
        editHerd.sellSetPrice(sellPrice);

        if (herds.replace(name, editHerd) == null){
            throw new NoSuchHerdException("That herd was not found and was unable to be edited");
        }
    }

    public void removeHerd(String name){
        if (herds.remove(name) == null){
            throw new NoSuchHerdException("That herd was not found and was unable to be removed")
        }
    }

    public int getNumHealthy(String name) {
        return herds.get(name).getNumHealthy();
    }

    public int getNumUnhealthy(String name) {
        return herds.get(name).getNumAnimals() - herds.get(name).getNumHealthy();
    }

    public BigDecimal getSellPrice(String name) {
        return herds.get(name).getSellPrice().multiply(new BigDecimal(herds.get(name).getNumHealthy().toString()));
    }    
}