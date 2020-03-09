package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @ParameterizedTest
    @MethodSource({"provideAgedBries"})
    void should_update_item_correctly_of_aged_bries(TestFixture testFixture) {
        testForUpdateItems(testFixture);
    }

    @ParameterizedTest
    @MethodSource({"provideBackstagePass"})
    void should_update_item_correctly_backstage_pass(TestFixture testFixture) {
        testForUpdateItems(testFixture);
    }

    @ParameterizedTest
    @MethodSource({"provideSulfuras"})
    void should_update_item_correctly_of_sulfuras(TestFixture testFixture) {
        testForUpdateItems(testFixture);
    }

    @ParameterizedTest
    @MethodSource({"provideRegularItems"})
    void should_update_item_correctly_of_regular_items(TestFixture testFixture) {
        testForUpdateItems(testFixture);
    }

    private void testForUpdateItems(TestFixture testFixture) {
        Item item = createItem(testFixture.name, testFixture.sellIn, testFixture.quality);

        new GildedRose(new Item[]{item}).update_quality();

        Item expectedItem = createItem(testFixture.name, testFixture.updatedSellIn, testFixture.updatedQuality);
        assertEquals(expectedItem.toString(), item.toString());
    }


    private Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }


    private static Stream<TestFixture> provideRegularItems() {
        return Stream.of(
                TestFixture.createRegular("+5 Dexterity Vest", 10, 20, 9, 19),
                TestFixture.createRegular("+5 Dexterity Vest", 1, 1, 0, 0),
                TestFixture.createRegular("+5 Dexterity Vest", 1, 0, 0, 0),
                TestFixture.createRegular("+5 Dexterity Vest", 0, 0, -1, 0),
                TestFixture.createRegular("+5 Dexterity Vest", 0, 2, -1, 0),
                TestFixture.createRegular("+5 Dexterity Vest", 0, 5, -1, 3),
                TestFixture.createRegular("+5 Dexterity Vest", -1, -1, -2, -1),

                TestFixture.createRegular("Elixir of the Mongoose", 5, 9, 4, 8),
                TestFixture.createRegular("Elixir of the Mongoose", 1, 1, 0, 0),
                TestFixture.createRegular("Elixir of the Mongoose", 1, 0, 0, 0),
                TestFixture.createRegular("Elixir of the Mongoose", 0, 0, -1, 0),
                TestFixture.createRegular("Elixir of the Mongoose", 0, 2, -1, 0),
                TestFixture.createRegular("Elixir of the Mongoose", -1, -1, -2, -1),

                TestFixture.createRegular("foo", 1, 2, 0, 1),
                TestFixture.createRegular("foo", 0, 2, -1, 0),
                TestFixture.createRegular("foo", 0, 5, -1, 3),
                TestFixture.createRegular("foo", -1, -1, -2, -1)
        );
    }


    private static Stream<TestFixture> provideAgedBries() {
        return Stream.of(
                TestFixture.createAgedBrie(2, 0, 1, 1),
                TestFixture.createAgedBrie(1, 1, 0, 2),
                TestFixture.createAgedBrie(0, 0, -1, 2),
                TestFixture.createAgedBrie(0, 2, -1, 4),
                TestFixture.createAgedBrie(3, 50, 2, 50),
                TestFixture.createAgedBrie(3, 49, 2, 50),
                TestFixture.createAgedBrie(3, 48, 2, 49),
                TestFixture.createAgedBrie(-1, 0, -2, 2),
                TestFixture.createAgedBrie(-1, -1, -2, 1)
        );
    }


    private static Stream<TestFixture> provideSulfuras() {
        return Stream.of(
                TestFixture.createSulfuras(0, 80, 0, 80),
                TestFixture.createSulfuras(-1, 80, -1, 80),
                TestFixture.createSulfuras(2, 30, 2, 30),
                TestFixture.createSulfuras(10, 3, 10, 3),
                TestFixture.createSulfuras(-1, -1, -1, -1)
        );
    }

    private static Stream<TestFixture> provideBackstagePass() {
        return Stream.of(
                TestFixture.createBackstagePass(15, 20, 14, 21),
                TestFixture.createBackstagePass(15, 49, 14, 50),
                TestFixture.createBackstagePass(15, 50, 14, 50),
                TestFixture.createBackstagePass(6, 20, 5, 22),
                TestFixture.createBackstagePass(6, 49, 5, 50),
                TestFixture.createBackstagePass(6, 50, 5, 50),
                TestFixture.createBackstagePass(5, 20, 4, 23),
                TestFixture.createBackstagePass(5, 49, 4, 50),
                TestFixture.createBackstagePass(5, 50, 4, 50),
                TestFixture.createBackstagePass(1, 20, 0, 23),
                TestFixture.createBackstagePass(0, 20, -1, 0),
                TestFixture.createBackstagePass(0, 50, -1, 0),
                TestFixture.createBackstagePass(-1, 0, -2, 0),
                TestFixture.createBackstagePass(-1, -1, -2, 0)
        );
    }


    private static class TestFixture {
        String name;
        int sellIn;
        int quality;
        int updatedSellIn;
        int updatedQuality;

        private TestFixture(String name, int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
            this.updatedSellIn = updatedSellIn;
            this.updatedQuality = updatedQuality;
        }

        public static TestFixture createRegular(String name, int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new TestFixture(name, sellIn, quality, updatedSellIn, updatedQuality);
        }

        public static TestFixture createAgedBrie(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new TestFixture("Aged Brie", sellIn, quality, updatedSellIn, updatedQuality);
        }

        public static TestFixture createSulfuras(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new TestFixture("Sulfuras, Hand of Ragnaros", sellIn, quality, updatedSellIn, updatedQuality);
        }

        public static TestFixture createBackstagePass(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
            return new TestFixture("Backstage passes to a TAFKAL80ETC concert", sellIn, quality, updatedSellIn, updatedQuality);
        }
    }
}
