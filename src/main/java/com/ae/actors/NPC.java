package com.ae.actors;

import org.json.JSONObject;

public class NPC extends Actor {
    public NPC(NPCFlyweight fw) { super(fw); }

    public NPC(NPCFlyweight fw, JSONObject stateData) {
        super(fw, stateData);
    }
}
