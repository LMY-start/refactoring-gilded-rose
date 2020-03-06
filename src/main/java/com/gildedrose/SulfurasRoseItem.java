package com.gildedrose;

public class SulfurasRoseItem extends RoseItem {

    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public SulfurasRoseItem(int sellIn, int quality) {
        super(SULFURAS_HAND_OF_RAGNAROS, sellIn, quality);
    }

    @Override
    protected void updateSellIn() {
    }

    @Override
    protected void updateQuality() {
    }
}