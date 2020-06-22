package org.data.structures.trees;

public final class Rectangle {

    private final Point center;

    private final int halfWidth;
    private final int halfHeight;

    public Rectangle(double centerX, double centerY, int halfWidth, int halfHeight) {
        this(new Point(centerX, centerY), halfWidth, halfHeight);
    }

    public Rectangle(Point center, int halfWidth, int halfHeight) {
        this.center = center;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
    }

    public double getCenterX() {
        return center.getX();
    }

    public double getCenterY() {
        return center.getY();
    }

    public int getHalfWidth() {
        return halfWidth;
    }

    public int getHalfHeight() {
        return halfHeight;
    }

    public boolean contains(Point point) {
        return point.getX() >= center.getX() - halfWidth
                && point.getX() <= center.getX() + halfWidth
                && point.getY() >= center.getY() - halfHeight
                && point.getY() <= center.getY() + halfHeight;
    }

    public boolean intersects(Rectangle rectangle) {
        boolean dontIntersect = center.getX() + halfWidth < rectangle.center.getX() - rectangle.halfWidth
                || center.getX() - halfWidth > rectangle.center.getX() + rectangle.halfWidth
                || center.getY() + halfHeight < rectangle.center.getY() - rectangle.halfHeight
                || center.getY() - halfHeight > rectangle.center.getY() + rectangle.halfHeight;

        return !dontIntersect;
    }
}
