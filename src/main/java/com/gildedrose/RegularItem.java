package com.gildedrose;

public class RegularItem extends Item {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQualityIFExpired() {
        decreaseQuality();
    }

    @Override
    protected void updateSellIn() {
        sellIn = decreaseSellIn();
    }


    @Override
    protected void updateQuality() {
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }
}

