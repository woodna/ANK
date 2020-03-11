package com.ank.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private ArrayList<Integer> health =  new ArrayList<Integer>();
    private LocalDate recentUpdate;
    private BigDecimal sellPrice;

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

    public ArrayList<Integer> getHealth() {
        return health;
    }

    public void setHealth(ArrayList<Integer> health) {
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
    
    
}
