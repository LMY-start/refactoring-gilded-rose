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

    private String roseName;
    private int sellIn;
    private int quality;
    private String exceptedRoseName;
    private int exceptedSellIn;
    private int exceptedQuality;

    public GildedRoseParameterizedTest(String roseName, int sellIn, int quality, String exceptedRoseName, int exceptedSellIn, int exceptedQuality) {
        this.roseName = roseName;
        this.sellIn = sellIn;
        this.quality = quality;
        this.exceptedRoseName = exceptedRoseName;
        this.exceptedSellIn = exceptedSellIn;
        this.exceptedQuality = exceptedQuality;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {"+5 Dexterity Vest", 10, 20, "+5 Dexterity Vest", 9, 19},
                {"+5 Dexterity Vest", 1, 1, "+5 Dexterity Vest", 0, 0},
                {"+5 Dexterity Vest", 1, 0, "+5 Dexterity Vest", 0, 0},
                {"+5 Dexterity Vest", 0, 0, "+5 Dexterity Vest", -1, 0},
                {"+5 Dexterity Vest", 0, 2, "+5 Dexterity Vest", -1, 0},
                {"+5 Dexterity Vest", 0, 5, "+5 Dexterity Vest", -1, 3},
                {"+5 Dexterity Vest", -1, -1, "+5 Dexterity Vest", -2, -1},

                {"Aged Brie", 2, 0, "Aged Brie", 1, 1},
                {"Aged Brie", 1, 1, "Aged Brie", 0, 2},
                {"Aged Brie", 0, 0, "Aged Brie", -1, 2},
                {"Aged Brie", 0, 2, "Aged Brie", -1, 4},
                {"Aged Brie", 3, 50, "Aged Brie", 2, 50},
                {"Aged Brie", 3, 49, "Aged Brie", 2, 50},
                {"Aged Brie", 3, 48, "Aged Brie", 2, 49},
                {"Aged Brie", -1, 0, "Aged Brie", -2, 2},
                {"Aged Brie", -1, -1, "Aged Brie", -2, 1},

                {"Elixir of the Mongoose", 5, 9, "Elixir of the Mongoose", 4, 8},
                {"Elixir of the Mongoose", 1, 1, "Elixir of the Mongoose", 0, 0},
                {"Elixir of the Mongoose", 1, 0, "Elixir of the Mongoose", 0, 0},
                {"Elixir of the Mongoose", 0, 0, "Elixir of the Mongoose", -1, 0},
                {"Elixir of the Mongoose", 0, 2, "Elixir of the Mongoose", -1, 0},
                {"Elixir of the Mongoose", -1, -1, "Elixir of the Mongoose", -2, -1},

                {"Sulfuras, Hand of Ragnaros", 0, 80, "Sulfuras, Hand of Ragnaros", 0, 80},
                {"Sulfuras, Hand of Ragnaros", -1, 80, "Sulfuras, Hand of Ragnaros", -1, 80},
                {"Sulfuras, Hand of Ragnaros", 2, 30, "Sulfuras, Hand of Ragnaros", 2, 30},
                {"Sulfuras, Hand of Ragnaros", 10, 3, "Sulfuras, Hand of Ragnaros", 10, 3},
                {"Sulfuras, Hand of Ragnaros", -1, -1, "Sulfuras, Hand of Ragnaros", -1, -1},

                {"Backstage passes to a TAFKAL80ETC concert", 15, 20, "Backstage passes to a TAFKAL80ETC concert", 14, 21},
                {"Backstage passes to a TAFKAL80ETC concert", 15, 49, "Backstage passes to a TAFKAL80ETC concert", 14, 50},
                {"Backstage passes to a TAFKAL80ETC concert", 15, 50, "Backstage passes to a TAFKAL80ETC concert", 14, 50},
                {"Backstage passes to a TAFKAL80ETC concert", 6, 20, "Backstage passes to a TAFKAL80ETC concert", 5, 22},
                {"Backstage passes to a TAFKAL80ETC concert", 6, 49, "Backstage passes to a TAFKAL80ETC concert", 5, 50},
                {"Backstage passes to a TAFKAL80ETC concert", 6, 50, "Backstage passes to a TAFKAL80ETC concert", 5, 50},
                {"Backstage passes to a TAFKAL80ETC concert", 5, 20, "Backstage passes to a TAFKAL80ETC concert", 4, 23},
                {"Backstage passes to a TAFKAL80ETC concert", 5, 49, "Backstage passes to a TAFKAL80ETC concert", 4, 50},
                {"Backstage passes to a TAFKAL80ETC concert", 5, 50, "Backstage passes to a TAFKAL80ETC concert", 4, 50},
                {"Backstage passes to a TAFKAL80ETC concert", 1, 20, "Backstage passes to a TAFKAL80ETC concert", 0, 23},
                {"Backstage passes to a TAFKAL80ETC concert", 0, 20, "Backstage passes to a TAFKAL80ETC concert", -1, 0},
                {"Backstage passes to a TAFKAL80ETC concert", 0, 50, "Backstage passes to a TAFKAL80ETC concert", -1, 0},
                {"Backstage passes to a TAFKAL80ETC concert", -1, 0, "Backstage passes to a TAFKAL80ETC concert", -2, 0},
                {"Backstage passes to a TAFKAL80ETC concert", -1, -1, "Backstage passes to a TAFKAL80ETC concert", -2, 0},

                {"foo", 1, 2, "foo", 0, 1},
                {"foo", 0, 2, "foo", -1, 0},
                {"foo", 0, 5, "foo", -1, 3},
                {"foo", -1, -1, "foo", -2, -1}
        });
    }

    @Test
    public void should_return_right_sell_and_quality_when_update_quality_given_the_rose_item() {
        GildedRose gildedRose = new GildedRose(new RoseItem[]{new RoseItem(roseName, sellIn, quality)});

        gildedRose.updateQuality();

        String name = gildedRose.roseItems[0].name;
        String messageFormat = "Test for (" + this.roseName + ", " + this.sellIn + ", " + this.quality + ")" +
                " of %s, the actual value is %s, but excepted value is %s";

        assertThat(String.format(messageFormat, "name", name, exceptedRoseName),
                   name, is(exceptedRoseName));

        int sellIn = gildedRose.roseItems[0].sellIn;
        assertThat(String.format(messageFormat, "sellIn", sellIn, exceptedSellIn),
                   sellIn, is(exceptedSellIn));

        int quality = gildedRose.roseItems[0].quality;
        assertThat(String.format(messageFormat, "quality", quality, exceptedQuality),
                   quality, is(exceptedQuality));
    }
}
