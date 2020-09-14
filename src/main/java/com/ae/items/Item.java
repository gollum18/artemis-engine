package com.ae.items;

import com.ae.util.Entity;
import org.json.JSONObject;

public abstract class Item extends Entity {

    public Item(ItemFlyweight fw) {
        super(fw);
    }

    public Item(ItemFlyweight fw, JSONObject stateData) {
        super(fw, stateData);
    }

}
