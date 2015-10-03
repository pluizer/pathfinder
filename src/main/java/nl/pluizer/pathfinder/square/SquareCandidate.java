package nl.pluizer.pathfinder.square;

import nl.pluizer.pathfinder.Candidate;
import nl.pluizer.pathfinder.Node;

public class SquareCandidate extends Candidate {

    public SquareCandidate(Node node, Node parentNode, Node targetNode) {
        super(node, parentNode, targetNode);
    }

    /**
     * When nodes are square, traveling to a diagonal neighbour covers more distance than
     * traveling to a node directly next to it. The gScore is there to discourage traveling
     * diagonally.
     * @return  1.4f when travelling diagonally, else 1.0f
     */
    @Override
    public float gScore() {
        return  getNode().getX() == getParentNode().getX() &&
                getNode().getY() == getParentNode().getY() ? 1.4f : 1.0f;
    }

    /**
     * Estimates a score for this candidate that signifies the probability that this node
     * is a good candidate for the path.
     * @return  The gScore of the node + the roughly estimated distance to the targetNode.
     */
    @Override
    public float score() {
        float h = Math.abs(getNode().getX() - getTargetNode().getX())
                + Math.abs(getNode().getY() - getTargetNode().getY());
        return gScore()+h;
    }
}
