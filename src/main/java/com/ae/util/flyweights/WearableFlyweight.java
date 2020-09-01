package com.ae.util.flyweights;

import com.ae.items.ItemRarity;
import com.ae.resources.ResourceDataKeys;
import org.json.JSONObject;

public abstract class WearableFlyweight extends Flyweight {
    public final ItemRarity mRarity;
    public final int dWeight;
    public final int dDurability;
    public final int dStrengthRequirement;
    public final int dDexterityRequirement;
    public final int dIntelligenceRequirement;
    public final int dFaithRequirement;

    public WearableFlyweight(JSONObject wearableData) {
        super(wearableData);
        mRarity = ItemRarity.valueOf(wearableData.getString(ResourceDataKeys.KEY_RARITY));
        dWeight = wearableData.getInt(ResourceDataKeys.KEY_WEIGHT);
        dDurability = wearableData.getInt(ResourceDataKeys.KEY_DURABILITY);
        dStrengthRequirement = wearableData.getInt(ResourceDataKeys.KEY_STR_REQUIREMENT);
        dDexterityRequirement = wearableData.getInt(ResourceDataKeys.KEY_DEX_REQUIREMENT);
        dIntelligenceRequirement = wearableData.getInt(ResourceDataKeys.KEY_INT_REQUIREMENT);
        dFaithRequirement = wearableData.getInt(ResourceDataKeys.KEY_FAITH_REQUIREMENT);
    }
}
