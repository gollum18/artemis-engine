package com.ae.actors.humans;

import com.ae.actors.ActorFlyweight;
import org.json.JSONObject;

public class HumanFlyweight extends ActorFlyweight {
    public HumanFlyweight(JSONObject humanData) {
        super(humanData);
    }
}
