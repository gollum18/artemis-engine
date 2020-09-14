package com.ae.actors;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class NPCFactory implements Factory<NPCFlyweight, NPC> {
    private static NPCFactory mInstance;
    private final HashMap<Integer, NPCFlyweight> mFlyweights;

    private NPCFactory(JSONArray npcData) {
        mFlyweights = new HashMap<>();
        for (Object object : npcData) {
            JSONObject npcDatum = (JSONObject) object;
            NPCFlyweight flyweight = new NPCFlyweight(npcDatum);
            mFlyweights.put(flyweight.dId, flyweight);
        }
    }

    public static NPCFactory getInstance() {
        if (mInstance == null) {
            JSONArray npcData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_CHARACTERS);
            mInstance = new NPCFactory(npcData);
        }
        return mInstance;
    }

    @Override
    public NPCFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                ""
            );
        }
        return mFlyweights.get(id);
    }

    @Override
    public NPC build(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                ""
            );
        }
        NPCFlyweight flyweight = mFlyweights.get(id);
        return new NPC(flyweight);
    }

    public NPC build(int id, int gs) {
        // TODO: Implement me
        return null;
    }

    @Override
    public NPC build(int id, JSONObject save) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                ""
            );
        }
        NPCFlyweight flyweight = mFlyweights.get(id);
        return new NPC(flyweight, save);
    }
}
