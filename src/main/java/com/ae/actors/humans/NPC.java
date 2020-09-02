package com.ae.actors.humans;

import org.json.JSONObject;

public class NPC extends Human {
    public NPC(NPCFlyweight fw) { super(fw); }

    public NPC(NPCFlyweight fw, JSONObject stateData) {
        super(fw);
    }
}
