package com.ae.util;

import org.json.JSONObject;

public interface Factory<F extends Flyweight, E extends Entity> {
    // Gets a flyweight by ID from the Factory
    F getFlyweightById(int id);
    // New object constructor
    E build(int id);
    // New scaled object constructor
    E build(int id, int gs);
    // Save-state object constructor
    E build(int id, JSONObject save);
}
