package com.ae.items.armor;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import com.ae.util.FlyweightIterator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class ArmorFactory implements Factory {

    private static ArmorFactory mInstance;
    private final HashMap<Integer, ArmorFlyweight> mFlyweights;

    private ArmorFactory(JSONArray armorData) {
        if (armorData == null) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate ArmorFactory. Invalid argument specified for armor data file."
            );
        }
        mFlyweights = new HashMap<>();
        for (Object armorDatum : armorData) {
            JSONObject object = (JSONObject) armorDatum;
            ArmorFlyweight flyweight = new ArmorFlyweight(object);
            mFlyweights.put(flyweight.dId, flyweight);
        }
    }

    public static ArmorFactory getInstance() {
        if (mInstance == null) {
            JSONArray armorData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_ARMOR);
            mInstance = new ArmorFactory(armorData);
        }
        return mInstance;
    }

    public ArmorFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Armor. Invalid Armor ID specified."
            );
        }
        return mFlyweights.get(id);
    }

    public Armor build(int id) {
        ArmorFlyweight flyweight = getFlyweightById(id);
        return new Armor(flyweight);
    }

    public Armor build(int id, JSONObject stateData) {
        ArmorFlyweight flyweight = getFlyweightById(id);
        return new Armor(flyweight, stateData);
    }

    public Set<Integer> armorKeys() { return mFlyweights.keySet(); }

    public Iterator<ArmorFlyweight> getFlyweightsByClass(ArmorClass armorClass) {
        ArrayList<ArmorFlyweight> collection = new ArrayList<>();
        for (ArmorFlyweight fw : mFlyweights.values()) {
            if (fw.mArmorClass == armorClass) {
                collection.add(fw);
            }
        }
        return new FlyweightIterator<>(collection);
    }

    public Iterator<ArmorFlyweight> getFlyweightsBySlot(ArmorSlot slot) {
        ArrayList<ArmorFlyweight> collection = new ArrayList<>();
        for (ArmorFlyweight fw : mFlyweights.values()) {
            if (fw.mArmorSlot == slot) {
                collection.add(fw);
            }
        }
        return new FlyweightIterator<>(collection);
    }

}
