package nl.pluizer.pathfinder;

import java.util.List;

/**
 * A simple implementation of the A* pathfinder algorithm.
 */
class Pathfinder {

    /**
     * Returns a list of nodes that make up the shortest possible path
     * between startNode and targetNode.
     * @param startNode     The node where to start looking for a path from.
     * @param targetNode    The node where to start looking for a path to.
     * @return              A list that makes up the shortest path or null
     *                      if no path between startNode and targetNode was found.
     */
    public static List<Node> findPath(Node startNode, Node targetNode) {
        NodeList nodeList = new NodeList(startNode, targetNode);

        for (;;) {
            // Get the candidate with the lowest score, if there isn't one it
            // means that there is no path to the targetNode.
            Candidate candidate = nodeList.firstCandidate();
            if (candidate == null) {
                // Could not find a path :(
                return null;
            }
            nodeList.switchToClosed(candidate);
            if (candidate.getNode() == targetNode) {
                // We found our target!
                return nodeList.createPath();
            }
            // For every adjacent node ...
            List<Node> adjacent = candidate.getNode().adjacent();
            adjacent.forEach((node) -> {
                // Ignore nodes already processed or unreachable.
                if (!(nodeList.contains(node) || !node.isReachable())) {
                    nodeList.add(node, candidate.getNode(), targetNode);
                }
            });
        }
    }
}
