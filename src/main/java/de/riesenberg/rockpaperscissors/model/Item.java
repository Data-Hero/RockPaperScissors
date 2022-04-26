package de.riesenberg.rockpaperscissors.model;

public class Item {
    private ItemEnum item;

    public Item(ItemEnum item) {
        this.item = item;
    }

    public ItemEnum getItem() {
        return item;
    }

    public void setItem(ItemEnum item) {
        this.item = item;
    }

    public int compareTo(Item secondItem) {
        if (this.getItem() == ItemEnum.ROCK && secondItem.getItem() == ItemEnum.SCISSOR ||
                this.getItem() == ItemEnum.SCISSOR && secondItem.getItem() == ItemEnum.ROCK) {
            return -1*(this.getItem().getId()-secondItem.getItem().getId());
        } else {
            return this.getItem().getId()-secondItem.getItem().getId();
        }
    }
}
