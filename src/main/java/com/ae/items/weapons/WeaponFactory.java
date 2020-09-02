package com.ae.items.weapons;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.Factory;
import com.ae.util.FlyweightIterator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class WeaponFactory implements Factory {
    private static WeaponFactory mInstance;
    private final HashMap<Integer, WeaponFlyweight> mFlyweights;

    private WeaponFactory(JSONArray weaponData) {
        mFlyweights = new HashMap<>();
        for (Object weaponDatum : weaponData) {
            JSONObject object = (JSONObject) weaponDatum;
            WeaponFlyweight flyweight = new WeaponFlyweight(object);
            mFlyweights.put(flyweight.dId, flyweight);
        }
    }

    public static WeaponFactory getInstance() {
        if (mInstance == null) {
            JSONArray weaponData = (JSONArray)ResourceLoader.loadResource(ResourceType.ST_WEAPONS);
            mInstance = new WeaponFactory(weaponData);
        } return mInstance;
    }

    public WeaponFlyweight getFlyweightById(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Weapon. Invalid Weapon ID specified."
            );
        }
        return mFlyweights.get(id);
    }

    public Weapon build(int id) {
        WeaponFlyweight fw = getFlyweightById(id);
        return new Weapon(fw);
    }

    public Weapon build(int id, JSONObject stateData) {
        WeaponFlyweight fw = getFlyweightById(id);
        return new Weapon(fw, stateData);
    }

    public Iterator<WeaponFlyweight> getFlyweightsBySlot(WeaponSlot slot) {
        ArrayList<WeaponFlyweight> flyweights = new ArrayList<>();
        for (WeaponFlyweight fw : mFlyweights.values()) {
            if (fw.mWeaponSlot == slot) {
                flyweights.add(fw);
            }
        }
        return new FlyweightIterator<>(flyweights);
    }
}
