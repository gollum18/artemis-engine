package com.ae.items.weapons;

import com.ae.resources.ResourceDataKeys;
import com.ae.spells.MagicType;
import com.ae.items.WearableFlyweight;
import org.json.JSONObject;

/**
 *
 */
public class SpellbookFlyweight extends WearableFlyweight {
    public final WeaponSlot mWeaponSlot = WeaponSlot.OFF_HAND;
    public final MagicType mMagicType;
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
        mMagicType = MagicType.valueOf(ResourceDataKeys.KEY_MAGIC_TYPE);
        dSlots = spellbookData.getInt(ResourceDataKeys.KEY_SLOTS);
        dMagicResist = spellbookData.getInt(ResourceDataKeys.KEY_MAGIC_RESIST);
        dFireResist = spellbookData.getInt(ResourceDataKeys.KEY_FIRE_RESIST);
        dNecroResist = spellbookData.getInt(ResourceDataKeys.KEY_NECRO_RESIST);
    }
}
