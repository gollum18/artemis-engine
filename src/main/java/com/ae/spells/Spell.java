package com.ae.spells;

import com.ae.util.Entity;
import org.json.JSONObject;

public class Spell extends Entity {
    public Spell(SpellFlyweight fw) { super(fw); }

    public Spell(SpellFlyweight fw, JSONObject stateData) {
        super(fw, stateData);
    }

    public SpellFlyweight getFlyweight() { return (SpellFlyweight) super.getFlyweight(); }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================================\n");
        sb.append(mFlyweight).append("\n");
        sb.append("=================================================\n");
        return sb.toString();
    }
}
