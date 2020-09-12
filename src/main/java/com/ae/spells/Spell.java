package com.ae.spells;

import org.json.JSONObject;

public class Spell {
    protected final SpellFlyweight mFlyweight;

    public Spell(SpellFlyweight fw) {
        mFlyweight = fw;
    }

    public Spell(SpellFlyweight fw, JSONObject stateData) {
        mFlyweight = fw;
    }

    public SpellFlyweight getFlyweight() { return (SpellFlyweight) mFlyweight; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================================\n");
        sb.append(mFlyweight).append("\n");
        sb.append("=================================================\n");
        return sb.toString();
    }
}
