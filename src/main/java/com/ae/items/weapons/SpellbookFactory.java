package com.ae.items.weapons;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 *
 */
public class SpellbookFactory {

    private static SpellbookFactory mInstance;
    private final HashMap<Integer, SpellbookFlyweight> mFlyweights;

    /**
     *
     * @param spellbookData
     */
    private SpellbookFactory(JSONArray spellbookData) {
        mFlyweights = new HashMap<>();
        for (Object object : spellbookData) {
            JSONObject spellbookDatum = (JSONObject) object;
            SpellbookFlyweight flyweight = new SpellbookFlyweight(spellbookDatum);
            mFlyweights.put(flyweight.dId, flyweight);
        }
    }

    /**
     *
     * @return
     */
    public static SpellbookFactory getInstance() {
        if (mInstance == null) {
            JSONArray spellbookData = (JSONArray)ResourceLoader.loadResource(ResourceType.ST_SPELLBOOKS);
            mInstance = new SpellbookFactory(spellbookData);
        }
        return mInstance;
    }

    /**
     *
     * @param id
     * @return
     */
    public Spellbook buildSpellbook(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Spellbook. Invalid Spellbook ID specified."
            );
        }
        SpellbookFlyweight flyweight = mFlyweights.get(id);
        return new Spellbook(flyweight);
    }
}
