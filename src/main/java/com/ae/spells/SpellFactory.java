package com.ae.spells;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.FlyweightIterator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

/**
 * Implements a Singleton class that can be used to build lightweight-spells from Flyweight objects.
 * @author Christen Ford
 * @since 08/28/2020
 */
public class SpellFactory {

    private static SpellFactory mInstance;
    private final HashMap<Integer, SpellFlyweight> mFlyweights;

    /**
     * Singleton constructor that instantiates a SpellFactory using data from the given JSONArray resource.
     * @param spellData A JSONArray resource containing Spell flyweight data.
     */
    private SpellFactory(JSONArray spellData) {
        if (spellData == null) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate SpellFactory. Invalid argument specified for spell data file."
            );
        }
        mFlyweights = new HashMap<>();
        for (Object spellDatum : spellData) {
            JSONObject object = (JSONObject) spellDatum;
            SpellFlyweight flyweight = new SpellFlyweight(object);
            mFlyweights.put(flyweight.getId(), flyweight);
        }
    }

    /**
     * Returns the singleton instance of the SpellFactory.
     * @return A SpellFactory singleton.
     */
    public static SpellFactory getInstance() {
        if (mInstance == null) {
            JSONArray spellData = (JSONArray)ResourceLoader.loadResource(ResourceType.ST_SPELLS);
            mInstance = new SpellFactory(spellData);
        }
        return mInstance;
    }

    /**
     * Default spell construction method. Returns an instance of a Spell with a flyweight whose ID matches the
     * given id.
     * @param id The ID of the flyweight to construct the Spell with.
     * @return A Spell whose flyweight matches the given ID.
     */
    public Spell buildSpell(Integer id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate spell. Invalid Spell id specified."
            );
        }
        SpellFlyweight flyweight = mFlyweights.get(id);
        return new Spell(flyweight);
    }

    /**
     * State-specific construction method. Allows for restoring a Spell from a save state.
     * @param id The ID of the flyweight to construct the Spell with.
     * @param charges The state-specific number of charges to construct the spell with.
     * @return A state-specific Spell containing both flyweight and state-specific information.
     */
    public Spell buildSpell(Integer id, int charges) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                    "Error: Cannot instantiate spell. Invalid Spell id specified."
            );
        }
        SpellFlyweight flyweight = mFlyweights.get(id);
        return new Spell(flyweight, charges);
    }

    /**
     * Returns a Set containing the IDs of every SpellFlyweight currently loaded.
     * @return A set of Integer IDs.
     */
    public Set<Integer> spellKeys() { return mFlyweights.keySet(); }

    /**
     * Returns an iterator that allows the caller to iterate over all Spell flyweights by SpellType.
     * @param type One of the enumeration values defined by the SpellType enum.
     * @return An iterator over all SpellFlyweight objects whose SpellType matches <code>type</code>.
     */
    public Iterator<SpellFlyweight> getFlyweightsByType(SpellType type) {
        ArrayList<SpellFlyweight> collection = new ArrayList<>();
        for (SpellFlyweight fw : mFlyweights.values()) {
            if (fw.getType() == type) {
                collection.add(fw);
            }
        }
        return new FlyweightIterator<>(collection);
    }
}
