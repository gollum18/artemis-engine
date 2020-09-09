package com.ae.util;

public class BoundingBox {
    public static final double DEFAULT_RADIUS = 0.5f;
    public static final double DEFAULT_EPSILON = 0.05f;

    private int dX;
    private int dY;
    private final double fWidthRadius;
    private final double fLengthRadius;

    public BoundingBox(int x, int y) {
        this(x, y, DEFAULT_RADIUS, DEFAULT_RADIUS);
    }

    public BoundingBox(int x, int y, double radius) {
        this(x, y, radius, radius);
    }

    public BoundingBox(int x, int y, double widthRadius, double lengthRadius) {
        dX = x;
        dY = y;
        fWidthRadius = widthRadius;
        fLengthRadius = lengthRadius;
    }

    public int getX() { return dX; }

    public void setX(int x) { dX = x; }

    public int getY() { return dY; }

    public void setY(int y) { dY = y; }

    public double getWidthRadius() { return fWidthRadius; }

    public double getLengthRadius() { return fLengthRadius; }

    public boolean collides(BoundingBox box) { return collides(this, box, DEFAULT_EPSILON); }

    public boolean collides(BoundingBox box, double epsilon) { return collides(this, box, epsilon); }

    public static boolean collides(BoundingBox b1, BoundingBox b2) { return collides(b1, b2, DEFAULT_EPSILON); }

    public static boolean collides(BoundingBox b1, BoundingBox b2, double epsilon) {
        // For now, just check if any of the four corners of b2 fall in b1
        int bx=b2.getX(), by=b2.getY();
        double bw=b2.getWidthRadius(), bl=b2.getLengthRadius();

        // TODO: This checking can be refactored to reduce the number of checks necessary
        return (pointInBox(bx-bw, by-bl, b1, epsilon) ||    // Top-left
                pointInBox(bx+bw, by-bl, b1, epsilon) ||    // Top-right
                pointInBox(bx-bw, by+bl, b1, epsilon) ||    // Bottom-left
                pointInBox(bw+bw, by+bl, b1, epsilon));     // Bottom-right
    }

    private static boolean pointInBox(double x, double y, BoundingBox box, double epsilon) {
        int bx=box.getX(), by=box.getY();
        double bw=box.getWidthRadius(), bl=box.getLengthRadius();

        // TODO: Incorporate epsilon as well
        // Note that this will increase the number of checks to 8 as we need to do +-
        //  for all 4 original checks
        return (x >= bx-bw && x <= bx+bw && y >= by-bl && y <= by+bl);
    }
}
