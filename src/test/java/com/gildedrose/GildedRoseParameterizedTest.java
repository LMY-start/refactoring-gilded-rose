package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
                {new RoseItem[]{new RoseItem("+5 Dexterity Vest", 0, 2)}, "+5 Dexterity Vest", -1, 0},
                {new RoseItem[]{new RoseItem("+5 Dexterity Vest", 0, 5)}, "+5 Dexterity Vest", -1, 3},

                {new RoseItem[]{new RoseItem("Aged Brie", 2, 0)}, "Aged Brie", 1, 1},
                {new RoseItem[]{new RoseItem("Aged Brie", 2, 0)}, "Aged Brie", 1, 1},
                {new RoseItem[]{new RoseItem("Aged Brie", 1, 1)}, "Aged Brie", 0, 2},
                {new RoseItem[]{new RoseItem("Aged Brie", 0, 0)}, "Aged Brie", -1, 2},
                {new RoseItem[]{new RoseItem("Aged Brie", 0, 2)}, "Aged Brie", -1, 4},

                {new RoseItem[]{new RoseItem("Elixir of the Mongoose", 5, 9)}, "Elixir of the Mongoose", 4, 8},
                {new RoseItem[]{new RoseItem("Elixir of the Mongoose", 1, 1)}, "Elixir of the Mongoose", 0, 0},
                {new RoseItem[]{new RoseItem("Elixir of the Mongoose", 1, 0)}, "Elixir of the Mongoose", 0, 0},
                {new RoseItem[]{new RoseItem("Elixir of the Mongoose", 0, 0)}, "Elixir of the Mongoose", -1, 0},
                {new RoseItem[]{new RoseItem("Elixir of the Mongoose", 0, 2)}, "Elixir of the Mongoose", -1, 0},
                {new RoseItem[]{new RoseItem("Elixir of the Mongoose", 0, 5)}, "Elixir of the Mongoose", -1, 3},

                {new RoseItem[]{new RoseItem("foo", 1, 2)}, "foo", 0, 1},
                {new RoseItem[]{new RoseItem("foo", 0, 2)}, "foo", -1, 0},
                {new RoseItem[]{new RoseItem("foo", 0, 5)}, "foo", -1, 3},
        });
    }

    @Test
    public void should_return_right_sell_and_quality_when_update_quality_given_the_rose_item() {
        GildedRose gildedRose = new GildedRose(roseItems);

        gildedRose.updateQuality();

        String name = gildedRose.roseItems[0].name;
        String messageFormat = "Test for " + name + " of %s, the actual value is %s, but excepted value is %s";
        assertThat(String.format(messageFormat, "name", name, exceptedRoseName),
                   name, is(exceptedRoseName));
        int sellIn = gildedRose.roseItems[0].sellIn;
        assertThat(String.format(messageFormat, "sellIn", sellIn, +exceptedSellIn),
                   sellIn, is(exceptedSellIn));
        int quality = gildedRose.roseItems[0].quality;
        assertThat(String.format(messageFormat, "quality", quality, exceptedQuality),
                   quality, is(exceptedQuality));
    }
}
