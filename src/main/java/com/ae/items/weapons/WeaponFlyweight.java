package com.ae.items.weapons;

import com.ae.items.ItemRarity;
import org.json.JSONObject;

/**
 *
 */
public class WeaponFlyweight {
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
        dId = weaponData.getInt(WeaponDataKeys.WEAPON_ID);
        sName = weaponData.getString(WeaponDataKeys.WEAPON_NAME);
        mWeaponSlot = WeaponSlot.valueOf(weaponData.getString(WeaponDataKeys.WEAPON_WEAPON_SLOT));
        mRarity = ItemRarity.valueOf(weaponData.getString(WeaponDataKeys.WEAPON_RARITY));
        dDamage = weaponData.getInt(WeaponDataKeys.WEAPON_DAMAGE);
        dWeight = weaponData.getInt(WeaponDataKeys.WEAPON_WEIGHT);
        dDurability = weaponData.getInt(WeaponDataKeys.WEAPON_DURABILITY);
        dBleedBuildup = weaponData.getInt(WeaponDataKeys.WEAPON_BLEED_BUILDUP);
        dPoisonBuildup = weaponData.getInt(WeaponDataKeys.WEAPON_POISON_BUILDUP);
        dStunBuildup = weaponData.getInt(WeaponDataKeys.WEAPON_STUN_BUILDUP);
        dMagicDamage = weaponData.getInt(WeaponDataKeys.WEAPON_MAGIC_DAMAGE);
        dFireDamage = weaponData.getInt(WeaponDataKeys.WEAPON_FIRE_DAMAGE);
        dNecroDamage = weaponData.getInt(WeaponDataKeys.WEAPON_NECRO_DAMAGE);
        dStrengthRequired = weaponData.getInt(WeaponDataKeys.WEAPON_STRENGTH_REQUIRED);
        dDexterityRequired = weaponData.getInt(WeaponDataKeys.WEAPON_DEXTERITY_REQUIRED);
        dIntelligenceRequired = weaponData.getInt(WeaponDataKeys.WEAPON_INTELLIGENCE_REQUIRED);
        dFaithRequired = weaponData.getInt(WeaponDataKeys.WEAPON_FAITH_REQUIRED);
        fStrengthScaling = weaponData.getDouble(WeaponDataKeys.WEAPON_STRENGTH_SCALING);
        fDexterityScaling = weaponData.getDouble(WeaponDataKeys.WEAPON_DEXTERITY_SCALING);
        fIntelligenceScaling = weaponData.getDouble(WeaponDataKeys.WEAPON_INTELLIGENCE_SCALING);
        fFaithScaling = weaponData.getDouble(WeaponDataKeys.WEAPON_FAITH_SCALING);
        sDescription = weaponData.getString(WeaponDataKeys.WEAPON_DESCRIPTION);
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
