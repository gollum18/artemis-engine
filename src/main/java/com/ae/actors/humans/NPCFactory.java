package com.ae.actors.humans;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class NPCFactory implements Factory {
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
            JSONArray npcData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_NPCS);
            mInstance = new NPCFactory(npcData);
        }
        return mInstance;
    }

    public NPCFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate NPC. Invalid NPC ID specified."
            );
        }
        return mFlyweights.get(id);
    }

    public NPC build(int id) {
        NPCFlyweight fw = getFlyweightById(id);
        return new NPC(fw);
    }

    public NPC build(int id, JSONObject stateData) {
        NPCFlyweight fw = getFlyweightById(id);
        return new NPC(fw, stateData);
    }
}
