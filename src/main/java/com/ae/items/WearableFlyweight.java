package com.ae.items;

import com.ae.items.ItemRarity;
import com.ae.resources.ResourceDataKeys;
import com.ae.util.Flyweight;
import org.json.JSONObject;

public abstract class WearableFlyweight extends ItemFlyweight {
    public final int dMaxDurability;
    public final int dStrengthRequirement;
    public final int dDexterityRequirement;
    public final int dIntelligenceRequirement;
    public final int dFaithRequirement;

    public WearableFlyweight(JSONObject wearableData) {
        super(wearableData);
        dMaxDurability = wearableData.getInt(ResourceDataKeys.KEY_MAX_DURABILITY);
        dStrengthRequirement = wearableData.getInt(ResourceDataKeys.KEY_STR_REQUIREMENT);
        dDexterityRequirement = wearableData.getInt(ResourceDataKeys.KEY_DEX_REQUIREMENT);
        dIntelligenceRequirement = wearableData.getInt(ResourceDataKeys.KEY_INT_REQUIREMENT);
        dFaithRequirement = wearableData.getInt(ResourceDataKeys.KEY_FAITH_REQUIREMENT);
    }
}
