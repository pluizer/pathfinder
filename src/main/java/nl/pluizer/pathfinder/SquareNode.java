package nl.pluizer.pathfinder;

import java.util.List;
import java.util.ArrayList;

public class SquareNode extends Node {

    public SquareNode(int x, int y, World world) {
        super(x, y, world);
    }

    /**
     * Returns a list of all nodes adjacent to this one.
     * @return  a list of nodes adjacent to this one.
     */
    @Override
    public List<Node> adjacent() {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(getWorld().get(getX() - 1, getY() - 1));
        nodes.add(getWorld().get(getX(), getY() - 1));
        nodes.add(getWorld().get(getX() + 1, getY() - 1));
        nodes.add(getWorld().get(getX() + 1, getY()));
        nodes.add(getWorld().get(getX() + 1, getY() + 1));
        nodes.add(getWorld().get(getX(), getY() + 1));
        nodes.add(getWorld().get(getX() - 1, getY() + 1));
        nodes.add(getWorld().get(getX() - 1, getY()));
        // Remove the nodes that where outside of the world, and thus returned null.
        while(nodes.remove(null));
        return nodes;
    }

}
