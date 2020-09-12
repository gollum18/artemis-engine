package com.ae.util;

import java.util.HashSet;
import java.util.List;

/* TODO:
 *  Look into possibly using floating point arithmetic for the box calculation. Integer division creates oddities
 *  in the way the regions are divided up that may make some entities in those regions not fall into any of
 *  them.
 */

/**
 * Represents a node in the CollisionTree structure.
 * @author Christen Ford
 * @since 09/08/2020
 */
public class CollisionNode {
    private final int dXOrigin;
    private final int dYOrigin;
    private final int dLength;
    private final int dWidth;
    private final CollisionNode[] mChildren;
    private final HashSet<BoundingBox> mBoundingBoxs;

    public CollisionNode(int x, int y, int length, int width, int dThresholdArea) {
        dXOrigin = x;
        dYOrigin = y;
        dLength = length;
        dWidth = width;
        // Keep subdividing until the box of the region is less than or equal to the
        //  threshold box
        if (dLength * dWidth >= dThresholdArea) {
            mChildren = generateChildren(dThresholdArea);
            mBoundingBoxs = null;
        } else {
            mChildren = null;
            mBoundingBoxs = new HashSet<>();
        }
    }

    private CollisionNode[] generateChildren(int thresholdArea) {
        CollisionNode[] children = new CollisionNode[4];
        int nl = dLength / 2;
        int nw = dWidth / 2;
        children[0] = new CollisionNode(dXOrigin, dYOrigin, nl, nw, thresholdArea);
        children[1] = new CollisionNode(dXOrigin + nl, dYOrigin, nl, nw, thresholdArea);
        children[2] = new CollisionNode(dXOrigin, dYOrigin + nw, nl, nw, thresholdArea);
        children[3] = new CollisionNode(dXOrigin + nl, dYOrigin + nw, nl, nw, thresholdArea);
        return children;
    }

    private boolean isLeafNode() { return mChildren == null; }

    private boolean isContainedIn(BoundingBox box) {
        if (box.getX() < dXOrigin || box.getX() >= dXOrigin + dLength) {
            return false;
        }
        return !(box.getY() < dYOrigin && box.getY() >= dYOrigin + dWidth);
    }

    public boolean add(BoundingBox box) {
        // short circuit add operation
        if (!isContainedIn(box)) { return false; }
        if (isLeafNode()) {
            mBoundingBoxs.add(box);
            return true;
        }
        else {
            for (CollisionNode child : mChildren) {
                if (child.add(box)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<BoundingBox> collisionList(BoundingBox box) {
        // TODO: Implement me
        return null;
    }

    public boolean has(BoundingBox box) {
        if (isLeafNode()) {
            return mBoundingBoxs.contains(box);
        }
        for (CollisionNode mChild : mChildren) {
            if (mChild.has(box)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(BoundingBox box) {
        // short circuit remove operation
        if (isContainedIn(box)) { return false; }
        if (isLeafNode()) {
            mBoundingBoxs.remove(box);
            return true;
        }
        else {
            for (CollisionNode child : mChildren) {
                if (child.remove(box)) {
                    return true;
                }
            }
            return false;
        }
    }
}
