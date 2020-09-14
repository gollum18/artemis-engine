package com.ae.actors;

import com.ae.util.BoundingBox;
import com.ae.util.Collidable;
import com.ae.util.Entity;
import org.json.JSONObject;

public abstract class Actor extends Entity implements Collidable {
    public Actor(ActorFlyweight fw) { super(fw); }

    public Actor(ActorFlyweight fw, JSONObject stateData) {
        super(fw, stateData);
    }

    @Override
    public BoundingBox getBoundingBox() {
        // TODO: Implement me
        return null;
    }
}
