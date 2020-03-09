package com.gildedrose;

public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    protected void updateQualityIFExpired() {
    }

    @Override
    protected void updateSellIn() {
    }

    @Override
    protected void updateQuality() {
    }
}
