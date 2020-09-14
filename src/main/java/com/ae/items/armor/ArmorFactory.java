package com.ae.items.armor;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import com.ae.util.FlyweightIterator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class ArmorFactory implements Factory<ArmorFlyweight, Armor> {

    private static ArmorFactory mInstance;
    private final HashMap<Integer, ArmorFlyweight> mBaseFlyweights;

    private ArmorFactory(JSONArray armorData) {
        if (armorData == null) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate ArmorFactory. Invalid argument specified for armor data file."
            );
        }
        mBaseFlyweights = new HashMap<>();
        for (Object armorDatum : armorData) {
            JSONObject object = (JSONObject) armorDatum;
            ArmorFlyweight flyweight = new ArmorFlyweight(object);
            mBaseFlyweights.put(flyweight.dId, flyweight);
        }
    }

    public static ArmorFactory getInstance() {
        if (mInstance == null) {
            JSONArray armorData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_ARMOR);
            mInstance = new ArmorFactory(armorData);
        }
        return mInstance;
    }

    private void cacheScaledFlyweight() {

    }

    public ArmorFlyweight getFlyweightById(int id) {
        if (!mBaseFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Armor. Invalid Armor ID specified."
            );
        }
        return mBaseFlyweights.get(id);
    }

    public Armor build(int id) {
        ArmorFlyweight flyweight = getFlyweightById(id);
        return new Armor(flyweight);
    }

    public Armor build(int id, int gs) {
        // TODO: Implement me
        return null;
    }

    public Armor build(int id, JSONObject stateData) {
        ArmorFlyweight flyweight = getFlyweightById(id);
        return new Armor(flyweight, stateData);
    }

    public Set<Integer> armorKeys() { return mBaseFlyweights.keySet(); }

    public Iterator<ArmorFlyweight> getFlyweightsByClass(ArmorClass armorClass) {
        ArrayList<ArmorFlyweight> collection = new ArrayList<>();
        for (ArmorFlyweight fw : mBaseFlyweights.values()) {
            if (fw.mArmorClass == armorClass) {
                collection.add(fw);
            }
        }
        return new FlyweightIterator<>(collection);
    }

    public Iterator<ArmorFlyweight> getFlyweightsBySlot(ArmorSlot slot) {
        ArrayList<ArmorFlyweight> collection = new ArrayList<>();
        for (ArmorFlyweight fw : mBaseFlyweights.values()) {
            if (fw.mArmorSlot == slot) {
                collection.add(fw);
            }
        }
        return new FlyweightIterator<>(collection);
    }

}
