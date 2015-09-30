package nl.pluizer.pathfinder;

import java.util.ArrayList;

public class World {

    private int width, height;

    private ArrayList<Node> nodes = new ArrayList<>();

    /**
     * Creates a new world and initialises it with nodes, which are by
     * default reachable.
     * @param width     the width of the world.
     * @param height    the height of the world.
     */
    public World(int width, int height) {
        this.width  = width;
        this.height = height;
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++) {
                nodes.add(new Node(x, y, this));
            }
        }
    }

    /**
     * Returns the node at a specific location
     * @param x the x coordinate of the location
     * @param y the y coordinate of the location
     * @return  the the node a the specified location.
     */
    public Node get(int x, int y) {
        return (x < width && y < height && x >= 0 && y >= 0) ? nodes.get(x*height+y) : null;
    }

}
