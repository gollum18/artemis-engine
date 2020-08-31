package com.ae.items.weapons;

import com.ae.items.ItemRarity;
import com.ae.resources.ResourceDataKeys;
import com.ae.util.flyweights.Flyweight;
import org.json.JSONObject;

/**
 *
 */
public class WeaponFlyweight extends Flyweight {
    private final int dId;
    private final String sName;
    private final WeaponSlot mWeaponSlot;
    private final ItemRarity mRarity;
    private final int dDamage;
    private final int dWeight;
    private final int dDurability;
    private final int dBleedBuildup;
    private final int dPoisonBuildup;
    private final int dStunBuildup;
    private final int dMagicDamage;
    private final int dFireDamage;
    private final int dNecroDamage;
    private final int dStrengthRequired;
    private final int dDexterityRequired;
    private final int dIntelligenceRequired;
    private final int dFaithRequired;
    private final double fStrengthScaling;
    private final double fDexterityScaling;
    private final double fIntelligenceScaling;
    private final double fFaithScaling;
    private final String sDescription;

    /**
     *
     * @param weaponData
     */
    public WeaponFlyweight(JSONObject weaponData) {
        dId = weaponData.getInt(ResourceDataKeys.KEY_ID);
        sName = weaponData.getString(ResourceDataKeys.KEY_NAME);
        mWeaponSlot = WeaponSlot.valueOf(weaponData.getString(ResourceDataKeys.KEY_SLOT));
        mRarity = ItemRarity.valueOf(weaponData.getString(ResourceDataKeys.KEY_RARITY));
        dDamage = weaponData.getInt(ResourceDataKeys.KEY_DAMAGE);
        dWeight = weaponData.getInt(ResourceDataKeys.KEY_WEIGHT);
        dDurability = weaponData.getInt(ResourceDataKeys.KEY_DURABILITY);
        dBleedBuildup = weaponData.getInt(ResourceDataKeys.KEY_BLEED_BUILDUP);
        dPoisonBuildup = weaponData.getInt(ResourceDataKeys.KEY_POISON_BUILDUP);
        dStunBuildup = weaponData.getInt(ResourceDataKeys.KEY_STUN_BUILDUP);
        dMagicDamage = weaponData.getInt(ResourceDataKeys.KEY_MAGIC_DAMAGE);
        dFireDamage = weaponData.getInt(ResourceDataKeys.KEY_FIRE_DAMAGE);
        dNecroDamage = weaponData.getInt(ResourceDataKeys.KEY_NECRO_DAMAGE);
        dStrengthRequired = weaponData.getInt(ResourceDataKeys.KEY_STRENGTH_REQUIREMENT);
        dDexterityRequired = weaponData.getInt(ResourceDataKeys.KEY_DEXTERITY_REQUIREMENT);
        dIntelligenceRequired = weaponData.getInt(ResourceDataKeys.KEY_INTELLIGENCE_REQUIREMENT);
        dFaithRequired = weaponData.getInt(ResourceDataKeys.KEY_FAITH_REQUIRED);
        fStrengthScaling = weaponData.getDouble(ResourceDataKeys.KEY_STRENGTH_SCALING);
        fDexterityScaling = weaponData.getDouble(ResourceDataKeys.KEY_DEXTERITY_SCALING);
        fIntelligenceScaling = weaponData.getDouble(ResourceDataKeys.KEY_INTELLIGENCE_SCALING);
        fFaithScaling = weaponData.getDouble(ResourceDataKeys.KEY_FAITH_SCALING);
        sDescription = weaponData.getString(ResourceDataKeys.KEY_DESCRIPTION);
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
    public WeaponSlot getWeaponSlot() { return mWeaponSlot; }

    /**
     *
     * @return
     */
    public ItemRarity getRarity() { return mRarity; }

    /**
     *
     * @return
     */
    public int getDamage() { return dDamage; }

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
    public int getBleedBuildup() { return dBleedBuildup; }

    /**
     *
     * @return
     */
    public int getPoisonBuildup() { return dPoisonBuildup; }

    /**
     *
     * @return
     */
    public int getStunBuildup() { return dStunBuildup; }

    /**
     *
     * @return
     */
    public int getMagicDamage() { return dMagicDamage; }

    /**
     *
     * @return
     */
    public int getFireDamage() { return dFireDamage; }

    /**
     *
     * @return
     */
    public int getNecroDamage() { return dNecroDamage; }

    /**
     *
     * @return
     */
    public int getStrengthRequired() { return dStrengthRequired; }

    /**
     *
     * @return
     */
    public int getDexterityRequired() { return dDexterityRequired; }

    /**
     *
     * @return
     */
    public int getIntelligenceRequired() { return dIntelligenceRequired; }

    /**
     *
     * @return
     */
    public int getFaithRequired() { return dFaithRequired; }

    /**
     *
     * @return
     */
    public double getStrengthScaling() { return fStrengthScaling; }

    /**
     *
     * @return
     */
    public double getDexterityScaling() { return fDexterityScaling; }

    /**
     *
     * @return
     */
    public double getIntelligenceScaling() { return fIntelligenceScaling; }

    /**
     *
     * @return
     */
    public double getFaithScaling() { return fFaithScaling; }

    /**
     *
     * @return
     */
    public String getDescription() { return sDescription; }
}
