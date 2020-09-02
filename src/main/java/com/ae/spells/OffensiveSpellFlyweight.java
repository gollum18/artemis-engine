package com.ae.spells;

import com.ae.resources.ResourceDataKeys;
import org.json.JSONObject;

public class OffensiveSpellFlyweight extends SpellFlyweight {
    public final int dMagicDamage;
    public final int dFireDamage;
    public final int dNecroDamage;
    public final int dBleedBuildup;
    public final int dPoisonBuildup;
    public final int dStunBuildup;

    public OffensiveSpellFlyweight(JSONObject osfwData) {
        super(osfwData);
        dMagicDamage = osfwData.getInt(ResourceDataKeys.KEY_MAGIC_DAMAGE);
        dFireDamage = osfwData.getInt(ResourceDataKeys.KEY_FIRE_DAMAGE);
        dNecroDamage = osfwData.getInt(ResourceDataKeys.KEY_NECRO_DAMAGE);
        dBleedBuildup = osfwData.getInt(ResourceDataKeys.KEY_BLEED_BUILDUP);
        dPoisonBuildup = osfwData.getInt(ResourceDataKeys.KEY_POISON_BUILDUP);
        dStunBuildup = osfwData.getInt(ResourceDataKeys.KEY_STUN_BUILDUP);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Magic Damage: ").append(dMagicDamage).append("\n");
        sb.append("Fire Damage: ").append(dFireDamage).append("\n");
        sb.append("Necro Damage: ").append(dNecroDamage).append("\n");
        sb.append("Bleed Buildup: ").append(dBleedBuildup).append("\n");
        sb.append("Poison Buildup: ").append(dPoisonBuildup).append("\n");
        sb.append("Stun Buildup: ").append(dStunBuildup).append("\n");
        return sb.toString();
    }
}
