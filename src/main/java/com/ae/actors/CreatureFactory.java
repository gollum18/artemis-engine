package com.ae.actors;

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

    public CreatureFactory getInstance() {
        if (mInstance == null) {
            JSONArray creatureData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_CREATURES);
            mInstance = new CreatureFactory(creatureData);
        }
        return mInstance;
    }

    @Override
    public CreatureFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                ""
            );
        }
        return mFlyweights.get(id);
    }

    @Override
    public Creature build(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                ""
            );
        }
        CreatureFlyweight flyweight = mFlyweights.get(id);
        return new Creature(flyweight);
    }

    @Override
    public Creature build(int id, JSONObject save) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                ""
            );
        }
        CreatureFlyweight flyweight = mFlyweights.get(id);
        return new Creature(flyweight, save);
    }
}
