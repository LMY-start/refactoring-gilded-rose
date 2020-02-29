package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    RoseItem[] roseItems;

    public GildedRose(RoseItem[] roseItems) {
        this.roseItems = roseItems;
    }

    public void updateQuality() {
        Arrays.stream(roseItems).forEach(RoseItem::updateSellInAndQuality);
    }
}
