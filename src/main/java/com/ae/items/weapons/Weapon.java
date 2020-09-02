package com.ae.items.weapons;

import com.ae.items.Wearable;
import org.json.JSONObject;

public class Weapon extends Wearable {
    public Weapon(WeaponFlyweight fw) {
        super(fw);
    }

    public Weapon(WeaponFlyweight fw, JSONObject stateData) {
        super(fw, stateData);
    }
}
