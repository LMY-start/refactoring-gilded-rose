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
        String backstagePassesToATafkal80etcConcert = "Backstage passes to a TAFKAL80ETC concert";
        String dexterityVest = "+5 Dexterity Vest";
        String agedBrie = "Aged Brie";
        String elixirOfTheMongoose = "Elixir of the Mongoose";
        String sulfurasHandOfRagnaros = "Sulfuras, Hand of Ragnaros";

        return Arrays.asList(new Object[][]{
                {dexterityVest, 10, 20, dexterityVest, 9, 19},
                {dexterityVest, 1, 1, dexterityVest, 0, 0},
                {dexterityVest, 1, 0, dexterityVest, 0, 0},
                {dexterityVest, 0, 0, dexterityVest, -1, 0},
                {dexterityVest, 0, 2, dexterityVest, -1, 0},
                {dexterityVest, 0, 5, dexterityVest, -1, 3},
                {dexterityVest, -1, -1, dexterityVest, -2, -1},

                {agedBrie, 2, 0, agedBrie, 1, 1},
                {agedBrie, 1, 1, agedBrie, 0, 2},
                {agedBrie, 0, 0, agedBrie, -1, 2},
                {agedBrie, 0, 2, agedBrie, -1, 4},
                {agedBrie, 3, 50, agedBrie, 2, 50},
                {agedBrie, 3, 49, agedBrie, 2, 50},
                {agedBrie, 3, 48, agedBrie, 2, 49},
                {agedBrie, -1, 0, agedBrie, -2, 2},
                {agedBrie, -1, -1, agedBrie, -2, 1},

                {elixirOfTheMongoose, 5, 9, elixirOfTheMongoose, 4, 8},
                {elixirOfTheMongoose, 1, 1, elixirOfTheMongoose, 0, 0},
                {elixirOfTheMongoose, 1, 0, elixirOfTheMongoose, 0, 0},
                {elixirOfTheMongoose, 0, 0, elixirOfTheMongoose, -1, 0},
                {elixirOfTheMongoose, 0, 2, elixirOfTheMongoose, -1, 0},
                {elixirOfTheMongoose, -1, -1, elixirOfTheMongoose, -2, -1},

                {sulfurasHandOfRagnaros, 0, 80, sulfurasHandOfRagnaros, 0, 80},
                {sulfurasHandOfRagnaros, -1, 80, sulfurasHandOfRagnaros, -1, 80},
                {sulfurasHandOfRagnaros, 2, 30, sulfurasHandOfRagnaros, 2, 30},
                {sulfurasHandOfRagnaros, 10, 3, sulfurasHandOfRagnaros, 10, 3},
                {sulfurasHandOfRagnaros, -1, -1, sulfurasHandOfRagnaros, -1, -1},

                {backstagePassesToATafkal80etcConcert, 15, 20, backstagePassesToATafkal80etcConcert, 14, 21},
                {backstagePassesToATafkal80etcConcert, 15, 49, backstagePassesToATafkal80etcConcert, 14, 50},
                {backstagePassesToATafkal80etcConcert, 15, 50, backstagePassesToATafkal80etcConcert, 14, 50},
                {backstagePassesToATafkal80etcConcert, 6, 20, backstagePassesToATafkal80etcConcert, 5, 22},
                {backstagePassesToATafkal80etcConcert, 6, 49, backstagePassesToATafkal80etcConcert, 5, 50},
                {backstagePassesToATafkal80etcConcert, 6, 50, backstagePassesToATafkal80etcConcert, 5, 50},
                {backstagePassesToATafkal80etcConcert, 5, 20, backstagePassesToATafkal80etcConcert, 4, 23},
                {backstagePassesToATafkal80etcConcert, 5, 49, backstagePassesToATafkal80etcConcert, 4, 50},
                {backstagePassesToATafkal80etcConcert, 5, 50, backstagePassesToATafkal80etcConcert, 4, 50},
                {backstagePassesToATafkal80etcConcert, 1, 20, backstagePassesToATafkal80etcConcert, 0, 23},
                {backstagePassesToATafkal80etcConcert, 0, 20, backstagePassesToATafkal80etcConcert, -1, 0},
                {backstagePassesToATafkal80etcConcert, 0, 50, backstagePassesToATafkal80etcConcert, -1, 0},
                {backstagePassesToATafkal80etcConcert, -1, 0, backstagePassesToATafkal80etcConcert, -2, 0},
                {backstagePassesToATafkal80etcConcert, -1, -1, backstagePassesToATafkal80etcConcert, -2, 0},

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

        String name = gildedRose.roseItems[0].getName();
        String messageFormat = "Test for (" + this.roseName + ", " + this.sellIn + ", " + this.quality + ")" +
                " of %s, the actual value is %s, but excepted value is %s";

        assertThat(String.format(messageFormat, "name", name, exceptedRoseName),
                   name, is(exceptedRoseName));

        int sellIn = gildedRose.roseItems[0].getSellIn();
        assertThat(String.format(messageFormat, "sellIn", sellIn, exceptedSellIn),
                   sellIn, is(exceptedSellIn));

        int quality = gildedRose.roseItems[0].getQuality();
        assertThat(String.format(messageFormat, "quality", quality, exceptedQuality),
                   quality, is(exceptedQuality));
    }
}
