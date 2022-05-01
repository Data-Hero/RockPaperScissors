package de.riesenberg.rockpaperscissors.model;

public class Computer {

    public static Item makeChoice() {
        return new Item(ItemEnum.from((int) Math.floor(Math.random() * 3)));
    }
}
