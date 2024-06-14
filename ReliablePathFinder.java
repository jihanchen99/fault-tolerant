import java.util.List;

import edu.upenn.cis573.graphs.*;

public class ReliablePathFinder extends PathFinder {

    public ReliablePathFinder(Graph g) {
        super(g);
    }

    /*
     * Implement this method using a Recovery Block and Retry Block as described in
     * the assignment specification.
     */
    public List<Integer> findPath(int src, int dest) throws PathNotFoundException {

        throw new PathNotFoundException();

    }

    /*
     * Implement this acceptance test as described in the assignment specification.
     */
    public boolean isValidPath(int src, int dest, List<Integer> path) {
        int size = path.size();
        if (path.get(0) != src || path.get(size - 1) != dest) {
            return false;
        }
        for (int i = 0; i < size - 1; i++) {
            Iterable<Integer> adj = graph.adj(path.get(i));
            int next = path.get(i+1);
            boolean found = false;
            for (int node : adj) {
                if (node == next) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;

    }

}
