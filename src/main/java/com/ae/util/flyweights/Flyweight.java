package com.ae.util.flyweights;

import com.ae.resources.ResourceDataKeys;
import org.json.JSONObject;

/**
 *
 */
public abstract class Flyweight {
    public final int dId;
    public final String sName;
    public final String sDescription;

    public Flyweight(JSONObject flyweightData) {
        if (flyweightData == null) {
            throw new IllegalArgumentException(
                    "Error: Cannot instantiate ArmorFlyweight. Armor data container is null."
            );
        }
        dId = flyweightData.getInt(ResourceDataKeys.KEY_ID);
        sName = flyweightData.getString(ResourceDataKeys.KEY_NAME);
        sDescription = flyweightData.getString(ResourceDataKeys.KEY_DESCRIPTION);
    }
}
