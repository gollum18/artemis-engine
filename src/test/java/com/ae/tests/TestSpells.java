package com.ae.tests;

import com.ae.spells.Spell;
import com.ae.spells.SpellFactory;
import org.junit.*;

import java.util.LinkedList;

public class TestSpells {

    SpellFactory factory = SpellFactory.getInstance();

    @Test
    public void testSpellBuilding() {
        LinkedList<Spell> spells = new LinkedList<>();
        for (Integer key : factory.spellKeys()) {
            spells.add(factory.buildSpell(key));
        }
        Assert.assertEquals(factory.spellKeys().size(), spells.size());
    }

}
