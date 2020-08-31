package com.ae.items.armor;

import com.ae.items.ItemRarity;
import com.ae.util.Flyweight;
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
        dId = armorData.getInt(ArmorDataKeys.ARMOR_ID);
        sName = armorData.getString(ArmorDataKeys.ARMOR_NAME);
        mArmorClass = ArmorClass.valueOf(armorData.getString(ArmorDataKeys.ARMOR_CLASS));
        mArmorSlot = ArmorSlot.valueOf(armorData.getString(ArmorDataKeys.ARMOR_SLOT));
        mRarity = ItemRarity.valueOf(armorData.getString(ArmorDataKeys.ARMOR_RARITY));
        dWeight = armorData.getInt(ArmorDataKeys.ARMOR_WEIGHT);
        dDurability = armorData.getInt(ArmorDataKeys.ARMOR_DURABILITY);
        dDefense = armorData.getInt(ArmorDataKeys.ARMOR_DEFENSE);
        dBleedResist = armorData.getInt(ArmorDataKeys.ARMOR_BLEED_RESIST);
        dPoisonResist = armorData.getInt(ArmorDataKeys.ARMOR_POISON_RESIST);
        dStunResist = armorData.getInt(ArmorDataKeys.ARMOR_STUN_RESIST);
        dMagicResist = armorData.getInt(ArmorDataKeys.ARMOR_MAGIC_RESIST);
        dFireResist = armorData.getInt(ArmorDataKeys.ARMOR_FIRE_RESIST);
        dNecroResist = armorData.getInt(ArmorDataKeys.ARMOR_NECRO_RESIST);
        dStrengthRequirement = armorData.getInt(ArmorDataKeys.ARMOR_STRENGTH_REQUIREMENT);
        dDexterityRequirement = armorData.getInt(ArmorDataKeys.ARMOR_DEXTERITY_REQUIREMENT);
        dIntelligenceRequirement = armorData.getInt(ArmorDataKeys.ARMOR_INTELLIGENCE_REQUIREMENT);
        dFaithRequirement = armorData.getInt(ArmorDataKeys.ARMOR_FAITH_REQUIREMENT);
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
