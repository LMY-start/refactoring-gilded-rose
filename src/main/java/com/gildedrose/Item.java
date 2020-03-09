package com.gildedrose;

abstract class Item {

    protected String name;

    protected int sellIn;

    protected int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void update() {
        updateQuality();

        updateSellIn();

        if (isExpired()) {
            updateQualityIFExpired();
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    abstract void updateQualityIFExpired();

    abstract void updateSellIn();

    abstract void updateQuality();

    protected int decreaseSellIn() {
        return sellIn - 1;
    }

    protected void increaseQualityIfLessFifty() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}

