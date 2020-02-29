package com.gildedrose;


import lombok.Getter;

@Getter
public class RoseItem {

    private String name;
    private int sellIn;
    private int quality;

    public RoseItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    private void decreaseSellIn() {
        sellIn -= 1;
    }

    private void increaseQuality() {
        quality += 1;
    }

    private void decreaseQuality() {
        quality -= 1;
    }

    private void resetQuality2Zero() {
        quality = 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void processQuality() {
        if (!name.equals("Aged Brie")
                && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (quality > 0) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    decreaseQuality();
                }
            }
        } else {
            if (quality < 50) {
                increaseQuality();

                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellIn < 11) {
                        if (quality < 50) {
                            increaseQuality();
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            increaseQuality();
                        }
                    }
                }
            }
        }
    }

    public void processSellIn() {
        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            decreaseSellIn();
        }
    }

    public void processSellInLessZero() {
        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            decreaseQuality();
                        }
                    }
                } else {
                    resetQuality2Zero();
                }
            } else {
                if (quality < 50) {
                    increaseQuality();
                }
            }
        }
    }
}