package com.ae.spells;

/**
 * Represents a unique Spell instance. Spells implement a mechanic that can be used inside or outside of combat to
 * gain some sort of advantage or disadvantage an enemy. Spells require the caster to meet either faith or
 * intelligence requirements or both faith and intelligence requirements. They also require that the caster attune
 * them to a spellbook and have the spellbook actively equipped in their off-hand.
 * @author Christen Ford
 * @since 08/28/2020
 */
public class Spell {

    private final SpellFlyweight mFlyweight;
    private int dCharges;

    /**
     * Default constructor. Accepts a SpellFlyweight and initializes the number of available charges to the
     * spells maximum number of charges.
     * @param flyweight The SpellFlyweight containing constant spell information that represents the spell.
     */
    public Spell(SpellFlyweight flyweight) {
        this(flyweight, flyweight.getMaxCharges());
    }

    /**
     * State constructor. Accepts a SpellFlyweight and state-specific information to return a spell instantiated
     * to the spell's state stored in a save state.
     * @param flyweight The SpellFlyweight containing constant spell information that represents the spell.
     * @param charges The state-specific number of charges remaining.
     */
    public Spell(SpellFlyweight flyweight, int charges) {
        mFlyweight = flyweight;
        dCharges = charges;
    }

    /**
     * Returns the SpellFlyweight containing constant spell information.
     * @return A SpellFlyweight.
     */
    public SpellFlyweight getFlyweight() { return mFlyweight; }

    /**
     * Returns the state-specific number of charges available for this spell.
     * @return The number of charges remaining.
     */
    public int getCharges() { return dCharges; }

    /**
     * Returns whether this spell can be cast or not.
     * @return <code>true</code> if the Spell has at least one charge remaining.
     *         <code>false if the spell has no charges remaining.</code>
     */
    public boolean hasCharge() { return dCharges == 0; }

    /**
     * Expends a single charge to activate the spells effect.
     */
    public void useCharge() {
        if (hasCharge())
        {
            dCharges--;
        }
    }

    /**
     * Resets the number of charges available to the spell to the spell's max number of charges.
     */
    public void resetCharges() { dCharges = mFlyweight.getMaxCharges(); }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder(mFlyweight.toString());
        sb.append("Current Charges: ").append(dCharges).append("\\").append(mFlyweight.getMaxCharges()).append("\n");
        return sb.toString();
    }

}
