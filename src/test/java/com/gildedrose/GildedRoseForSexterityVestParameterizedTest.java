package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GildedRoseForSexterityVestParameterizedTest {

    private RoseItem[] roseItems;
    private int exceptedSellIn;
    private int exceptedQuality;
    private static String roseName = "+5 Dexterity Vest";

    public GildedRoseForSexterityVestParameterizedTest(RoseItem[] roseItems, int exceptedSellIn, int exceptedQuality) {
        this.roseItems = roseItems;
        this.exceptedSellIn = exceptedSellIn;
        this.exceptedQuality = exceptedQuality;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {new RoseItem[]{new RoseItem(roseName, 10, 20)}, 9, 19},
                {new RoseItem[]{new RoseItem(roseName, 1, 1)}, 0, 0},
                {new RoseItem[]{new RoseItem(roseName, 1, 0)}, 0, 0},
                {new RoseItem[]{new RoseItem(roseName, 0, 0)}, -1, 0},
        });
    }

    @Test
    public void should_return_right_sell_and_quality_when_update_quality_given_the_rose_item() {
        GildedRose gildedRose = new GildedRose(roseItems);

        gildedRose.updateQuality();

        assertEquals(roseName, gildedRose.roseItems[0].name);
        assertEquals(exceptedSellIn, gildedRose.roseItems[0].sellIn);
        assertEquals(exceptedQuality, gildedRose.roseItems[0].quality);
    }

}