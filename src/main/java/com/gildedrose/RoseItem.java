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

    public void decreaseSellIn() {
        sellIn -= 1;
    }

    public void increaseQuality() {
        quality += 1;
    }

    public void decreaseQuality() {
        quality -= 1;
    }

    public void resetQuality2Zero() {
        quality = 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}