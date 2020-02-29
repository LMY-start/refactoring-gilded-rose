package com.gildedrose;

class GildedRose {
    RoseItem[] roseItems;

    public GildedRose(RoseItem[] roseItems) {
        this.roseItems = roseItems;
    }

    public void updateQuality() {
        for (int i = 0; i < roseItems.length; i++) {
            roseItems[i].updateSellInAndQuality();
        }
    }
}
