package com.ae.actors.humans;

import com.ae.util.flyweights.NPCFlyweight;

public class NPC extends Human {
    private final NPCFlyweight mFlyweight;
    
    public NPC(NPCFlyweight flyweight) {
        mFlyweight = flyweight;
    }
    
    public NPCFlyweight getFlyweight() { return mFlyweight; }
}
