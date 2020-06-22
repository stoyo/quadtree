package org.data.structures.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Reference: https://en.wikipedia.org/wiki/Quadtree
public final class QuadTree {

    private static final int DEFAULT_CAPACITY = 4;

    private final int capacity;
    private boolean isSubdivided;
    private final Rectangle boundary;
    private final List<Point> points;

    private QuadTree nw;
    private QuadTree ne;
    private QuadTree se;
    private QuadTree sw;

    public QuadTree(Rectangle boundary) {
        this(boundary, DEFAULT_CAPACITY);
    }

    public QuadTree(Rectangle boundary, int capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        points = new ArrayList<>();
        isSubdivided = false;
    }

    public boolean insert(Point point) {
        if (!boundary.contains(point)) {
            return false;
        }

        if (points.size() < capacity) {
            return points.add(point);
        }

        if (!isSubdivided) {
            subdivide();
            // TODO: consider moving current node's points to children when subdividing completes
            // Thus only leaf nodes will have points
        }

        return nw.insert(point) || ne.insert(point) || se.insert(point) || sw.insert(point);
    }

    private void subdivide() {
        int halfWidth = boundary.getHalfWidth() / 2;
        int halfHeight = boundary.getHalfHeight() / 2;

        double westCenter = boundary.getCenterX() - halfWidth;
        double eastCenter = boundary.getCenterX() + halfWidth;
        double northCenter = boundary.getCenterY() + halfHeight;
        double southCenter = boundary.getCenterY() - halfHeight;

        Rectangle nwBoundary = new Rectangle(westCenter, northCenter, halfWidth, halfHeight);
        Rectangle neBoundary = new Rectangle(eastCenter, northCenter, halfWidth, halfHeight);
        Rectangle seBoundary = new Rectangle(eastCenter, southCenter, halfWidth, halfHeight);
        Rectangle swBoundary = new Rectangle(westCenter, southCenter, halfWidth, halfHeight);

        nw = new QuadTree(nwBoundary, capacity);
        ne = new QuadTree(neBoundary, capacity);
        se = new QuadTree(seBoundary, capacity);
        sw = new QuadTree(swBoundary, capacity);

        isSubdivided = true;
    }

    // TODO: if passed rectangle entirely contains current boundary consider simply adding all points
    public List<Point> query(Rectangle rectangle) {
        if (!boundary.intersects(rectangle)) {
            return Collections.emptyList();
        }

        List<Point> found = new ArrayList<>();
        points.stream()
                .filter(rectangle::contains)
                .forEach(found::add);

        if (isSubdivided) {
            found.addAll(nw.query(rectangle));
            found.addAll(ne.query(rectangle));
            found.addAll(se.query(rectangle));
            found.addAll(sw.query(rectangle));
        }

        return found;
    }
}
