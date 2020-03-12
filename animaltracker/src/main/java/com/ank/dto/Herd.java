package com.ank.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khuxi
 */
public class Herd {
    
    private String name;
    private int population;
    private int health;
    private LocalDate recentUpdate;
    private BigDecimal sellPrice;
    private int[] location = new int[2];
    private List<Boolean> animal;
    Random r = new Random();

    public Herd(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public LocalDate getRecentUpdate() {
        return recentUpdate;
    }

    public void setRecentUpdate(LocalDate recentUpdate) {
        this.recentUpdate = recentUpdate;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public List<Boolean> getAnimal() {
        return animal;
    }

    public void setAnimal(int population, int healthy) {
        int unhealthy = population-healthy;
        animal = new ArrayList<Boolean>(Arrays.asList(new Boolean[population]));
        Collections.fill(animal, Boolean.TRUE);
        for(int i = 0; i < unhealthy; i++){
            animal.set(r.nextInt(animal.size()), Boolean.TRUE);
        }
    }
    
}
