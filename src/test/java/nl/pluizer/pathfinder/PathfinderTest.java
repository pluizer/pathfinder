package nl.pluizer.pathfinder;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PathfinderTest extends TestCase {

    public void testFindPath() throws Exception {

        // Find a path in a square world:
        World world = new SquareWorld(7, 5);
        world.get(2, 1).setIsReachable(false);
        world.get(3, 1).setIsReachable(false);
        world.get(3, 2).setIsReachable(false);
        world.get(3, 3).setIsReachable(false);
        world.get(4, 3).setIsReachable(false);
        List<Node> path = Pathfinder.findPath(world.get(2, 2), world.get(5, 2));

        // The path we expect to get:
        List<Node> expected = new ArrayList<>();
        expected.add(new SquareNode(2, 2, world));
        expected.add(new SquareNode(1, 1, world));
        expected.add(new SquareNode(2, 0, world));
        expected.add(new SquareNode(3, 0, world));
        expected.add(new SquareNode(4, 1, world));
        expected.add(new SquareNode(5, 2, world));

        // Check if we got the same path:
        assertNotNull("Cannot find a path while there is one", path);
        assertEquals("Path doesn't have the expected size", path.size(), expected.size());
        boolean equals = true;
        Iterator<Node> itA = path.iterator(), itB = path.iterator();
        while (itA.hasNext() && itB.hasNext()) {
            Node a = itA.next(), b = itB.next();
            if (a.getX() != b.getX() || a.getY() != b.getY()) {
                equals = false;
                break;
            }
        }
        assertTrue("Path is not the expected path.", equals);
    }
}