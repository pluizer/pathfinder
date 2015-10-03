package nl.pluizer.pathfinder.square;

import nl.pluizer.pathfinder.Grid;
import nl.pluizer.pathfinder.Node;

import java.util.List;
import java.util.ArrayList;

/**
 * A Square node has neighbours in 8 directions.
 * 0 1 2
 * 3 X 4
 * 5 6 7
 */
public class SquareNode extends Node {

    public SquareNode(int x, int y, Grid grid) {
        super(x, y, grid);
    }

    /**
     * Returns a list of all nodes adjacent to this one.
     * @return  a list of nodes adjacent to this one.
     */
    @Override
    public List<Node> adjacent() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(getGrid().get(getX() - 1, getY() - 1));
        nodes.add(getGrid().get(getX(), getY() - 1));
        nodes.add(getGrid().get(getX() + 1, getY() - 1));
        nodes.add(getGrid().get(getX() + 1, getY()));
        nodes.add(getGrid().get(getX() + 1, getY() + 1));
        nodes.add(getGrid().get(getX(), getY() + 1));
        nodes.add(getGrid().get(getX() - 1, getY() + 1));
        nodes.add(getGrid().get(getX() - 1, getY()));
        // Remove the nodes that where outside of the world, and thus returned null.
        while(nodes.remove(null));
        return nodes;
    }

}
