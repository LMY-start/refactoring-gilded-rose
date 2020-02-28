package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        RoseItem[] items = new RoseItem[] {
                new RoseItem("+5 Dexterity Vest", 10, 20), //
                new RoseItem("Aged Brie", 2, 0), //
                new RoseItem("Elixir of the Mongoose", 5, 7), //
                new RoseItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                new RoseItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new RoseItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new RoseItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new RoseItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new RoseItem("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                new RoseItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 3;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (RoseItem item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
