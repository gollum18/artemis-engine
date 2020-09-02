package com.ae.spells;

public class Spell {
    public final SpellFlyweight mFlyweight;

    public Spell(SpellFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================================\n");
        sb.append(mFlyweight).append("\n");
        sb.append("=================================================\n");
        return sb.toString();
    }
}
