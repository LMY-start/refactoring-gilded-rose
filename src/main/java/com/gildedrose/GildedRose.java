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
        if (!roseItem.getName().equals("Aged Brie")
                && !roseItem.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (roseItem.getQuality() > 0) {
                if (!roseItem.getName().equals("Sulfuras, Hand of Ragnaros")) {
                    roseItem.decreaseQuality();
                }
            }
        } else {
            if (roseItem.getQuality() < 50) {
                roseItem.increaseQuality();

                if (roseItem.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (roseItem.getSellIn() < 11) {
                        if (roseItem.getQuality() < 50) {
                            roseItem.increaseQuality();
                        }
                    }

                    if (roseItem.getSellIn() < 6) {
                        if (roseItem.getQuality() < 50) {
                            roseItem.increaseQuality();
                        }
                    }
                }
            }
        }
    }

    private void processSellIn(RoseItem roseItem) {
        if (!roseItem.getName().equals("Sulfuras, Hand of Ragnaros")) {
            roseItem.decreaseSellIn();
        }
    }

    private void processSellInLessZero(RoseItem roseItem) {
        if (roseItem.getSellIn() < 0) {
            if (!roseItem.getName().equals("Aged Brie")) {
                if (!roseItem.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (roseItem.getQuality() > 0) {
                        if (!roseItem.getName().equals("Sulfuras, Hand of Ragnaros")) {
                            roseItem.decreaseQuality();
                        }
                    }
                } else {
                    roseItem.resetQuality2Zero();
                }
            } else {
                if (roseItem.getQuality() < 50) {
                    roseItem.increaseQuality();
                }
            }
        }
    }
}
