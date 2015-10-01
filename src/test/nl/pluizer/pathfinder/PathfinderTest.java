package nl.pluizer.pathfinder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PathfinderTest {

    @Test
    public void testFindPath() throws Exception {
        World world = new SquareWorld(7, 5);
        world.get(2, 1).setIsReachable(false);
        world.get(3, 1).setIsReachable(false);
        world.get(3, 2).setIsReachable(false);
        world.get(3, 3).setIsReachable(false);
        world.get(4, 3).setIsReachable(false);
        List<Node> path = Pathfinder.findPath(world.get(2, 2), world.get(5, 2));
        for (Node node : path) {
            System.out.println(node);
        }

        List<Node> expected = new ArrayList<>();
        expected.add(new SquareNode(2, 2, world));
        expected.add(new SquareNode(1, 1, world));
        expected.add(new SquareNode(2, 0, world));
        expected.add(new SquareNode(3, 0, world));
        expected.add(new SquareNode(4, 1, world));
        expected.add(new SquareNode(5, 2, world));

        assert(path.equals(expected));
    }
}