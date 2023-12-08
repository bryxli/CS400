import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<Integer> graph;
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert verticies 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        // insert edges from Week 08. Dijkstra's Activity
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,7,2);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(3,7,2);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,0,2);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1);
        graph.insertEdge(7,0,3);
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled 0 to 8
     * (should be 15), and from the vertex labelled 9 to 8 (should be 17).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost(0,8) == 15);
        assertTrue(graph.getPathCost(9,8) == 17);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled 0 to 8, and from the vertex labelled 9 to 8.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath(0, 8).toString().equals(
                "[0, 2, 6, 3, 1, 8]"
        ));
        assertTrue(graph.shortestPath(9, 8).toString().equals(
                "[9, 4, 5, 1, 8]"
        ));
    }

    /**
     * Tests the distance reported as #3 from last week's activity.
     */
    @Test
    public void testDistanceThree() {
        assertTrue(graph.getPathCost(1,5)==14);
    }

    /**
     * Tests the sequence of values from the path of the source node to node #3.
     */
    @Test
    public void testSequenceOfValues(){
        assertTrue(graph.shortestPath(1,5).toString().equals("[1, 7, 0, 2, 4, 5]"));
    }

    /**
     * Tests that NoSuchElementException is thrown properly.
     */
    @Test
    public void testNoSuchElement(){
        try {
            graph.shortestPath(10, 15);
        }catch(Exception e){
            assertTrue(e instanceof NoSuchElementException);
        }
    }

    /**
     * Tests that the shortest path (of distance 0) is reported properly.
     */
    @Test
    public void testShortestPath(){
        assertTrue(graph.shortestPath(1,1).toString().equals("[1]"));
    }



}