package com.ae.actors.humans;

import com.ae.agents.CombatType;
import com.ae.agents.ProgressionType;
import com.ae.resources.ResourceDataKeys;
import com.ae.util.flyweights.Flyweight;
import org.json.JSONObject;

public class NPCFlyweight extends Flyweight {
    private final int dId;
    private final int dFactionId;
    private final int dDropTableId;
    private final CombatType mCombatType;
    private final ProgressionType mProgressionType;
    private final String sName;
    private final String sDescription;

    public NPCFlyweight(JSONObject npcData) {
        dId = npcData.getInt(ResourceDataKeys.KEY_ID);
        sName = npcData.getString(ResourceDataKeys.KEY_NAME);
        dFactionId = npcData.getInt(ResourceDataKeys.KEY_FACTION);
        mCombatType = CombatType.valueOf(npcData.getString(ResourceDataKeys.KEY_COMBAT_TYPE));
        mProgressionType = ProgressionType.valueOf(npcData.getString(ResourceDataKeys.KEY_PROGRESSION_TYPE));
        dDropTableId = npcData.getInt(ResourceDataKeys.KEY_DROP_TABLE);
        sDescription = npcData.getString(ResourceDataKeys.KEY_DESCRIPTION);
    }

    public int getId() { return dId; }

    public int getFactionId() { return dFactionId; }

    public int getDropTableId() { return dDropTableId; }

    public CombatType getCombatType() { return mCombatType; }

    public ProgressionType getProgressionType() { return mProgressionType; }

    public String getName() { return sName; }

    public String getDescription() { return sDescription; }
}
