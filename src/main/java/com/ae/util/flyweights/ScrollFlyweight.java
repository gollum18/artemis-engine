package com.ae.util.flyweights;

import org.json.JSONObject;

public class ScrollFlyweight extends ConsumableFlyweight {
    public ScrollFlyweight(JSONObject scrollData) {
        super(scrollData);
    }
}