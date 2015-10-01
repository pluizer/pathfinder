package nl.pluizer.pathfinder;

/**
 * A Candidate wraps around a node that has the possibility of being part of the
 * path towards the targetNode.
 */
abstract class Candidate {

    private Node node, parentNode, targetNode;

    public Candidate(Node node, Node parentNode, Node targetNode) {
        this.node = node;
        this.parentNode = parentNode;
        this.targetNode = targetNode;
    }

    public abstract float gScore();

    public abstract float score();

    public Node getNode() {
        return node;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public Node getTargetNode() {
        return targetNode;
    }
}
