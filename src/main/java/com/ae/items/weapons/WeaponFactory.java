package com.ae.items.weapons;

import com.ae.resources.ResourceLoader;
import com.ae.resources.ResourceType;
import com.ae.util.flyweights.FlyweightIterator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class WeaponFactory {
    private static WeaponFactory mInstance;
    private final HashMap<Integer, WeaponFlyweight> mFlyweights;

    private WeaponFactory(JSONArray weaponData) {
        mFlyweights = new HashMap<>();
        for (Object weaponDatum : weaponData) {
            JSONObject object = (JSONObject) weaponDatum;
            WeaponFlyweight flyweight = new WeaponFlyweight(object);
            mFlyweights.put(flyweight.getId(), flyweight);
        }
    }

    public static WeaponFactory getInstance() {
        if (mInstance == null) {
            JSONArray weaponData = (JSONArray)ResourceLoader.loadResource(ResourceType.ST_WEAPONS);
            mInstance = new WeaponFactory(weaponData);
        } return mInstance;
    }

    public Weapon buildWeapon(int id) {
        if (!mFlyweights.containsKey(id)) {
            throw new IllegalArgumentException(
                "Error: Cannot instantiate Weapon. Invalid Weapon ID specified."
            );
        }
        WeaponFlyweight flyweight = mFlyweights.get(id);
        return new Weapon(flyweight);
    }

    public Iterator<WeaponFlyweight> getFlyweightsBySlot(WeaponSlot slot) {
        ArrayList<WeaponFlyweight> flyweights = new ArrayList<>();
        for (WeaponFlyweight fw : mFlyweights.values()) {
            if (fw.getWeaponSlot() == slot) {
                flyweights.add(fw);
            }
        }
        return new FlyweightIterator<>(flyweights);
    }
}
