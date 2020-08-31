package com.ae.actors.humans;

import com.ae.util.Flyweight;
import org.json.JSONObject;

public class NPCFlyweight extends Flyweight {
    private final int dId;
    private final String sName;

    public NPCFlyweight(JSONObject npcData) {
        dId = npcData.getInt(NPCDataKeys.NPC_ID);
        sName = npcData.getString(NPCDataKeys.NPC_NAME);
    }

    public int getId() { return dId; }

    public String getName() { return sName; }
}
