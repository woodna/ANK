package com.ank.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        return this.location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

}
