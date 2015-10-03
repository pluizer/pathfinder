package nl.pluizer.pathfinder;

import java.util.List;

/**
 * Nodes form the intersection points of a world.
 */
public abstract class Node {

    private int x, y;

    private World world;

    private boolean reachable = true;

    public Node(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    public abstract List<Node> adjacent();

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
        return reachable;
    }

    /**
     * Set this node to be reachable (true) or not (false).
     */
    public void setIsReachable(boolean isReachable) {
        this.reachable = isReachable;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }

    public World getWorld() {
        return world;
    }
}
