package com.gildedrose;

class GildedRose {
    RoseItem[] roseItems;

    public GildedRose(RoseItem[] roseItems) {
        this.roseItems = roseItems;
    }

    public void updateQuality() {
        for (int i = 0; i < roseItems.length; i++) {
            if (!roseItems[i].name.equals("Aged Brie")
                    && !roseItems[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (roseItems[i].quality > 0) {
                    if (!roseItems[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        roseItems[i].quality = roseItems[i].quality - 1;
                    }
                }
            } else {
                if (roseItems[i].quality < 50) {
                    roseItems[i].quality = roseItems[i].quality + 1;

                    if (roseItems[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (roseItems[i].sellIn < 11) {
                            if (roseItems[i].quality < 50) {
                                roseItems[i].quality = roseItems[i].quality + 1;
                            }
                        }

                        if (roseItems[i].sellIn < 6) {
                            if (roseItems[i].quality < 50) {
                                roseItems[i].quality = roseItems[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!roseItems[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                roseItems[i].sellIn = roseItems[i].sellIn - 1;
            }

            if (roseItems[i].sellIn < 0) {
                if (!roseItems[i].name.equals("Aged Brie")) {
                    if (!roseItems[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (roseItems[i].quality > 0) {
                            if (!roseItems[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                roseItems[i].quality = roseItems[i].quality - 1;
                            }
                        }
                    } else {
                        roseItems[i].quality = roseItems[i].quality - roseItems[i].quality;
                    }
                } else {
                    if (roseItems[i].quality < 50) {
                        roseItems[i].quality = roseItems[i].quality + 1;
                    }
                }
            }
        }
    }
}
