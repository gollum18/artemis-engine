package com.ae.items.consumables;

import org.json.JSONObject;

public class ScrollFlyweight {
    private final int dId;
    private final String sName;

    public ScrollFlyweight(JSONObject scrollData) {
        dId = scrollData.getInt(ScrollDataKeys.SCROLL_ID);
        sName = scrollData.getString(ScrollDataKeys.SCROLL_NAME);
    }

    public int getId() { return dId; }

    public String getName() { return sName; }
}
