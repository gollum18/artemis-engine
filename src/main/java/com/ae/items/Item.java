package com.ae.items;

import org.json.JSONObject;

public abstract class Item {
    public final ItemFlyweight mFlyweight;

    public Item(ItemFlyweight fw) { mFlyweight = fw; }

    public Item(ItemFlyweight fw, JSONObject stateData) {
        this(fw);
    }
}
