import org.junit.Before;
import org.junit.Test;
import edu.upenn.cis573.graphs.*;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
public class ReliablePathFinderTest {
    private Graph graph;
    private ReliablePathFinder pathFinder;

    @Before
    public void setUp() {
        graph = new Graph(50);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(1, 7);
        graph.addEdge(1, 8);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(2, 40);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(3, 8);
        graph.addEdge(4, 5);
        graph.addEdge(4, 10);
        graph.addEdge(4, 12);
        graph.addEdge(5, 10);
        // Initialize the pathfinder with the graph
        pathFinder = new ReliablePathFinder(graph);
    }

    @Test
    public void invalidSrc() {
        List<Integer> validPath = Arrays.asList(1,2,3,4,5);
        assertFalse(pathFinder.isValidPath(0, 5, validPath));
    }

    @Test
    public void invalidDest() {
        List<Integer> validPath = Arrays.asList(1,2,3,4,5);
        assertFalse(pathFinder.isValidPath(1, 6, validPath));
    }

    @Test
    public void testValidPath() {
        List<Integer> validPath = Arrays.asList(1,2,3,4,5);
        assertTrue(pathFinder.isValidPath(1, 5, validPath));
    }

    @Test
    public void testInvalidPath() {
        List<Integer> invalidPath = Arrays.asList(1,4,3,2,5);
        assertFalse(pathFinder.isValidPath(1,5, invalidPath));
    }

    @Test
    public void testInvalidPath2() {
        List<Integer> invalidPath = Arrays.asList(1,2,3,3,5);
        assertFalse(pathFinder.isValidPath(1,5, invalidPath));
    }

}