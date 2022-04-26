package de.riesenberg.rockpaperscissors.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class ItemTest {

    private Item itemA;
    private Item itemB;
    private Item itemC;

    @BeforeEach
    public void init() {
        itemA = new Item(ItemEnum.ROCK);
        itemB = new Item(ItemEnum.PAPER);
        itemC = new Item(ItemEnum.SCISSOR);

    }

    @Test
    void compareRockToPaperThenNegative() {
        assertThat(itemA.compareTo(itemB)).isNegative();
        assertThat(itemB.compareTo(itemA)).isPositive();
    }


    @Test
    void compareRockToScissorThenPositive() {
        assertThat(itemA.compareTo(itemC)).isPositive();
        assertThat(itemC.compareTo(itemA)).isNegative();
    }


    @Test
    void comparePaperToScissorThenNegative() {
        assertThat(itemB.compareTo(itemC)).isNegative();
        assertThat(itemC.compareTo(itemB)).isPositive();
    }


}
