package com.ae.items.weapons;

import com.ae.items.Wearable;
import org.json.JSONObject;

public class Spellbook extends Wearable {
    public Spellbook(SpellbookFlyweight fw) {
        super(fw);
    }

    public Spellbook(SpellbookFlyweight fw, JSONObject stateData) { super(fw, stateData); }
}
