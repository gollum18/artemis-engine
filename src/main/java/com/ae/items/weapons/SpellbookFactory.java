package com.ae.items.weapons;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.spells.SpellFlyweight;
import com.ae.util.Factory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class SpellbookFactory implements Factory {

    private static SpellbookFactory mInstance;
    private final HashMap<Integer, SpellbookFlyweight> mFlyweights;

    private SpellbookFactory(JSONArray spellbookData) {
        mFlyweights = new HashMap<>();
        for (Object object : spellbookData) {
            JSONObject spellbookDatum = (JSONObject) object;
            SpellbookFlyweight flyweight = new SpellbookFlyweight(spellbookDatum);
            mFlyweights.put(flyweight.dId, flyweight);
        }
    }

    public static SpellbookFactory getInstance() {
        if (mInstance == null) {
            JSONArray spellbookData = (JSONArray)ResourceLoader.loadResource(ResourceType.ST_SPELLBOOKS);
            mInstance = new SpellbookFactory(spellbookData);
        }
        return mInstance;
    }

    public SpellbookFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Spellbook. Invalid Spellbook ID specified."
            );
        }
        return mFlyweights.get(id);
    }

    public Spellbook build(int id) {
        SpellbookFlyweight fw = getFlyweightById(id);
        return new Spellbook(fw);
    }

    public Spellbook build(int id, JSONObject stateData) {
        SpellbookFlyweight fw = getFlyweightById(id);
        return new Spellbook(fw, stateData);
    }
}
