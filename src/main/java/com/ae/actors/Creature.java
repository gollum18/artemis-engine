package com.ae.actors;

import org.json.JSONObject;

public class Creature extends Actor {
    public Creature(CreatureFlyweight fw) { super(fw); }

    public Creature(CreatureFlyweight fw, JSONObject stateData) { super(fw, stateData); }
}
