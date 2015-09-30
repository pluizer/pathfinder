package nl.pluizer.pathfinder;

import java.util.List;
import java.util.ArrayList;

public class Node {

    private int x, y;

    private boolean isReachable = true;

    private World world;

    public Node(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    /**
     * Returns a list of all nodes adjacent to this one.
     * @return  a list of nodes adjacent to this one.
     */
    public List<Node> adjacent() {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(world.get(x - 1, y - 1));
        nodes.add(world.get(x, y - 1));
        nodes.add(world.get(x + 1, y - 1));
        nodes.add(world.get(x + 1, y));
        nodes.add(world.get(x + 1, y + 1));
        nodes.add(world.get(x, y + 1));
        nodes.add(world.get(x - 1, y + 1));
        nodes.add(world.get(x - 1, y));
        // Remove the nodes that where outside of the world, and thus returned null.
        while(nodes.remove(null));
        return nodes;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Returns if this specific node is reachable i.e. can be part of the path.
     */
    public boolean isReachable() {
        return isReachable;
    }

    /**
     * Set this node to be reachable (true) or not (false).
     */
    public void setIsReachable(boolean isReachable) {
        this.isReachable = isReachable;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}
