package com.ae.items;

import com.ae.resources.ResourceDataKeys;
import com.ae.util.Flyweight;
import org.json.JSONObject;

public class ItemFlyweight extends Flyweight {
    public final ItemRarity mRarity;
    public final int dWeight;

    public ItemFlyweight(JSONObject itemData) {
        super(itemData);
        mRarity = itemData.getEnum(ItemRarity.class, ResourceDataKeys.KEY_RARITY);
        dWeight = itemData.getInt(ResourceDataKeys.KEY_WEIGHT);
    }
}
