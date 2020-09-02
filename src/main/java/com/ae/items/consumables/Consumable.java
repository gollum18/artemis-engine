package com.ae.items.consumables;

import com.ae.items.Item;
import org.json.JSONObject;

public abstract class Consumable extends Item {
    public Consumable(ConsumableFlyweight fw) { super(fw); }

    public Consumable(ConsumableFlyweight fw, JSONObject stateData) { super(fw, stateData); }
}
