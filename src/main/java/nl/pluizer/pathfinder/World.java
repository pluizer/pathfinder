package nl.pluizer.pathfinder;

/**
 * A World is responsible for the storing and retrieving of nodes.
 */
public interface World {
    Node get(int x, int y);
}
