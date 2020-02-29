package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GildedRoseParameterizedTest {

    private RoseItem[] roseItems;
    private String exceptedRoseName;
    private int exceptedSellIn;
    private int exceptedQuality;

    public GildedRoseParameterizedTest(RoseItem[] roseItems, String exceptedRoseName, int exceptedSellIn, int exceptedQuality) {
        this.roseItems = roseItems;
        this.exceptedRoseName = exceptedRoseName;
        this.exceptedSellIn = exceptedSellIn;
        this.exceptedQuality = exceptedQuality;
    }


    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {new RoseItem[]{new RoseItem("+5 Dexterity Vest", 10, 20)}, "+5 Dexterity Vest", 9, 19},
                {new RoseItem[]{new RoseItem("+5 Dexterity Vest", 1, 1)}, "+5 Dexterity Vest", 0, 0},
                {new RoseItem[]{new RoseItem("+5 Dexterity Vest", 1, 0)}, "+5 Dexterity Vest", 0, 0},
                {new RoseItem[]{new RoseItem("+5 Dexterity Vest", 0, 0)}, "+5 Dexterity Vest", -1, 0},

                {new RoseItem[]{new RoseItem("Aged Brie", 2, 0)}, "Aged Brie", 1, 1},
                {new RoseItem[]{new RoseItem("Aged Brie", 2, 0)}, "Aged Brie", 1, 1},
                {new RoseItem[]{new RoseItem("Aged Brie", 1, 1)}, "Aged Brie", 0, 2},
                {new RoseItem[]{new RoseItem("Aged Brie", 0, 2)}, "Aged Brie", -1, 4}
        });
    }

    @Test
    public void should_return_right_sell_and_quality_when_update_quality_given_the_rose_item() {
        GildedRose gildedRose = new GildedRose(roseItems);

        gildedRose.updateQuality();

        assertEquals(exceptedRoseName, gildedRose.roseItems[0].name);
        assertEquals(exceptedSellIn, gildedRose.roseItems[0].sellIn);
        assertEquals(exceptedQuality, gildedRose.roseItems[0].quality);
    }
}
