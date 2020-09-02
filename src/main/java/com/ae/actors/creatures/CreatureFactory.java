package com.ae.actors.creatures;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class CreatureFactory implements Factory {
    private static CreatureFactory mInstance;
    private final HashMap<Integer, CreatureFlyweight> mFlyweights;

    private CreatureFactory(JSONArray creatureData) {
        mFlyweights = new HashMap<>();
        for (Object object : creatureData) {
            JSONObject creatureDatum = (JSONObject) object;
            CreatureFlyweight flyweight = new CreatureFlyweight(creatureDatum);
            mFlyweights.put(flyweight.dId, flyweight);
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

    public CreatureFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Creature. Invalid Creature ID specified!"
            );
        }
        return mFlyweights.get(id);
    }

    public Creature build(int id) {
        CreatureFlyweight fw = getFlyweightById(id);
        return new Creature(fw);
    }

    public Creature build(int id, JSONObject stateData) {
        CreatureFlyweight fw = getFlyweightById(id);
        return new Creature(fw, stateData);
    }
}
