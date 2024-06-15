import java.util.Collections;
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
        List<Integer> path1 = bfs(dest, src);
        if (path1 != null && isValidPath(dest, src, path1)) {
            Collections.reverse(path1);
            return path1;
        }

        List<Integer> path2 = dfs(dest, src);
        if (path2 != null && isValidPath(dest, src, path2)) {
            Collections.reverse(path2);
            return path2;
        }

        List<Integer> path3 = bfs(src, dest);
        if (path3 != null && isValidPath(src, dest, path3)) {
            return path3;
        }

        List<Integer> path4 = dfs(src, dest);
        if (path4 != null && isValidPath(src, dest, path4)) {
            return path4;
        }

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
