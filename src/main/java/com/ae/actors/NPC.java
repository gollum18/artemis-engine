package com.ae.actors;

import org.json.JSONObject;

public class NPC extends Actor {
    public NPC(NPCFlyweight flyweight) {
        super(flyweight);
    }

    public NPC(NPCFlyweight flyweight, JSONObject save) {
        super(flyweight, save);
    }
}
