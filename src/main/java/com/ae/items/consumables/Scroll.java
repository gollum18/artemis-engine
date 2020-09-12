package com.ae.items.consumables;

import org.json.JSONObject;

public class Scroll extends Consumable {
    public Scroll(ScrollFlyweight fw) {
        super(fw);
    }

    public Scroll(ScrollFlyweight fw, JSONObject stateData) { super(fw, stateData); }

    public ScrollFlyweight getFlyweight() { return (ScrollFlyweight) mFlyweight; }
}
