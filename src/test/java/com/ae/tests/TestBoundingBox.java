package com.ae.tests;

import com.ae.util.BoundingBox;
import org.junit.*;

public class TestBoundingBox {
    @Test
    public void testIntersection () {
        BoundingBox b1 = new BoundingBox(0, 0, 50, 50);
        BoundingBox b2 = new BoundingBox(25, 25, 50, 50);
        Assert.assertTrue(b1.collides(b2));
    }

    @Test
    public void testNoIntersection() {
        BoundingBox b1 = new BoundingBox(0, 0, 50, 50);
        BoundingBox b2 = new BoundingBox(200, 200, 50, 50);
        Assert.assertFalse(b1.collides(b2));
    }
}
