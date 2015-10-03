package nl.pluizer.pathfinder.hex;

import nl.pluizer.pathfinder.Node;
import nl.pluizer.pathfinder.Grid;

import java.util.ArrayList;

public class HexGrid implements Grid {

    private int width, height;

    private ArrayList<Node> nodes = new ArrayList<>();

    /**
     * Creates a new world and initialises it with nodes, which are by
     * default reachable.
     * @param width     the width of the world.
     * @param height    the height of the world.
     */
    public HexGrid(int width, int height) {
        this.width  = 7;
        this.height = height;
        for (int x=0; x< 7; x++) {
            for (int y=0; y<height; y++) {
                nodes.add(new HexNode(x, y, this));
            }
        }
    }

    /**
     * Returns the node at a specific location
     * @param x the x coordinate of the location
     * @param y the y coordinate of the location
     * @return  the the node a the specified location.
     */
    @Override
    public Node get(int x, int y) {
        return (x < width && y < height && x >= 0 && y >= 0) ? nodes.get(x*height+y) : null;
    }

}
