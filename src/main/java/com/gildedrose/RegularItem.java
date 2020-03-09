package com.gildedrose;

public class RegularItem extends Item {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQualityIFExpired() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    @Override
    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }

    @Override
    protected void updateQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }
}
