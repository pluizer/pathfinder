package nl.pluizer.pathfinder.hex;

import nl.pluizer.pathfinder.Node;
import nl.pluizer.pathfinder.Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * A Hex node has neighbours in 6(hex) directions.
 *   0 1
 * 2  x  3
 *   4 5
 */
public class HexNode extends Node {

    public HexNode(int x, int y, Grid grid) {
        super(x, y, grid);
    }

    /**
     * Returns a list of all nodes adjacent to this one.
     * @return  a list of nodes adjacent to this one.
     */
    @Override
    public List<Node> adjacent() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(getGrid().get(getX(), getY()-1));
        nodes.add(getGrid().get(getX()+1, getY()));
        nodes.add(getGrid().get(getX()+1, getY()+1));
        nodes.add(getGrid().get(getX(), getY()+1));
        nodes.add(getGrid().get(getX()-1, getY()+1));
        nodes.add(getGrid().get(getX()-1, getY()));
        // Remove the nodes that where outside of the world, and thus returned null.
        while(nodes.remove(null));
        return nodes;
    }

}
