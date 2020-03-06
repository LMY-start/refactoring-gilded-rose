package com.gildedrose;

public class AgedBrieRoseItem extends RoseItem {

    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrieRoseItem(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50)
            quality++;
        if (quality < 50 && sellIn < 0)
            quality++;
    }
}