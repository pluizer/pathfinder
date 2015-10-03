package nl.pluizer.pathfinder.hex;

import nl.pluizer.pathfinder.Node;
import nl.pluizer.pathfinder.Pathfinder;
import nl.pluizer.pathfinder.Grid;
import nl.pluizer.pathfinder.GridTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HexGridTest extends GridTest {
    @Test
    public void testPath() {
        // Find a path in a square grid:
        Grid grid = new HexGrid(7, 5);
        grid.get(2, 1).setIsReachable(false);
        grid.get(3, 1).setIsReachable(false);
        grid.get(3, 2).setIsReachable(false);
        grid.get(3, 3).setIsReachable(false);
        grid.get(4, 3).setIsReachable(false);
        List<Node> path = Pathfinder.findPath(grid.get(2, 2), grid.get(5, 2));

        // The path we expect to get:
        List<Node> expected = new ArrayList<>();
        expected.add(new HexNode(2, 2, grid));
        expected.add(new HexNode(2, 3, grid));
        expected.add(new HexNode(3, 4, grid));
        expected.add(new HexNode(4, 4, grid));
        expected.add(new HexNode(5, 4, grid));
        expected.add(new HexNode(5, 3, grid));
        expected.add(new HexNode(5, 2, grid));

        assertTrue("Got a different path than expected", comparePaths(path, expected));
    }

    @Test
    public void testEmptyPath() {
        Grid grid = new HexGrid(7, 5);
        grid.get(2, 1).setIsReachable(false);
        List<Node> path = Pathfinder.findPath(grid.get(0, 0), grid.get(2, 1));

        assertNull("Got a path when there was no possible route", path);
    }

}