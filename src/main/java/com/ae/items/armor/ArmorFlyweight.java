package com.ae.items.armor;

import com.ae.resources.ResourceDataKeys;
import com.ae.items.WearableFlyweight;
import org.json.JSONObject;

/**
 *
 */
public class ArmorFlyweight extends WearableFlyweight {
    public final ArmorClass mArmorClass;
    public final ArmorSlot mArmorSlot;
    public final int dDefense;
    public final int dBleedResist;
    public final int dPoisonResist;
    public final int dStunResist;
    public final int dMagicResist;
    public final int dFireResist;
    public final int dNecroResist;

    /**
     * Returns a constant read-only Flyweight for Armor data.
     * @param armorData A JSONObject containing Armor data. This must follow the correct
     * specification or this constructor will raise a org.json.JSONException.
     */
    public ArmorFlyweight(JSONObject armorData) {
        super(armorData);
        mArmorClass = ArmorClass.valueOf(armorData.getString(ResourceDataKeys.KEY_ARMOR_CLASS));
        mArmorSlot = ArmorSlot.valueOf(armorData.getString(ResourceDataKeys.KEY_ARMOR_SLOT));
        dDefense = armorData.getInt(ResourceDataKeys.KEY_DEFENSE);
        dBleedResist = armorData.getInt(ResourceDataKeys.KEY_BLEED_RESIST);
        dPoisonResist = armorData.getInt(ResourceDataKeys.KEY_POISON_RESIST);
        dStunResist = armorData.getInt(ResourceDataKeys.KEY_STUN_RESIST);
        dMagicResist = armorData.getInt(ResourceDataKeys.KEY_MAGIC_RESIST);
        dFireResist = armorData.getInt(ResourceDataKeys.KEY_FIRE_RESIST);
        dNecroResist = armorData.getInt(ResourceDataKeys.KEY_NECRO_RESIST);
    }
}
