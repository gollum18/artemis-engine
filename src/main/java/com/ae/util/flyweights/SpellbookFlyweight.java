package com.ae.util.flyweights;

import com.ae.items.weapons.WeaponSlot;
import com.ae.resources.ResourceDataKeys;
import com.ae.spells.SpellType;
import org.json.JSONObject;

/**
 *
 */
public class SpellbookFlyweight extends WearableFlyweight {
    public final WeaponSlot mWeaponSlot = WeaponSlot.OFF_HAND;
    public final SpellType mSpellType;
    public final int dSlots;
    public final int dMagicResist;
    public final int dFireResist;
    public final int dNecroResist;

    /**
     *
     * @param spellbookData
     */
    public SpellbookFlyweight(JSONObject spellbookData) {
        super(spellbookData);
        mSpellType = SpellType.valueOf(ResourceDataKeys.KEY_TYPE);
        dSlots = spellbookData.getInt(ResourceDataKeys.KEY_SLOTS);
        dMagicResist = spellbookData.getInt(ResourceDataKeys.KEY_MAGIC_RESIST);
        dFireResist = spellbookData.getInt(ResourceDataKeys.KEY_FIRE_RESIST);
        dNecroResist = spellbookData.getInt(ResourceDataKeys.KEY_NECRO_RESIST);
    }
}
