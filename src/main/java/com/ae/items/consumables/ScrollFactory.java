package com.ae.items.consumables;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class ScrollFactory implements Factory<ScrollFlyweight, Scroll> {
    private static ScrollFactory mInstance;
    private final HashMap<Integer, ScrollFlyweight> mFlyweights;

    private ScrollFactory(JSONArray scrollData) {
        mFlyweights = new HashMap<>();
        for (Object object : scrollData) {
            JSONObject scrollDatum = (JSONObject) object;
            ScrollFlyweight flyweight = new ScrollFlyweight(scrollDatum);
            mFlyweights.put(flyweight.dId, flyweight);
        }
    }

    public static ScrollFactory getInstance() {
        if (mInstance == null) {
            JSONArray scrollData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_SCROLLS);
            mInstance = new ScrollFactory(scrollData);
        }
        return mInstance;
    }

    public ScrollFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Scroll. Invalid Scroll ID specified."
            );
        }
        return mFlyweights.get(id);
    }

    public Scroll build(int id) {
        ScrollFlyweight fw = getFlyweightById(id);
        return new Scroll(fw);
    }

    public Scroll build(int id, int gs) {
        // TODO: Implement me
        return null;
    }

    public Scroll build(int id, JSONObject stateData) {
        ScrollFlyweight fw = getFlyweightById(id);
        return new Scroll(fw, stateData);
    }
}
