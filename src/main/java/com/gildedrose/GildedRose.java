package com.gildedrose;

class GildedRose {
    RoseItem[] roseItems;

    public GildedRose(RoseItem[] roseItems) {
        this.roseItems = roseItems;
    }

    public void updateQuality() {
        for (int i = 0; i < roseItems.length; i++) {
            if (!roseItems[i].getName().equals("Aged Brie")
                    && !roseItems[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (roseItems[i].getQuality() > 0) {
                    if (!roseItems[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                        roseItems[i].decreaseQuality();
                    }
                }
            } else {
                if (roseItems[i].getQuality() < 50) {
                    roseItems[i].increaseQuality();

                    if (roseItems[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (roseItems[i].getSellIn() < 11) {
                            if (roseItems[i].getQuality() < 50) {
                                roseItems[i].increaseQuality();
                            }
                        }

                        if (roseItems[i].getSellIn() < 6) {
                            if (roseItems[i].getQuality() < 50) {
                                roseItems[i].increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!roseItems[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                roseItems[i].decreaseSellIn();
            }

            if (roseItems[i].getSellIn() < 0) {
                if (!roseItems[i].getName().equals("Aged Brie")) {
                    if (!roseItems[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (roseItems[i].getQuality() > 0) {
                            if (!roseItems[i].getName().equals("Sulfuras, Hand of Ragnaros")) {
                                roseItems[i].decreaseQuality();
                            }
                        }
                    } else {
                        roseItems[i].resetQuality2Zero();
                    }
                } else {
                    if (roseItems[i].getQuality() < 50) {
                        roseItems[i].increaseQuality();
                    }
                }
            }
        }
    }
}
