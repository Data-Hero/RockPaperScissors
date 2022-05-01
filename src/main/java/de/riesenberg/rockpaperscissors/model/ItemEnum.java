package de.riesenberg.rockpaperscissors.model;

public enum ItemEnum {

    ROCK(0), PAPER(1), SCISSOR(2), NONE(3);

    private final int id;

    public static ItemEnum from(int id) {
        return switch (id) {
            case 0 -> ItemEnum.ROCK;
            case 1 -> ItemEnum.PAPER;
            case 2 -> ItemEnum.SCISSOR;
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }

    ItemEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
