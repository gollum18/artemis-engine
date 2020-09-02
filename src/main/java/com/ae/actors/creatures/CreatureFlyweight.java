package com.ae.actors.creatures;

import com.ae.actors.ActorFlyweight;
import com.ae.resources.ResourceDataKeys;
import org.json.JSONObject;

public class CreatureFlyweight extends ActorFlyweight {
    public final int dDefense;
    public final int dBleedResist;
    public final int dPoisonResist;
    public final int dStunResist;
    public final double dMagicResist;
    public final double dFireResist;
    public final double dNecroResist;

    public CreatureFlyweight(JSONObject creatureData) {
        super(creatureData);
        dDefense = creatureData.getInt(ResourceDataKeys.KEY_DEFENSE);
        dBleedResist = creatureData.getInt(ResourceDataKeys.KEY_BLEED_RESIST);
        dPoisonResist = creatureData.getInt(ResourceDataKeys.KEY_POISON_RESIST);
        dStunResist = creatureData.getInt(ResourceDataKeys.KEY_STUN_RESIST);
        dMagicResist = creatureData.getInt(ResourceDataKeys.KEY_MAGIC_RESIST);
        dFireResist = creatureData.getInt(ResourceDataKeys.KEY_FIRE_RESIST);
        dNecroResist = creatureData.getInt(ResourceDataKeys.KEY_NECRO_RESIST);
    }
}
