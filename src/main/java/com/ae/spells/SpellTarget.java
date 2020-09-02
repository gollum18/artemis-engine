package com.ae.spells;

/**
 *  Helper enum that represents the target types for a spell.
 *  <code>TARGET</code> is a single target, either the caster or another entity.
 *  <code>HOP</code> is for Spells that initially target a single entity and can hop to other hostile entities
 *  within falloff range of a Spell. At each hop, falloff range decreases by a constant value.
 *  <code>AREA</code> is for Spells that target a radial area on the combat map.
 * @author Christen Ford
 * @since 08/28/2020
 */
public enum SpellTarget {
    SELF,
    TARGET,
    HOP,
    AREA
}
