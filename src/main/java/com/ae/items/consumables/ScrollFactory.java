package com.ae.items.consumables;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ScrollFactory {
    private static ScrollFactory mInstance;
    private final HashMap<Integer, ScrollFlyweight> mFlyweights;

    /**
     *
     * @param scrollData
     */
    private ScrollFactory(JSONArray scrollData) {
        mFlyweights = new HashMap<>();
        for (Object object : scrollData) {
            JSONObject scrollDatum = (JSONObject) object;
            ScrollFlyweight flyweight = new ScrollFlyweight(scrollDatum);
            mFlyweights.put(flyweight.getId(), flyweight);
        }
    }

    /**
     *
     * @return
     */
    public static ScrollFactory getInstance() {
        if (mInstance == null) {
            JSONArray scrollData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_SCROLLS);
            mInstance = new ScrollFactory(scrollData);
        }
        return mInstance;
    }

    /**
     *
     * @param id
     * @return
     */
    public Scroll buildScroll(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Scroll. Invalid Scroll ID specified."
            );
        }
        ScrollFlyweight flyweight = mFlyweights.get(id);
        return new Scroll(flyweight);
    }

    /**
     *
     */
    private static class ScrollFlyweightIterator implements Iterator<ScrollFlyweight> {
        private final List<ScrollFlyweight> mList;
        int dIndex = 0;

        /**
         *
         * @param list
         */
        public ScrollFlyweightIterator(List<ScrollFlyweight> list) { mList = list; }

        /**
         *
         * @return
         */
        @Override public boolean hasNext() { return dIndex != mList.size(); }

        /**
         *
         * @return
         */
        @Override public ScrollFlyweight next() { return mList.get(dIndex++); }
    }
}
