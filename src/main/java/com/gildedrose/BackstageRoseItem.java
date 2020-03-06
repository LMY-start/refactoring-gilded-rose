package com.gildedrose;

import lombok.Getter;

public class BackstageRoseItem extends RoseItem {

    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public BackstageRoseItem(int sellIn, int quality) {
        super(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50)
            quality++;
        if (quality < 50 && sellIn < 10)
            quality++;
        if (quality < 50 && sellIn < 5)
            quality++;
        if (sellIn < 0)
            quality = 0;
    }
}