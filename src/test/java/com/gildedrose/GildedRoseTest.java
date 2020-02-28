package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        RoseItem[] items = new RoseItem[] { new RoseItem("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.roseItems[0].name);
        assertThat(app.roseItems[0].quality, is(4));
        assertThat(app.roseItems[0].sellIn, is(0));
    }

}
