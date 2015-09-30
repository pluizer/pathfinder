package nl.pluizer.pathfinder;

/**
 * A nl.pluizer.pathfinder.Candidate wraps around a node that has the possibility of being part of the
 * path towards the targetNode.
 */
class Candidate {

    private Node node, parentNode, targetNode;

    public Candidate(Node node, Node parentNode, Node targetNode) {
        this.node = node;
        this.parentNode = parentNode;
        this.targetNode = targetNode;
    }

    /**
     * When nodes are square, traveling to a diagonal neighbour covers more distance than
     * traveling to a node directly next to it. The gScore is there to discourage traveling
     * diagonally.
     * @return  1.4f when travelling diagonally, else 1.0f
     */
    public float gScore() {
        return node.getX() == parentNode.getX() && node.getY() == parentNode.getY() ? 1.4f : 1.0f;
    }

    /**
     * Estimates a score for this candidate that signifies the probability that this node
     * is a good candidate for the path.
     * @return  The gScore of the node + the roughly estimated distance to the targetNode.
     */
    public float score() {
        float h = Math.abs(node.getX() - targetNode.getX()) + Math.abs(node.getY() - targetNode.getY());
        return gScore()+h;
    }

    public Node getNode() {
        return node;
    }

    public Node getParentNode() {
        return parentNode;
    }
}
