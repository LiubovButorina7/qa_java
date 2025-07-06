package com.example;

import java.util.List;

public class Lion {
    private final Predator predator;
    boolean hasMane;

    public Lion(Predator predator, String sex) throws Exception {
        this.predator = predator;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return ((Feline)predator).getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return ((Feline)predator).getFood("Хищник");
    }
}
