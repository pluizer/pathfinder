package nl.pluizer.pathfinder.hex;

import nl.pluizer.pathfinder.Node;
import nl.pluizer.pathfinder.Pathfinder;
import nl.pluizer.pathfinder.World;
import nl.pluizer.pathfinder.WorldTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HexWorldTest extends WorldTest{
    @Test
    public void testPath() {
        // Find a path in a square world:
        World world = new HexWorld(7, 5);
        world.get(2, 1).setIsReachable(false);
        world.get(3, 1).setIsReachable(false);
        world.get(3, 2).setIsReachable(false);
        world.get(3, 3).setIsReachable(false);
        world.get(4, 3).setIsReachable(false);
        List<Node> path = Pathfinder.findPath(world.get(2, 2), world.get(5, 2));

        // The path we expect to get:
        List<Node> expected = new ArrayList<>();
        expected.add(new HexNode(2, 2, world));
        expected.add(new HexNode(2, 3, world));
        expected.add(new HexNode(3, 4, world));
        expected.add(new HexNode(4, 4, world));
        expected.add(new HexNode(5, 4, world));
        expected.add(new HexNode(5, 3, world));
        expected.add(new HexNode(5, 2, world));

        assertTrue("Got a different path than expected", comparePaths(path, expected));
    }

    @Test
    public void testEmptyPath() {
        World world = new HexWorld(7, 5);
        world.get(2, 1).setIsReachable(false);
        List<Node> path = Pathfinder.findPath(world.get(0, 0), world.get(2, 1));

        assertNull("Got a path when there was no possible route", path);
    }

}