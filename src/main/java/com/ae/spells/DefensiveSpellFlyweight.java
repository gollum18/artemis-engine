package com.ae.spells;

import com.ae.resources.ResourceDataKeys;
import org.json.JSONObject;

public class DefensiveSpellFlyweight extends SpellFlyweight {
    public final int dDefense;
    public final int dMagicResist;
    public final int dFireResist;
    public final int dNecroResist;
    public final int dHealAmt;

    public DefensiveSpellFlyweight(JSONObject dsfwData) {
        super(dsfwData);
        dDefense = dsfwData.getInt(ResourceDataKeys.KEY_DEFENSE);
        dMagicResist = dsfwData.getInt(ResourceDataKeys.KEY_MAGIC_RESIST);
        dFireResist = dsfwData.getInt(ResourceDataKeys.KEY_FIRE_RESIST);
        dNecroResist = dsfwData.getInt(ResourceDataKeys.KEY_NECRO_RESIST);
        dHealAmt = dsfwData.getInt(ResourceDataKeys.KEY_HEAL_AMOUNT);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Defense Buff: ").append(dDefense).append("\n");
        sb.append("Magic Resist Buff: ").append(dMagicResist).append("\n");
        sb.append("Fire Resist Buff: ").append(dFireResist).append("\n");
        sb.append("Necro Resist Buff: ").append(dNecroResist).append("\n");
        sb.append("Heal Amount: ").append(dHealAmt).append("\n");
        return sb.toString();
    }
}
