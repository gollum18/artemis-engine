package com.ae.util;

/* TODO:
 *  Generalize the tree to an N-ary tree.
 */

import java.util.List;

/**
 * Implements a quad tree for checking for collisions. At each ply, a CollisionTree splits it's search space into
 * 4 regions with the same width and height. This is done until the resulting region falls within a bounding
 * threshold at which the tree is constructed and entities may be added.
 * @author Christen Ford
 * @since 09/08/2020
 */
public class CollisionTree {
    public static final double BOUNDING_THRESHOLD = 0.25;

    private final CollisionNode mRoot;

    public CollisionTree(int x, int y, int length, int width) {
        this(x, y, length, width, BOUNDING_THRESHOLD);
    }

    public CollisionTree(int x, int y, int length, int width, double threshold) {
        mRoot = new CollisionNode(x, y, length, width, (int) (length * width * threshold));
    }

    public void add(BoundingBox box) { mRoot.add(box); }

    public List<BoundingBox> collisionList(BoundingBox box) {
        return mRoot.collisionList(box);
    }

    public boolean has(BoundingBox box) { return mRoot.has(box); }

    public void remove(BoundingBox box) { mRoot.remove(box); }
}
