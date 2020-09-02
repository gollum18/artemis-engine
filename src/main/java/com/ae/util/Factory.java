package com.ae.util;

import org.json.JSONObject;

public interface Factory {
    // Gets a flyweight by ID from the Factory
    Flyweight getFlyweightById(int id);
    // New object constructor
    Object build(int id);
    // Save-state object constructor
    Object build(int id, JSONObject save);
}
