package com.ae.spells;

import com.ae.resources.ResourceDataKeys;
import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import com.ae.util.FlyweightIterator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class SpellFactory implements Factory<SpellFlyweight, Spell> {
    private static SpellFactory mInstance;
    private final HashMap<Integer, SpellFlyweight> mFlyweights;

    private SpellFactory(JSONArray spellData) {
        mFlyweights = new HashMap<>();
        for (Object object : spellData) {
            JSONObject spellDatum = (JSONObject) object;
            SpellFlyweight fw = null;
            switch (SpellType.valueOf(spellDatum.getString(ResourceDataKeys.KEY_SPELL_TYPE))) {
                case OFFENSIVE:
                    fw = new OffensiveSpellFlyweight(spellDatum);
                    break;
                case DEFENSIVE:
                    fw = new DefensiveSpellFlyweight(spellDatum);
                    break;
            }
            mFlyweights.put(fw.dId, fw);
        }
    }

    public static SpellFactory getInstance() {
        if (mInstance == null) {
            JSONArray spellData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_SPELLS);
            mInstance = new SpellFactory(spellData);
        }
        return mInstance;
    }

    public SpellFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate spell. Invalid spell ID specified."
            );
        }
        return mFlyweights.get(id);
    }

    public Spell build(int id) {
        SpellFlyweight fw = getFlyweightById(id);
        return new Spell(fw);
    }

    public Spell build(int id, int gs) {
        // TODO: Implement me
        return null;
    }

    public Spell build(int id, JSONObject stateData) {
        SpellFlyweight fw = getFlyweightById(id);
        return new Spell(fw, stateData);
    }

    public Set<Integer> getSpellIds() { return mFlyweights.keySet(); }

    public FlyweightIterator<SpellFlyweight> getSpellsByMagicType(MagicType type) {
        ArrayList<SpellFlyweight> mList = new ArrayList<>();
        for (SpellFlyweight fw : mFlyweights.values()) {
            if (fw.mMagicType == type) {
                mList.add(fw);
            }
        }
        return new FlyweightIterator<>(mList);
    }

    public FlyweightIterator<SpellFlyweight> getSpellsBySpellType(SpellType type) {
        ArrayList<SpellFlyweight> mList = new ArrayList<>();
        for (SpellFlyweight fw : mFlyweights.values()) {
            if (fw.mSpellType == type) {
                mList.add(fw);
            }
        }
        return new FlyweightIterator<>(mList);
    }

    public FlyweightIterator<SpellFlyweight> getSpellsBySpellAndMagicType(SpellType spellType, MagicType magicType) {
        ArrayList<SpellFlyweight> mList = new ArrayList<>();
        for (SpellFlyweight fw : mFlyweights.values()) {
            if (fw.mSpellType == spellType && fw.mMagicType == magicType) {
                mList.add(fw);
            }
        }
        return new FlyweightIterator<>(mList);
    }
}
