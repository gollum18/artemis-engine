package com.ae.items.consumables;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class PotionFactory {
    private static PotionFactory mInstance;
    private final HashMap<Integer, PotionFlyweight> mFlyweights;

    /**
     *
     * @param potionData
     */
    private PotionFactory(JSONArray potionData) {
        mFlyweights = new HashMap<>();
        for (Object object : potionData) {
            JSONObject potionDatum = (JSONObject) object;
            PotionFlyweight flyweight = new PotionFlyweight(potionDatum);
            mFlyweights.put(flyweight.getId(), flyweight);
        }
    }

    /**
     *
     * @return
     */
    public static PotionFactory getInstance() {
        if (mInstance == null) {
            JSONArray potionData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_POTIONS);
            mInstance = new PotionFactory(potionData);
        }
        return mInstance;
    }

    /**
     *
     * @param id
     * @return
     */
    public Potion buildPotion(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Potion. Invalid Potion ID specified."
            );
        }
        PotionFlyweight flyweight = mFlyweights.get(id);
        return new Potion(flyweight);
    }

    /**
     *
     */
    private static class PotionFlyweightIterator implements Iterator<PotionFlyweight> {
        private final List<PotionFlyweight> mList;
        int dIndex = 0;

        /**
         *
         * @param list
         */
        public PotionFlyweightIterator(List<PotionFlyweight> list) { mList = list; }

        /**
         *
         * @return
         */
        @Override public boolean hasNext() { return dIndex != mList.size(); }

        /**
         *
         * @return
         */
        @Override public PotionFlyweight next() { return mList.get(dIndex++); }
    }
}
