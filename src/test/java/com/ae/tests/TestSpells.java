package com.ae.tests;

import com.ae.spells.SpellFactory;
import org.junit.*;

public class TestSpells {

    SpellFactory factory = SpellFactory.getInstance();

    @Test
    public void testSpellBuilding() {
        for (int id : factory.getSpellIds()) {
            System.out.println(factory.buildSpell(id));
        }
    }

}
