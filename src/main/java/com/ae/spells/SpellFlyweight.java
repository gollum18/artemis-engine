package com.ae.spells;

import com.ae.resources.ResourceDataKeys;
import com.ae.util.flyweights.Flyweight;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implements a read-only data container for spell information to be shared across multiple Spell instances.
 * @author Christen Ford
 * @since 08/29/2020
 */
public class SpellFlyweight extends Flyweight {
    private final int dId;
    private final String sName;
    private final Set<SpellEffect> mEffects;
    private final SpellTarget mTarget;
    private final SpellType mType;
    private final int dDuration;
    private final int dRange;
    private final int dFalloff;
    private final int dAreaOfEffect;
    private final int dMaxCharges;
    private final int dSlotsRequired;
    private final int dIntRequired;
    private final int dFaithRequired;
    private final int dMagicDamage;
    private final int dFireDamage;
    private final int dNecroDamage;
    private final int dMagicResist;
    private final int dFireResist;
    private final int dNecroResist;
    private final int dHealAmt;
    private final int dBleedBuildup;
    private final int dPoisonBuildup;
    private final int dStunBuildup;
    private final String sDescription;

    /**
     * Default constructor. Instantiates a SpellFlyweight with the spell information from <code>spellData</code>.
     * @param spellData A JSONObject containing SpellFlyweight data.
     * @throws IllegalArgumentException If <code>spellData</code> is null.
     * @throws org.json.JSONException If <code>spellData</code> does not conform to specification.
     */
    public SpellFlyweight(JSONObject spellData) {
        if (spellData == null) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate SpellFlyweight. Spell data container is null."
            );
        }
        dId = spellData.getInt(ResourceDataKeys.KEY_ID);
        sName = spellData.getString(ResourceDataKeys.KEY_NAME);
        mTarget = SpellTarget.valueOf(spellData.getString(ResourceDataKeys.KEY_TARGET));
        mType = SpellType.valueOf(spellData.getString(ResourceDataKeys.KEY_TYPE));
        dDuration = spellData.getInt(ResourceDataKeys.KEY_DURATION);
        dRange = spellData.getInt(ResourceDataKeys.KEY_RANGE);
        dFalloff = spellData.getInt(ResourceDataKeys.KEY_FALLOFF);
        dAreaOfEffect = spellData.getInt(ResourceDataKeys.KEY_AOE);
        dMaxCharges = spellData.getInt(ResourceDataKeys.KEY_MAX_CHARGES);
        dSlotsRequired = spellData.getInt(ResourceDataKeys.KEY_SLOTS_REQUIRED);
        dIntRequired = spellData.getInt(ResourceDataKeys.KEY_INT_REQUIREMENT);
        dFaithRequired = spellData.getInt(ResourceDataKeys.KEY_FAITH_REQUIREMENT);
        dMagicDamage = spellData.getInt(ResourceDataKeys.KEY_MAGIC_DAMAGE);
        dFireDamage = spellData.getInt(ResourceDataKeys.KEY_FIRE_DAMAGE);
        dNecroDamage = spellData.getInt(ResourceDataKeys.KEY_NECRO_DAMAGE);
        dMagicResist = spellData.getInt(ResourceDataKeys.KEY_MAGIC_RESIST);
        dFireResist = spellData.getInt(ResourceDataKeys.KEY_FIRE_RESIST);
        dNecroResist = spellData.getInt(ResourceDataKeys.KEY_NECRO_RESIST);
        dHealAmt = spellData.getInt(ResourceDataKeys.KEY_HEAL_AMOUNT);
        dBleedBuildup = spellData.getInt(ResourceDataKeys.KEY_BLEED_BUILDUP);
        dPoisonBuildup = spellData.getInt(ResourceDataKeys.KEY_POISON_BUILDUP);
        dStunBuildup = spellData.getInt(ResourceDataKeys.KEY_STUN_BUILDUP);
        sDescription = spellData.getString(ResourceDataKeys.KEY_DESCRIPTION);
        mEffects = new HashSet<>(4);
        for (Object o : spellData.getJSONArray(ResourceDataKeys.KEY_EFFECTS)) {
            String effect = String.valueOf(o);
            mEffects.add(SpellEffect.valueOf(effect));
        }
    }

    /**
     * Returns the unique ID for the SpellFlyweight.
     * @return An int representing the flyweight.
     */
    public int getId() { return dId; }

    /**
     * Returns the unique Name for the SpellFlyweight.
     * @return The name of the flyweight.
     */
    public String getName() { return sName; }

    /**
     * Returns the SpellEffects that the Flyweight inflicts.
     * @return An iterator containing SpellEffect enumeration values.
     */
    public Iterator<SpellEffect> getEffects() { return mEffects.iterator(); }

    /**
     * Returns the target of the SpellFlyweight.
     * @return An enumeration value from the SpellTarget enumeration.
     */
    public SpellTarget getTarget() { return mTarget; }

    /**
     * Returns the type of the SpellFlyweight.
     * @return An enumeration value from the SpellType enumeration.
     */
    public SpellType getType() { return mType; }

    /**
     * Returns the number of turns a SpellEffect is active for. A spell with duration of 0 has its effect applied
     * immediately and only for one turn.
     * @return The number of turns a SpellEffect is active for.
     */
    public int getDuration() { return dDuration; }

    /**
     * Returns the range of the Spell represented by the flyweight. Casters of the Spell can not cast the Spell
     * beyond the number of tiles represented by this Spell unless they augment their range either via a
     * consumable or wearable that does so.
     * @return The number of tiles that the Spell can be cast within.
     */
    public int getRange() { return dRange; }

    /**
     *
     * @return
     */
    public int getFalloff() { return dFalloff; }

    /**
     * Returns the area of effect of a Spell. This value represents the number of tiles that are radially affected
     * from the center tile the Spell was cast at. For instance, a Spell with an area of effect of three tiles would
     * affect entities standing in the target tile as well as entities standing in a three tile radius from the target
     * tile.
     * @return The area of effect of a Spell.
     */
    public int getAreaOfEffect() { return dAreaOfEffect; }

    /**
     * Returns the maximum number of uses a caster has the cast this spell. The same spell can be attuned multiple
     * times to stack this value within a Spellbook.
     * @return Then maximum number of times the Spell represented by the flyweight can be cast.
     */
    public int getMaxCharges() { return dMaxCharges; }

    /**
     * Returns the number of slots the Spell occupies when equipped in a Spellbook.
     * @return The number of Spellbook slots the Spell occupied.
     */
    public int getSlotsRequired() { return dSlotsRequired; }

    /**
     * Returns the intelligence required to cast the Spell represented by the flyweight.
     * @return The intelligence required to cast the spell.
     */
    public int getIntRequired() { return dIntRequired; }

    /**
     * Returns the faith required to cast the Spell represented by the flyweight.
     * @return The faith required to cast the Spell.
     */
    public int getFaithRequired() { return dFaithRequired; }

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
    public int getHealAmount() { return dHealAmt; }

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
     * Returns the description of the Spell represented by the flyweight.
     * @return The description of the SpellFlyweight.
     */
    public String getDescription() { return sDescription; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(sName).append("\n");
        sb.append("Range: ").append(dRange).append("\n");
        sb.append("Falloff: ").append(dFalloff).append("\n");
        sb.append("Area of Effect: ").append(dAreaOfEffect).append("\n");
        sb.append("Duration: ").append(dDuration).append("\n");
        sb.append("Int Required: ").append(dIntRequired).append("\n");
        sb.append("Faith Required: ").append(dFaithRequired).append("\n");
        sb.append("Slots Required: ").append(dSlotsRequired).append("\n");
        return sb.toString();
    }

}
