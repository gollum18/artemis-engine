package com.ae.actors.humans;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NPCFactory {
    private static NPCFactory mInstance;
    private final HashMap<Integer, NPCFlyweight> mFlyweights;

    private NPCFactory(JSONArray npcData) {
        mFlyweights = new HashMap<>();
        for (Object object : npcData) {
            JSONObject npcDatum = (JSONObject) object;
            NPCFlyweight flyweight = new NPCFlyweight(npcDatum);
            mFlyweights.put(flyweight.getId(), flyweight);
        }
    }

    public static NPCFactory getInstance() {
        if (mInstance == null) {
            JSONArray npcData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_NPCS);
            mInstance = new NPCFactory(npcData);
        }
        return mInstance;
    }

    public NPC buildNPC(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate NPC. Invalid NPC ID specified."
            );
        }
        NPCFlyweight flyweight = mFlyweights.get(id);
        return new NPC(flyweight);
    }

    public static class NPCFlyweightIterator<NPCFlyweight> implements Iterator<NPCFlyweight> {
        private final List<NPCFlyweight> mList;
        private int dIndex = 0;

        public NPCFlyweightIterator(List<NPCFlyweight> list) {
            mList = list;
        }

        @Override public boolean hasNext() { return dIndex == mList.size(); }

        @Override public NPCFlyweight next() { return mList.get(dIndex++); }
    }
}
