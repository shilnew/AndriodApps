package com.example.shilpa.masterdetails.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Fort Collins", "http://www.accuweather.com/en/us/fort-collins-co/80521/weather-forecast/327348"));
        addItem(new DummyItem("2", "Bangalore", "http://www.accuweather.com/en/in/bangalore/204108/weather-forecast/204108"));
        addItem(new DummyItem("3", "Chennai", "http://www.accuweather.com/en/in/chennai/206671/weather-forecast/206671"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String city;
        public String url;

        public DummyItem(String id, String city, String url) {
            this.id = id;
            this.city = city;
            this.url = url;
        }

        @Override
        public String toString() {
            return city;
        }
    }
}
