package com.ae.items;

import org.json.JSONObject;

public abstract class Wearable extends Item {
    public Wearable(WearableFlyweight fw) { super(fw); }

    public Wearable(WearableFlyweight fw, JSONObject stateData) { super(fw, stateData); }
}
