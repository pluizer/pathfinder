package nl.pluizer.pathfinder;

import java.util.Iterator;
import java.util.List;

public class GridTest {
    protected boolean comparePaths(List<Node> a, List<Node> b) {
        // If the lists are not of equal length, the lists can't be equal.
        if (a == null || b == null || a.size() != b.size()) return false;
        // Check if all nodes have the same coordinates.
        boolean equals = true;
        Iterator<Node> itA = a.iterator(), itB = b.iterator();
        while (itA.hasNext() && itB.hasNext()) {
            Node nodeA = itA.next(), nodeB = itB.next();
            if (nodeA.getX() != nodeB.getX() || nodeA.getY() != nodeB.getY()) {
                equals = false;
                break;
            }
        }
        return equals;
    }
}
