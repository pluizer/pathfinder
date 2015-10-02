package nl.pluizer.pathfinder;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pluizer on 02/10/15.
 */
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
        assertEquals("Path doesn't have the expected size", path.size(), expected.size());
        boolean equals = true;
        for (int i=0; i<path.size(); i++) {
            if (path.get(i).getX() != path.get(i).getX() || path.get(i).getY() != path.get(i).getY()) {
                equals  = false;
                break;
            }
        }
        assertTrue("Path is not the expected path.", equals);
    }
}