package org.data.structures.trees;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    @Test
    public void testDoesntContainIfOutsideOnLeftSide() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertFalse(rectangle.contains(new Point(-1_001, 0)));
    }

    @Test
    public void testDoesntContainIfOutsideOnRightSide() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertFalse(rectangle.contains(new Point(1_001, 0)));
    }

    @Test
    public void testDoesntContainIfOutsideAbove() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertFalse(rectangle.contains(new Point(0, 1_001)));
    }

    @Test
    public void testDoesntContainIfOutsideBelow() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertFalse(rectangle.contains(new Point(0, -1_001)));
    }

    @Test
    public void testContainsIfOnLeftBorder() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.contains(new Point(-1_000, 0)));
    }

    @Test
    public void testContainsIfOnRightBorder() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.contains(new Point(1_000, 0)));
    }

    @Test
    public void testContainsIfOnTopBorder() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.contains(new Point(0, 1_000)));
    }

    @Test
    public void testContainsIfOnBottomBorder() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.contains(new Point(0, -1_000)));
    }

    @Test
    public void testContainsInside() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.contains(new Point(500, 500)));
    }

    @Test
    public void testDoesntIntersectIfOutsideOnLeftSide() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertFalse(rectangle.intersects(new Rectangle(-2_001, 0, 1_000, 1_000)));
    }

    @Test
    public void testDoesntIntersectIfOutsideOnRightSide() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertFalse(rectangle.intersects(new Rectangle(2_001, 0, 1_000, 1_000)));
    }

    @Test
    public void testDoesntIntersectIfOutsideAbove() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertFalse(rectangle.intersects(new Rectangle(0, 2_001, 1_000, 1_000)));
    }

    @Test
    public void testDoesntIntersectIfOutsideBelow() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertFalse(rectangle.intersects(new Rectangle(0, -2_001, 1_000, 1_000)));
    }

    @Test
    public void testIntersectsIfLeftAndRightBordersOfRectanglesMatch() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.intersects(new Rectangle(-2_000, 0, 1_000, 1_000)));
    }

    @Test
    public void testIntersectsIfRightAndLeftBordersOfRectanglesMatch() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.intersects(new Rectangle(2_000, 0, 1_000, 1_000)));
    }

    @Test
    public void testIntersectsIfTopAndBottomBordersOfRectanglesMatch() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.intersects(new Rectangle(0, 2_000, 1_000, 1_000)));
    }

    @Test
    public void testIntersectsIfBottomAndTopBordersOfRectanglesMatch() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.intersects(new Rectangle(0, -2_000, 1_000, 1_000)));
    }

    @Test
    public void testIntersectsWhenIntersectionIsAnotherRectangle() {
        Rectangle rectangle = new Rectangle(0, 0, 1_000, 1_000);
        Assert.assertTrue(rectangle.intersects(new Rectangle(0, -1_000, 1_000, 1_000)));
    }
}
