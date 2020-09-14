package com.ae.items.consumables;

import com.ae.items.armor.Armor;
import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class PotionFactory implements Factory<PotionFlyweight, Potion> {
    private static PotionFactory mInstance;
    private final HashMap<Integer, PotionFlyweight> mFlyweights;

    private PotionFactory(JSONArray potionData) {
        mFlyweights = new HashMap<>();
        for (Object object : potionData) {
            JSONObject potionDatum = (JSONObject) object;
            PotionFlyweight flyweight = new PotionFlyweight(potionDatum);
            mFlyweights.put(flyweight.dId, flyweight);
        }
    }

    public static PotionFactory getInstance() {
        if (mInstance == null) {
            JSONArray potionData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_POTIONS);
            mInstance = new PotionFactory(potionData);
        }
        return mInstance;
    }

    public PotionFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Potion. Invalid Potion ID specified."
            );
        }
        return mFlyweights.get(id);
    }

    public Potion build(int id) {
        PotionFlyweight fw = getFlyweightById(id);
        return new Potion(fw);
    }

    public Potion build(int id, int gs) {
        // TODO: Implement me
        return null;
    }

    public Potion build(int id, JSONObject stateData) {
        PotionFlyweight fw = getFlyweightById(id);
        return new Potion(fw, stateData);
    }
}
