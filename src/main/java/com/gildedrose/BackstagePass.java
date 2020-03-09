package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQualityIFExpired() {
        quality = 0;
    }

    @Override
    protected void updateSellIn() {
        sellIn = decreaseSellIn();
    }

    @Override
    protected void updateQuality() {
        increaseQualityIfLessFifty();
        if (sellIn < 11) {
            increaseQualityIfLessFifty();
        }
        if (sellIn < 6) {
            increaseQualityIfLessFifty();
        }
    }

}
