package de.riesenberg.rockpaperscissors.model;

public enum ItemEnum {

    ROCK(0), PAPER(1), SCISSOR(2);

    private final int id;

    ItemEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
