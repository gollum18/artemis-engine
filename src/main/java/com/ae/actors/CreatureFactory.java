package com.ae.actors;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class CreatureFactory implements Factory<CreatureFlyweight, Creature> {
    private static CreatureFactory mInstance;
    private final HashMap<Integer, CreatureFlyweight> mBaseFlyweights;

    private CreatureFactory(JSONArray creatureData) {
        mBaseFlyweights = new HashMap<>();
        for (Object object : creatureData) {
            JSONObject creatureDatum = (JSONObject) object;
            CreatureFlyweight flyweight = new CreatureFlyweight(creatureDatum);
            mBaseFlyweights.put(flyweight.dId, flyweight);
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
        if (!mBaseFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                ""
            );
        }
        return mBaseFlyweights.get(id);
    }

    @Override
    public Creature build(int id) {
        if (!mBaseFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                ""
            );
        }
        CreatureFlyweight flyweight = mBaseFlyweights.get(id);
        return new Creature(flyweight);
    }

    @Override
    public Creature build(int id, int gs) {
        // TODO: Implement me
        return null;
    }

    @Override
    public Creature build(int id, JSONObject save) {
        // TODO: Implement me
        return null;
    }
}
