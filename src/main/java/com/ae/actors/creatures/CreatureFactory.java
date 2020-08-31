package com.ae.actors.creatures;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class CreatureFactory {
    private static CreatureFactory mInstance;
    private final HashMap<Integer, CreatureFlyweight> mFlyweights;

    private CreatureFactory(JSONArray creatureData) {
        mFlyweights = new HashMap<>();
        for (Object object : creatureData) {
            JSONObject creatureDatum = (JSONObject) object;
            CreatureFlyweight flyweight = new CreatureFlyweight(creatureDatum);
            mFlyweights.put(flyweight.getId(), flyweight);
        }
    }

    public static CreatureFactory getInstance() {
        if (mInstance == null) {
           JSONArray creatureData =
                   (JSONArray) ResourceLoader.loadResource(ResourceType.ST_CREATURES);
           mInstance = new CreatureFactory(creatureData);
        }
        return mInstance;
    }

    public Creature buildCreature(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Creature. Invalid Creature ID specified!"
            );
        }
        CreatureFlyweight flyweight = mFlyweights.get(id);
        return new Creature(flyweight);
    }
}
