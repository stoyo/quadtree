package org.data.structures.trees;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

// TODO: TEST EXTENSIVELY
public class QuadTreeTest {

    @Test
    public void testQuery() {
        QuadTree quadTree = new QuadTree(new Rectangle(0, 0, 10_000, 10_000));
        Point eP1 = new Point(0, 0);
        Point eP2 = new Point(5_000, 5_000);
        Point eP3 = new Point(-5_000, -5_000);
        Point eP4 = new Point(5_000, -5_000);
        Point eP5 = new Point(-5_000, 5_000);
        Point eP6 = new Point(3283, 3287);
        Point eP7 = new Point(-328, -287);
        Point eP8 = new Point(-328, 287);
        Point eP9 = new Point(328, 287);
        Point eP10 = new Point(328, -287);

        quadTree.insert(eP1);
        quadTree.insert(eP2);
        quadTree.insert(eP3);
        quadTree.insert(eP4);
        quadTree.insert(eP5);
        quadTree.insert(eP6);
        quadTree.insert(eP7);
        quadTree.insert(eP8);
        quadTree.insert(eP9);
        quadTree.insert(eP10);

        quadTree.insert(new Point(5_001, 0));
        quadTree.insert(new Point(0, 5_001));
        quadTree.insert(new Point(6_000, 7_000));
        quadTree.insert(new Point(6_000, -7_000));
        quadTree.insert(new Point(-6_000, -7_000));
        quadTree.insert(new Point(-6_000, 7_000));

        List<Point> found = quadTree.query(new Rectangle(0, 0, 5_000, 5_000));
        Assert.assertEquals(10, found.size());
        Assert.assertThat(found,
                CoreMatchers.hasItems(eP1, eP2, eP3, eP4, eP5, eP6, eP7, eP8, eP9, eP10));
    }
}
