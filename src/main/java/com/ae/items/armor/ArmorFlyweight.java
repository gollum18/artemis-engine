package com.ae.items.armor;

import com.ae.items.ItemRarity;
import com.ae.resources.ResourceDataKeys;
import com.ae.util.flyweights.Flyweight;
import org.json.JSONObject;

/**
 *
 */
public class ArmorFlyweight extends Flyweight {
    private final int dId;
    private final String sName;
    private final ArmorClass mArmorClass;
    private final ArmorSlot mArmorSlot;
    private final ItemRarity mRarity;
    private final int dWeight;
    private final int dDurability;
    private final int dDefense;
    private final int dBleedResist;
    private final int dPoisonResist;
    private final int dStunResist;
    private final int dMagicResist;
    private final int dFireResist;
    private final int dNecroResist;
    private final int dStrengthRequirement;
    private final int dDexterityRequirement;
    private final int dIntelligenceRequirement;
    private final int dFaithRequirement;

    /**
     *
     * @param armorData
     */
    public ArmorFlyweight(JSONObject armorData) {
        if (armorData == null) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate ArmorFlyweight. Armor data container is null."
            );
        }
        dId = armorData.getInt(ResourceDataKeys.KEY_ID);
        sName = armorData.getString(ResourceDataKeys.KEY_NAME);
        mArmorClass = ArmorClass.valueOf(armorData.getString(ResourceDataKeys.KEY_CLASS));
        mArmorSlot = ArmorSlot.valueOf(armorData.getString(ResourceDataKeys.KEY_SLOT));
        mRarity = ItemRarity.valueOf(armorData.getString(ResourceDataKeys.KEY_RARITY));
        dWeight = armorData.getInt(ResourceDataKeys.KEY_WEIGHT);
        dDurability = armorData.getInt(ResourceDataKeys.KEY_DURABILITY);
        dDefense = armorData.getInt(ResourceDataKeys.KEY_DEFENSE);
        dBleedResist = armorData.getInt(ResourceDataKeys.KEY_BLEED_RESIST);
        dPoisonResist = armorData.getInt(ResourceDataKeys.KEY_POISON_RESIST);
        dStunResist = armorData.getInt(ResourceDataKeys.KEY_STUN_RESIST);
        dMagicResist = armorData.getInt(ResourceDataKeys.KEY_MAGIC_RESIST);
        dFireResist = armorData.getInt(ResourceDataKeys.KEY_FIRE_RESIST);
        dNecroResist = armorData.getInt(ResourceDataKeys.KEY_NECRO_RESIST);
        dStrengthRequirement = armorData.getInt(ResourceDataKeys.KEY_STR_REQUIREMENT);
        dDexterityRequirement = armorData.getInt(ResourceDataKeys.KEY_DEX_REQUIREMENT);
        dIntelligenceRequirement = armorData.getInt(ResourceDataKeys.KEY_INT_REQUIREMENT);
        dFaithRequirement = armorData.getInt(ResourceDataKeys.KEY_FAITH_REQUIREMENT);
    }

    /**
     *
     * @return
     */
    public int getId() { return dId; }

    /**
     *
     * @return
     */
    public String getName() { return sName; }

    /**
     *
     * @return
     */
    public ArmorClass getArmorClass() { return mArmorClass; }

    /**
     *
     * @return
     */
    public ArmorSlot getArmorSlot() { return mArmorSlot; }

    /**
     *
     * @return
     */
    public ItemRarity getRarity() { return mRarity; }

    /**
     *
     * @return
     */
    public int getWeight() { return dWeight; }

    /**
     *
     * @return
     */
    public int getDurability() { return dDurability; }

    /**
     *
     * @return
     */
    public int getDefense() { return dDefense; }

    /**
     *
     * @return
     */
    public int getBleedResist() { return dBleedResist; }

    /**
     *
     * @return
     */
    public int getPoisonResist() { return dPoisonResist; }

    /**
     *
     * @return
     */
    public int getStunResist() { return dStunResist; }

    /**
     *
     * @return
     */
    public int getLightningResist() { return dMagicResist; }

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
    public int getStrengthRequirement() { return dStrengthRequirement; }

    /**
     *
     * @return
     */
    public int getDexterityRequirement() { return dDexterityRequirement; }

    /**
     *
     * @return
     */
    public int getIntelligenceRequirement() { return dIntelligenceRequirement; }

    /**
     *
     * @return
     */
    public int getFaithRequirement() { return dFaithRequirement; }
}
