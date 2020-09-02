package com.ae.items.consumables;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

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
            mFlyweights.put(flyweight.dId, flyweight);
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
}
