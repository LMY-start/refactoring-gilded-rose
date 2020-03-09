package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQualityIfLessFifty();
    }


    @Override
    protected void updateSellIn() {
        sellIn = decreaseSellIn();
    }

    @Override
    protected void updateQualityIFExpired() {
        increaseQualityIfLessFifty();
    }
}
