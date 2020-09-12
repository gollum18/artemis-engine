package com.ae.items.armor;

import com.ae.items.Wearable;
import org.json.JSONObject;

public class Armor extends Wearable {
    public Armor(ArmorFlyweight fw) {
        super(fw);
    }

    public Armor(ArmorFlyweight fw, JSONObject stateData) {
        super(fw, stateData);
    }

    public ArmorFlyweight getFlyweight() { return (ArmorFlyweight) mFlyweight; }
}
