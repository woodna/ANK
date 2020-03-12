package com.ank.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ank.dto.Herd;

/* 
Nate Wood
AnimalTrackerDao
*/

public class AnimalTrackerDao {

    HashMap<String, Herd> herds;
    private final String HEALTHY_FILE = "HealthyAnimals.txt";
    private final String UNHEALTHY_FILE = "UnhealthyAnimals.txt";
    private final String DELIMITER = "*$*";

    public AnimalTrackerDao() {
        herds = new HashMap<>();
    }

    public void addHerd(String name, Herd herd) throws NoSuchHerdException{
        herd.setRecentUpdate(LocalDate.now());
        
        if (herds.containsKey(herd.getName())){
            throw new NoSuchHerdException("A herd by that name is already stored");
        } else {
            herds.put(name, herd);
        }
    }

    public Herd viewHerd(String name) throws NoSuchHerdException {
        if (herds.get(name) == null) {
            throw new NoSuchHerdException("A herd with that name was not found");
        }
        return herds.get(name);
    }

    public List<Herd> viewAll(){
        return herds.values().stream().collect(Collectors.toList());
    }

    public void editHerd(String name, Herd editHerd) throws NoSuchHerdException {
        editHerd.setRecentUpdate(LocalDate.now());

        if (herds.replace(name, editHerd) == null){
            throw new NoSuchHerdException("That herd was not found and was unable to be edited");
        }
    }

    public void removeHerd(String name) throws NoSuchHerdException{
        if (herds.remove(name) == null){
            throw new NoSuchHerdException("That herd was not found and was unable to be removed");
        }
    }

    public int getNumHealthy(String name) {
        return herds.get(name).getHealth();
    }

    public int getNumUnhealthy(String name) {
        return herds.get(name).getPopulation() - herds.get(name).getHealth();
    }

    public BigDecimal getSellPrice(String name) {
        return herds.get(name).getSellPrice().multiply(new BigDecimal(Integer.toString(herds.get(name).getHealth())));
    }    

    public void save() throws HerdPersistenceException{
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(HEALTHY_FILE));
        } catch (Exception e) {
            throw new HerdPersistenceException("Unable to save healthy Herd data, ruh roh");
        }

        String herdAsText;

        for (Herd h : herds.values()) {
            herdAsText = marshallHealthyHerd(h);
            out.print(herdAsText);
            out.flush();
        }
        out.close();

        try {
            out = new PrintWriter(new FileWriter(UNHEALTHY_FILE));
        } catch (Exception e) {
            throw new HerdPersistenceException("Unable to save unhealthy Herd data, ruh roh");
        }

        for (Herd h : herds.values()) {
            herdAsText = marshallUnhealthyHerd(h);
            out.print(herdAsText);
            out.flush();
        }
        out.close();
    }

    public String marshallHealthyHerd(Herd herd){
        String herdAsText = herd.getName() + DELIMITER;
        herdAsText += herd.getPopulation() + DELIMITER;
        herdAsText += herd.getHealth() + DELIMITER;
        herdAsText += herd.getRecentUpdate() + DELIMITER;
        herdAsText += herd.getSellPrice();

        return herdAsText;
    }

    private String marshallUnhealthyHerd(Herd herd){
        String herdAsText = herd.getName() + DELIMITER;
        herdAsText += herd.getPopulation() + DELIMITER;
        herdAsText += herd.getPopulation() - herd.getHealth() + DELIMITER;
        herdAsText += herd.getRecentUpdate() + DELIMITER;
        herdAsText += herd.getSellPrice();

        return herdAsText;
    }

    public void load() throws HerdPersistenceException{
        Scanner sc;

        try {
            sc = new Scanner(new BufferedReader(new FileReader(HEALTHY_FILE)));
        } catch (Exception e) {
            throw new HerdPersistenceException("Unable to load healthy file");
        }

        String currentLine;
        Herd herd;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            herd = unmarshallHealthyHerd(currentLine);
            herds.put(herd.getName(), herd);
        }
        sc.close();
    }

    private Herd unmarshallHealthyHerd(String herdAsText) {
        String[] herdTokens = herdAsText.split(DELIMITER);

        Herd newHerd = new Herd(herdTokens[0]);
        newHerd.setPopulation(Integer.parseInt(herdTokens[1]));
        newHerd.setHealth(Integer.parseInt(herdTokens[2]));
        newHerd.setRecentUpdate(LocalDate.parse(herdTokens[3]));
        newHerd.setSellPrice(new BigDecimal(herdTokens[4]));

        return newHerd;
    }
}