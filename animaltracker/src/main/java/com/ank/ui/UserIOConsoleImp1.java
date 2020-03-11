/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ank.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Nate Wood
 */
public class UserIOConsoleImp1 implements UserIO{

    Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return sc.nextDouble();
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        while (true) {
            System.out.println(prompt);
            double x = sc.nextDouble();
            if (x >= min && x <= max) {
                return x;
            }
            System.out.println("That was not a valid input, try again.");
        }
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return sc.nextFloat();
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        while (true) {
            System.out.println(prompt);
            float x = sc.nextFloat();
            if (x >= min && x <= max) {
                return x;
            }
            System.out.println("That was not a valid input, try again.");
        }
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int i = sc.nextInt();
        sc.nextLine();
        return i;
        
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            int x = sc.nextInt();
            if (x >= min && x <= max) {
                sc.nextLine();
                return x;
            }
            System.out.println("That was not a valid input, try again.");
        }
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return sc.nextLong();
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        while (true) {
            System.out.println(prompt);
            long x = sc.nextLong();
            if (x >= min && x <= max) {
                return x;
            }
            System.out.println("That was not a valid input, try again.");
        }
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public BigDecimal bigDecimal(String prompt) {
        Scanner sc = new Scanner(System.in);
        BigDecimal bd = new BigDecimal("0");
        do {
            System.out.println(prompt);
            try {
                bd = sc.nextBigDecimal();
            } catch (Exception e) {
                System.out.println("Invalid Input!");
            }
        } while (bd.equals("") || bd.floatValue() <= 0 );
        return bd;
    }
}
