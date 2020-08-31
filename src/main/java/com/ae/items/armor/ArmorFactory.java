package com.ae.items.armor;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

/**
 *
 */
public class ArmorFactory {

    private static ArmorFactory mInstance;
    private final HashMap<Integer, ArmorFlyweight> mFlyweights;

    /**
     *
     * @param armorData
     */
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
            mFlyweights.put(flyweight.getId(), flyweight);
        }
    }

    /**
     *
     * @return
     */
    public static ArmorFactory getInstance() {
        if (mInstance == null) {
            JSONArray armorData = (JSONArray) ResourceLoader.loadResource(ResourceType.ST_ARMOR);
            mInstance = new ArmorFactory(armorData);
        }
        return mInstance;
    }

    /**
     *
     * @param id
     * @return
     */
    public Armor buildArmor(Integer id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Armor. Invalid Armor ID specified."
            );
        }
        ArmorFlyweight flyweight = mFlyweights.get(id);
        return new Armor(flyweight);
    }

    /**
     *
     * @return
     */
    public Set<Integer> armorKeys() { return mFlyweights.keySet(); }

    /**
     *
     * @param armorClass
     * @return
     */
    public Iterator<ArmorFlyweight> getFlyweightsByClass(ArmorClass armorClass) {
        ArrayList<ArmorFlyweight> collection = new ArrayList<>();
        for (ArmorFlyweight fw : mFlyweights.values()) {
            if (fw.getArmorClass() == armorClass) {
                collection.add(fw);
            }
        }
        return new ArmorFlyweightIterator(collection);
    }

    public Iterator<ArmorFlyweight> getFlyweightsBySlot(ArmorSlot slot) {
        ArrayList<ArmorFlyweight> collection = new ArrayList<>();
        for (ArmorFlyweight fw : mFlyweights.values()) {
            if (fw.getArmorSlot() == slot) {
                collection.add(fw);
            }
        }
        return new ArmorFlyweightIterator(collection);
    }

    /**
     *
     */
    private static class ArmorFlyweightIterator implements Iterator<ArmorFlyweight> {

        private final List<ArmorFlyweight> mList;
        private int dIndex = 0;

        /**
         *
         * @param list
         */
        public ArmorFlyweightIterator(List<ArmorFlyweight> list) { mList = list; }

        /**
         *
         * @return
         */
        @Override public boolean hasNext() { return dIndex != mList.size(); }

        /**
         *
         * @return
         */
        @Override public ArmorFlyweight next() { return mList.get(dIndex++); }
    }

}
