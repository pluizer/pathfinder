package nl.pluizer.pathfinder;

import java.util.*;

/**
 * The nl.pluizer.pathfinder.NodeList keeps track of all nodes that still need to be processed and nodes
 * that are done being processed.
 */
class NodeList {

    // A collection of candidate nodes still needed to be processed, sorted
    // by there score.
    private SortedSet<Candidate> openList = new TreeSet<Candidate>(
            (a, b) -> {
                float aS = a.score(), bS = b.score();
                return aS < bS ? -1 : aS == bS ? 0 : 1;
            }
    );

    // A collection of candidate nodes already processed.
    private List<Candidate> closedList = new ArrayList<>();

    private Node startNode, targetNode;

    public NodeList(Node startNode, Node targetNode) {
        this.startNode = startNode;
        this.targetNode = targetNode;
        openList.add(new SquareCandidate(startNode, startNode, targetNode));
    }

    /**
     * Returns the candidate with the lowest score.
     */
    public Candidate firstCandidate() {
        return openList.first();
    }

    public void add(Node node, Node parentNode, Node targetNode) {
        Candidate candidate = findCandidate(node, openList);
        if (candidate == null) {
            // Add the node to the openList if it isn't already ...
            openList.add(new SquareCandidate(node, parentNode, targetNode));
        } else {
            // ... else check if the new node forms a better path and replace it if so.
            Candidate newCandidate = new SquareCandidate(node, parentNode, targetNode);
            if (newCandidate.gScore() < candidate.gScore()) {
                openList.remove(candidate);
                openList.add(newCandidate);
            }
        }
    }

    public void switchToClosed(Candidate candidate) {
        openList.remove(candidate);
        closedList.add(candidate);
    }

    private Candidate findCandidate(Node node, Collection<Candidate> list) {
        for (Candidate candidate : list) {
            if (candidate.getNode() == node) return candidate;
        }
        return null;
    }

    public boolean contains(Node node) {
        Candidate candidate = findCandidate(node, closedList);
        return candidate != null && closedList.contains(candidate);
    }

    /**
     * Processes the closedList to create a path from it.
     * @return  A list of nodes that make up a found path or null if no path is found.
     */
    public List<Node> createPath() {
        Candidate candidate = findCandidate(targetNode, closedList);
        if (candidate == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        while (candidate.getNode() != startNode) {
            candidate = findCandidate(candidate.getParentNode(), closedList);
            nodes.add(candidate.getNode());
        }
        // We have the path now, but backwards ...
        Collections.reverse(nodes);
        // Also the targetNode is not part of the path yet.
        nodes.add(targetNode);
        return nodes;
    }
}
