package com.ae.spells;

import com.ae.resources.ResourceDataKeys;
import com.ae.spells.SpellEffect;
import com.ae.spells.SpellTarget;
import com.ae.spells.MagicType;
import com.ae.spells.SpellType;
import com.ae.util.Flyweight;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Implements a read-only data container for spell information to be shared across multiple Spell instances.
 * @author Christen Ford
 * @since 08/29/2020
 */
public class SpellFlyweight extends Flyweight {
    public final Set<SpellEffect> mEffects;
    public final SpellTarget mTarget;
    public final MagicType mMagicType;
    public final SpellType mSpellType;
    public final int dDuration;
    public final int dRange;
    public final int dFalloff;
    public final int dAreaOfEffect;
    public final int dMaxCharges;
    public final int dSlotsRequired;
    public final int dIntRequired;
    public final int dFaithRequired;

    /**
     * Default constructor. Instantiates a SpellFlyweight with the spell information from <code>spellData</code>.
     * @param spellData A JSONObject containing SpellFlyweight data.
     * @throws IllegalArgumentException If <code>spellData</code> is null.
     * @throws org.json.JSONException If <code>spellData</code> does not conform to specification.
     */
    public SpellFlyweight(JSONObject spellData) {
        super(spellData);
        mTarget = SpellTarget.valueOf(spellData.getString(ResourceDataKeys.KEY_TARGET));
        mMagicType = MagicType.valueOf(spellData.getString(ResourceDataKeys.KEY_MAGIC_TYPE));
        mSpellType = SpellType.valueOf(spellData.getString(ResourceDataKeys.KEY_SPELL_TYPE));
        dDuration = spellData.getInt(ResourceDataKeys.KEY_DURATION);
        dRange = spellData.getInt(ResourceDataKeys.KEY_RANGE);
        dFalloff = spellData.getInt(ResourceDataKeys.KEY_FALLOFF);
        dAreaOfEffect = spellData.getInt(ResourceDataKeys.KEY_AOE);
        dMaxCharges = spellData.getInt(ResourceDataKeys.KEY_MAX_CHARGES);
        dSlotsRequired = spellData.getInt(ResourceDataKeys.KEY_SLOTS_REQUIRED);
        dIntRequired = spellData.getInt(ResourceDataKeys.KEY_INT_REQUIREMENT);
        dFaithRequired = spellData.getInt(ResourceDataKeys.KEY_FAITH_REQUIREMENT);
        mEffects = new HashSet<>(4);
        for (Object o : spellData.getJSONArray(ResourceDataKeys.KEY_EFFECTS)) {
            String effect = String.valueOf(o);
            mEffects.add(SpellEffect.valueOf(effect));
        }
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(sName).append("\n");
        sb.append("Magic Type: ").append(mMagicType).append("\n");
        sb.append("Spell Type: ").append(mSpellType).append("\n");
        sb.append("Range: ").append(dRange).append("\n");
        sb.append("Falloff: ").append(dFalloff).append("\n");
        sb.append("Area of Effect: ").append(dAreaOfEffect).append("\n");
        sb.append("Duration: ").append(dDuration).append("\n");
        sb.append("Int Required: ").append(dIntRequired).append("\n");
        sb.append("Faith Required: ").append(dFaithRequired).append("\n");
        sb.append("Slots Required: ").append(dSlotsRequired).append("\n");
        sb.append("Spell Effects: [ ");
        for (SpellEffect effect : mEffects) { sb.append(effect).append(" "); }
        sb.append("]\n");
        return sb.toString();
    }

}
