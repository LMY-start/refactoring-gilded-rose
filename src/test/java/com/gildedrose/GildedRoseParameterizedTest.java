package com.gildedrose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
        List<Object> testData = new ArrayList<>();
        testData.addAll(prepareDexterityVestData());
        testData.addAll(prepareAgedBrieData());
        testData.addAll(prepareSulfurasHandOfRagnarosData());
        testData.addAll(prepareElixirOfTheMongooseData());
        testData.addAll(prepareBackstagePassesToATafkal80etcConcertData());
        testData.addAll(prepareOtherData());
        return testData;
    }

    private static Collection<Object> prepareDexterityVestData() {
        String dexterityVestRoseName = "+5 Dexterity Vest";
        return Arrays.asList(new Object[][]{
                {dexterityVestRoseName, 10, 20, dexterityVestRoseName, 9, 19},
                {dexterityVestRoseName, 1, 1, dexterityVestRoseName, 0, 0},
                {dexterityVestRoseName, 1, 0, dexterityVestRoseName, 0, 0},
                {dexterityVestRoseName, 0, 0, dexterityVestRoseName, -1, 0},
                {dexterityVestRoseName, 0, 2, dexterityVestRoseName, -1, 0},
                {dexterityVestRoseName, 0, 5, dexterityVestRoseName, -1, 3},
                {dexterityVestRoseName, -1, -1, dexterityVestRoseName, -2, -1}
        });
    }

    private static Collection<Object> prepareAgedBrieData() {
        String agedBrieRoseName = "Aged Brie";
        return Arrays.asList(new Object[][]{
                {agedBrieRoseName, 2, 0, agedBrieRoseName, 1, 1},
                {agedBrieRoseName, 1, 1, agedBrieRoseName, 0, 2},
                {agedBrieRoseName, 0, 0, agedBrieRoseName, -1, 2},
                {agedBrieRoseName, 0, 2, agedBrieRoseName, -1, 4},
                {agedBrieRoseName, 3, 50, agedBrieRoseName, 2, 50},
                {agedBrieRoseName, 3, 49, agedBrieRoseName, 2, 50},
                {agedBrieRoseName, 3, 48, agedBrieRoseName, 2, 49},
                {agedBrieRoseName, -1, 0, agedBrieRoseName, -2, 2},
                {agedBrieRoseName, -1, -1, agedBrieRoseName, -2, 1},
                {agedBrieRoseName, 0, 51, agedBrieRoseName, -1, 51}
        });
    }

    private static Collection<Object> prepareElixirOfTheMongooseData() {
        String elixirOfTheMongooseRoseName = "Elixir of the Mongoose";
        return Arrays.asList(new Object[][]{
                {elixirOfTheMongooseRoseName, 5, 9, elixirOfTheMongooseRoseName, 4, 8},
                {elixirOfTheMongooseRoseName, 1, 1, elixirOfTheMongooseRoseName, 0, 0},
                {elixirOfTheMongooseRoseName, 1, 0, elixirOfTheMongooseRoseName, 0, 0},
                {elixirOfTheMongooseRoseName, 0, 0, elixirOfTheMongooseRoseName, -1, 0},
                {elixirOfTheMongooseRoseName, 0, 2, elixirOfTheMongooseRoseName, -1, 0},
                {elixirOfTheMongooseRoseName, -1, -1, elixirOfTheMongooseRoseName, -2, -1}
        });
    }

    private static Collection<Object> prepareSulfurasHandOfRagnarosData() {
        String sulfurasHandOfRagnarosRoseName = "Sulfuras, Hand of Ragnaros";
        return Arrays.asList(new Object[][]{
                {sulfurasHandOfRagnarosRoseName, 0, 80, sulfurasHandOfRagnarosRoseName, 0, 80},
                {sulfurasHandOfRagnarosRoseName, -1, 80, sulfurasHandOfRagnarosRoseName, -1, 80},
                {sulfurasHandOfRagnarosRoseName, 2, 30, sulfurasHandOfRagnarosRoseName, 2, 30},
                {sulfurasHandOfRagnarosRoseName, 10, 3, sulfurasHandOfRagnarosRoseName, 10, 3},
                {sulfurasHandOfRagnarosRoseName, -1, -1, sulfurasHandOfRagnarosRoseName, -1, -1}
        });
    }

    private static Collection<Object> prepareBackstagePassesToATafkal80etcConcertData() {
        String backstagePassesToATafkal80etcConcertRoseName = "Backstage passes to a TAFKAL80ETC concert";
        return Arrays.asList(new Object[][]{
                {backstagePassesToATafkal80etcConcertRoseName, 15, 20, backstagePassesToATafkal80etcConcertRoseName, 14, 21},
                {backstagePassesToATafkal80etcConcertRoseName, 15, 49, backstagePassesToATafkal80etcConcertRoseName, 14, 50},
                {backstagePassesToATafkal80etcConcertRoseName, 15, 50, backstagePassesToATafkal80etcConcertRoseName, 14, 50},
                {backstagePassesToATafkal80etcConcertRoseName, 6, 20, backstagePassesToATafkal80etcConcertRoseName, 5, 22},
                {backstagePassesToATafkal80etcConcertRoseName, 6, 49, backstagePassesToATafkal80etcConcertRoseName, 5, 50},
                {backstagePassesToATafkal80etcConcertRoseName, 6, 50, backstagePassesToATafkal80etcConcertRoseName, 5, 50},
                {backstagePassesToATafkal80etcConcertRoseName, 5, 20, backstagePassesToATafkal80etcConcertRoseName, 4, 23},
                {backstagePassesToATafkal80etcConcertRoseName, 5, 49, backstagePassesToATafkal80etcConcertRoseName, 4, 50},
                {backstagePassesToATafkal80etcConcertRoseName, 5, 50, backstagePassesToATafkal80etcConcertRoseName, 4, 50},
                {backstagePassesToATafkal80etcConcertRoseName, 1, 20, backstagePassesToATafkal80etcConcertRoseName, 0, 23},
                {backstagePassesToATafkal80etcConcertRoseName, 0, 20, backstagePassesToATafkal80etcConcertRoseName, -1, 0},
                {backstagePassesToATafkal80etcConcertRoseName, 0, 50, backstagePassesToATafkal80etcConcertRoseName, -1, 0},
                {backstagePassesToATafkal80etcConcertRoseName, -1, 0, backstagePassesToATafkal80etcConcertRoseName, -2, 0},
                {backstagePassesToATafkal80etcConcertRoseName, -1, -1, backstagePassesToATafkal80etcConcertRoseName, -2, 0}
        });
    }

    private static Collection<Object> prepareOtherData() {
        String roseName = "foo";
        return Arrays.asList(new Object[][]{
                {roseName, 1, 2, roseName, 0, 1},
                {roseName, 0, 2, roseName, -1, 0},
                {roseName, 0, 5, roseName, -1, 3},
                {roseName, -1, -1, roseName, -2, -1}
        });
    }


    @Test
    public void should_return_right_sell_and_quality_when_update_quality_given_the_rose_item() {
        GildedRose gildedRose = new GildedRose(new RoseItem[]{new RoseItem(roseName, sellIn, quality)});

        gildedRose.updateQuality();

        RoseItem roseItem = gildedRose.roseItems[0];
        System.out.println(roseItem);
        String name = roseItem.getName();
        String messageFormat = "Test for (" + this.roseName + ", " + this.sellIn + ", " + this.quality + ")" +
                " of %s, the actual value is %s, but excepted value is %s";

        assertThat(String.format(messageFormat, "name", name, exceptedRoseName),
                   name, is(exceptedRoseName));

        int sellIn = roseItem.getSellIn();
        assertThat(String.format(messageFormat, "sellIn", sellIn, exceptedSellIn),
                   sellIn, is(exceptedSellIn));

        int quality = roseItem.getQuality();
        assertThat(String.format(messageFormat, "quality", quality, exceptedQuality),
                   quality, is(exceptedQuality));
    }
}
