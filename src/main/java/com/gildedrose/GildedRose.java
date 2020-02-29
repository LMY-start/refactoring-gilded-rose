package com.gildedrose;

class GildedRose {
    RoseItem[] roseItems;

    public GildedRose(RoseItem[] roseItems) {
        this.roseItems = roseItems;
    }

    public void updateQuality() {
        for (int i = 0; i < roseItems.length; i++) {
            processQuality(roseItems[i]);
            processSellIn(roseItems[i]);
            processSellInLessZero(roseItems[i]);
        }
    }

    private void processQuality(RoseItem roseItem) {
        roseItem.processQuality();
    }

    private void processSellIn(RoseItem roseItem) {
        roseItem.processSellIn();
    }

    private void processSellInLessZero(RoseItem roseItem) {
        roseItem.processSellInLessZero();
    }
}
