package com.ae.actors.humans;

import org.json.JSONObject;

public class Player extends Human {
    public Player(PlayerFlyweight fw) { super(fw); }

    public Player(PlayerFlyweight fw, JSONObject stateData) {
        super(fw);
    }
}
