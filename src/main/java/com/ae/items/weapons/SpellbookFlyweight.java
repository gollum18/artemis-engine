package com.ae.items.weapons;

import com.ae.items.ItemRarity;
import com.ae.resources.ResourceDataKeys;
import com.ae.spells.SpellType;
import com.ae.util.flyweights.Flyweight;
import org.json.JSONObject;

/**
 *
 */
public class SpellbookFlyweight extends Flyweight {
    private final WeaponSlot mWeaponSlot = WeaponSlot.OFF_HAND;
    private final int dId;
    private final SpellType mSpellType;
    private final ItemRarity mRarity;
    private final int dSlots;
    private final int dMagicResist;
    private final int dFireResist;
    private final int dNecroResist;
    private final int dIntRequirement;
    private final int dFaithRequirement;
    private final String sDescription;

    /**
     *
     * @param spellbookData
     */
    public SpellbookFlyweight(JSONObject spellbookData) {
        dId = spellbookData.getInt(ResourceDataKeys.KEY_ID);
        mSpellType = SpellType.valueOf(ResourceDataKeys.KEY_TYPE);
        mRarity = ItemRarity.valueOf(ResourceDataKeys.KEY_RARITY);
        dSlots = spellbookData.getInt(ResourceDataKeys.KEY_SLOTS);
        dMagicResist = spellbookData.getInt(ResourceDataKeys.KEY_MAGIC_RESIST);
        dFireResist = spellbookData.getInt(ResourceDataKeys.KEY_FIRE_RESIST);
        dNecroResist = spellbookData.getInt(ResourceDataKeys.KEY_NECRO_RESIST);
        dIntRequirement = spellbookData.getInt(ResourceDataKeys.KEY_INT_REQUIREMENT);
        dFaithRequirement = spellbookData.getInt(ResourceDataKeys.KEY_FAITH_REQUIREMENT);
        sDescription = spellbookData.getString(ResourceDataKeys.KEY_DESCRIPTION);
    }

    /**
     *
     * @return
     */
    public WeaponSlot getWeaponSlot() { return mWeaponSlot; }

    /**
     *
     * @return
     */
    public int getId() { return dId; }

    /**
     *
     * @return
     */
    public SpellType getSpellType() { return mSpellType; }

    /**
     *
     * @return
     */
    public ItemRarity getRarity() { return mRarity; }

    /**
     *
     * @return
     */
    public int getSlots() { return dSlots; }

    /**
     *
     * @return
     */
    public int getMagicResist() { return dMagicResist; }

    /**
     *
     * @return
     */
    public int getFireResist() { return dFireResist; }

    /**
     *
     * @return
     */
    public int getNecroResist() { return dNecroResist; }

    /**
     *
     * @return
     */
    public int getIntRequirement() { return dIntRequirement; }

    /**
     *
     * @return
     */
    public int getFaithRequirement() { return dFaithRequirement; }

    /**
     *
     * @return
     */
    public String getDescription() { return sDescription; }
}
