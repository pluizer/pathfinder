package nl.pluizer.pathfinder.hex;

import nl.pluizer.pathfinder.Candidate;
import nl.pluizer.pathfinder.Node;

public class HexCandidate extends Candidate {

    public HexCandidate(Node node, Node parentNode, Node targetNode) {
        super(node, parentNode, targetNode);
    }

    /**
     * Hexagonal shaped tiles are preferred in many situations because all
     * its neighbours are at an equal distance.
     * This is why for a hexagonal tile, the gScore does not matter and
     * will always return 0 here.
     * @return  0
     */
    @Override
    public float gScore() {
        return  0;
    }

    /**
     * Estimates a score for this candidate that signifies the probability that this node
     * is a good candidate for the path.
     * @return  The gScore of the node + the roughly estimated distance to the targetNode.
     */
    @Override
    public float score() {
        float dX = getNode().getX() - getTargetNode().getX();
        float dY = getNode().getY() - getTargetNode().getY();

        // Is the sign of the delta equal?
        if (dX >= 0 && dY >= 0 || dX < 0 && dY < 0) {
            return gScore() + Math.abs(dX + dY);
        }
        return gScore() + Math.max(Math.abs(dX), Math.abs(dY));
    }
}
