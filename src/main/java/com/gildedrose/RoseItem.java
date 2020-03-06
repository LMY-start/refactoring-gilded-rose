package com.gildedrose;

import lombok.Getter;

@Getter
public class RoseItem {

    public String name;
    public int sellIn;
    public int quality;

    public RoseItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    protected void updateSellIn(){
        sellIn--;
    }

    protected void updateQuality(){
        if (quality > 0)
            quality--;
        if (quality > 0 && sellIn < 0)
            quality--;
    }

    public void updateSellInAndQuality() {
        updateSellIn();
        updateQuality();
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
