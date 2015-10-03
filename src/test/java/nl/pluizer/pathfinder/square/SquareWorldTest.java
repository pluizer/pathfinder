package nl.pluizer.pathfinder.square;

import nl.pluizer.pathfinder.Node;
import nl.pluizer.pathfinder.Pathfinder;
import nl.pluizer.pathfinder.World;

import nl.pluizer.pathfinder.WorldTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SquareWorldTest extends WorldTest {

    @Test
    public void testPath() {
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

        assertTrue("Got a different path than expected", comparePaths(path, expected));
    }

    @Test
    public void testEmptyPath() {
        World world = new SquareWorld(7, 5);
        world.get(2, 1).setIsReachable(false);
        List<Node> path = Pathfinder.findPath(world.get(0, 0), world.get(2, 1));

        assertNull("Got a path when there was no possible route", path);
    }

}