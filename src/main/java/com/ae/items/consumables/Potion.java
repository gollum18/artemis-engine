package com.ae.items.consumables;

import org.json.JSONObject;

public class Potion extends Consumable {
    public Potion(PotionFlyweight fw) {
        super(fw);
    }

    public Potion(PotionFlyweight fw, JSONObject stateData) { super(fw, stateData); }
}
