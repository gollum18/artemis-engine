package com.ae.items.weapons;

import com.ae.resources.ResourceDataKeys;
import com.ae.items.WearableFlyweight;
import org.json.JSONObject;

/**
 *
 */
public class WeaponFlyweight extends WearableFlyweight {
    public final int dDamage;
    public final int dBleedBuildup;
    public final int dPoisonBuildup;
    public final int dStunBuildup;
    public final int dMagicDamage;
    public final int dFireDamage;
    public final int dNecroDamage;
    public final double fStrengthScaling;
    public final double fDexterityScaling;
    public final double fIntelligenceScaling;
    public final double fFaithScaling;
    public final WeaponSlot mWeaponSlot;

    /**
     *
     * @param weaponData
     */
    public WeaponFlyweight(JSONObject weaponData) {
        super(weaponData);
        dDamage = weaponData.getInt(ResourceDataKeys.KEY_DAMAGE);
        dBleedBuildup = weaponData.getInt(ResourceDataKeys.KEY_BLEED_BUILDUP);
        dPoisonBuildup = weaponData.getInt(ResourceDataKeys.KEY_POISON_BUILDUP);
        dStunBuildup = weaponData.getInt(ResourceDataKeys.KEY_STUN_BUILDUP);
        dMagicDamage = weaponData.getInt(ResourceDataKeys.KEY_MAGIC_DAMAGE);
        dFireDamage = weaponData.getInt(ResourceDataKeys.KEY_FIRE_DAMAGE);
        dNecroDamage = weaponData.getInt(ResourceDataKeys.KEY_NECRO_DAMAGE);
        fStrengthScaling = weaponData.getDouble(ResourceDataKeys.KEY_STRENGTH_SCALING);
        fDexterityScaling = weaponData.getDouble(ResourceDataKeys.KEY_DEXTERITY_SCALING);
        fIntelligenceScaling = weaponData.getDouble(ResourceDataKeys.KEY_INTELLIGENCE_SCALING);
        fFaithScaling = weaponData.getDouble(ResourceDataKeys.KEY_FAITH_SCALING);
        mWeaponSlot = WeaponSlot.valueOf(weaponData.getString(ResourceDataKeys.KEY_WEAPON_SLOT));
    }
}
