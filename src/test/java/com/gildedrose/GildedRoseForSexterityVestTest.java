package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseForSexterityVestTest {


    private String roseName;

    @Before
    public void setUp() {
        roseName = "+5 Dexterity Vest";
    }

    @Test
    public void should_sell_in_decrease_1_and_quality_decrease_1_when_update_quality_given_sell_in_is_10_and_quality_is_20() {
        GildedRose gildedRose = new GildedRose(new RoseItem[]{new RoseItem(roseName, 10, 20)});

        gildedRose.updateQuality();

        assertEquals(roseName, gildedRose.roseItems[0].name);
        assertEquals(9, gildedRose.roseItems[0].sellIn);
        assertEquals(19, gildedRose.roseItems[0].quality);
    }

    @Test
    public void should_sell_in_decrease_1_and_quality_decrease_1_when_update_quality_given_sell_in_is_1_and_quality_is_1() {
        GildedRose gildedRose = new GildedRose(new RoseItem[]{new RoseItem(roseName, 1, 1)});

        gildedRose.updateQuality();

        assertEquals(roseName, gildedRose.roseItems[0].name);
        assertEquals(0, gildedRose.roseItems[0].sellIn);
        assertEquals(0, gildedRose.roseItems[0].quality);
    }

    @Test
    public void should_sell_in_decrease_1_and_quality_not_change_when_update_quality_given_sell_in_is_1_and_quality_is_0() {
        GildedRose gildedRose = new GildedRose(new RoseItem[]{new RoseItem(roseName, 1, 0)});

        gildedRose.updateQuality();

        assertEquals(roseName, gildedRose.roseItems[0].name);
        assertEquals(0, gildedRose.roseItems[0].sellIn);
        assertEquals(0, gildedRose.roseItems[0].quality);
    }

    @Test
    public void should_sell_in_decrease_1_and_quality_not_change_when_update_quality_given_sell_in_is_0_and_quality_is_0() {
        GildedRose gildedRose = new GildedRose(new RoseItem[]{new RoseItem(roseName, 0, 0)});

        gildedRose.updateQuality();

        assertEquals(roseName, gildedRose.roseItems[0].name);
        assertEquals(-1, gildedRose.roseItems[0].sellIn);
        assertEquals(0, gildedRose.roseItems[0].quality);
    }
}
