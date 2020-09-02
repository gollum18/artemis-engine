package com.ae.actors.humans;

import com.ae.actors.ActorFlyweight;
import com.ae.agents.CombatType;
import com.ae.agents.ProgressionType;
import com.ae.resources.ResourceDataKeys;
import org.json.JSONObject;

public class NPCFlyweight extends ActorFlyweight {
    public final int dFactionId;
    public final int dDropTableId;
    public final CombatType mCombatType;
    public final ProgressionType mProgressionType;

    public NPCFlyweight(JSONObject npcData) {
        super(npcData);
        dFactionId = npcData.getInt(ResourceDataKeys.KEY_FACTION);
        mCombatType = CombatType.valueOf(npcData.getString(ResourceDataKeys.KEY_COMBAT_TYPE));
        mProgressionType = ProgressionType.valueOf(npcData.getString(ResourceDataKeys.KEY_PROGRESSION_TYPE));
        dDropTableId = npcData.getInt(ResourceDataKeys.KEY_DROP_TABLE);
    }
}
