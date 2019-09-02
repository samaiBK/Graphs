package my.homework.graphs.common;

import my.homework.graphs.IllegalGraphArgumentException;
import my.homework.graphs.ListBasedGraph;
import my.homework.graphs.Vertex;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;


public class ListBasedGraphTest {

    @Test
    public void singleEdgeGraphShouldReturnTwoVertex() throws IllegalGraphArgumentException {
        ArrayList<Vertex<String>> initVertex = new ArrayList<>();
        initVertex.add(new Vertex<>("one"));
        initVertex.add(new Vertex<>("two"));

        ListBasedGraph<String> graphToTest = getGraphBasedOnVertex(initVertex);
        graphToTest.addEdge(new Vertex<>("one"), new Vertex<>("two"));

        assertEquals(graphToTest.getPath(new Vertex<>("one"),  new Vertex<>("two")), initVertex);
    }

    @Test
    public void fewEdgeGraphShouldReturnCorrectResult() throws IllegalGraphArgumentException {
        ArrayList<Vertex<String>> base = new ArrayList<>();
        base.add(new Vertex<>("one"));base.add(new Vertex<>("two"));base.add(new Vertex<>("three"));
        base.add(new Vertex<>("four"));base.add(new Vertex<>("five"));base.add(new Vertex<>("six"));
        base.add(new Vertex<>("seven"));base.add(new Vertex<>("eight"));base.add(new Vertex<>("nine"));

        ListBasedGraph<String> graphToTest = getGraphBasedOnVertex(base);
        graphToTest.addEdge(new Vertex<>("one"), new Vertex<>("four"));
        graphToTest.addEdge(new Vertex<>("four"), new Vertex<>("six"));
        graphToTest.addEdge(new Vertex<>("six"), new Vertex<>("two"));

        assertEquals(graphToTest.getPath(new Vertex<>("one"), new Vertex<>("two")),
                Arrays.asList(new Vertex<>("one"),new Vertex<>("four"),new Vertex<>("six"),new Vertex<>("two")));
    }

    @Test
    public void shouldReturnEmptyListIfNoPathToDestination() throws IllegalGraphArgumentException {
        ArrayList<Vertex<String>> base = new ArrayList<>();
        base.add(new Vertex<>("one"));base.add(new Vertex<>("two"));base.add(new Vertex<>("three"));
        base.add(new Vertex<>("four"));base.add(new Vertex<>("five"));base.add(new Vertex<>("six"));
        base.add(new Vertex<>("seven"));base.add(new Vertex<>("eight"));base.add(new Vertex<>("nine"));

        ListBasedGraph<String> graphToTest = getGraphBasedOnVertex(base);
        graphToTest.addEdge(new Vertex<>("one"), new Vertex<>("four"));
        graphToTest.addEdge(new Vertex<>("six"), new Vertex<>("two"));

        assertEquals(graphToTest.getPath(new Vertex<>("one"), new Vertex<>("two")),
                Collections.emptyList());
    }

    @Test(expected = IllegalGraphArgumentException.class)
    public void shouldThrowExceptionIfThereIsNoEdgesInGraph() throws IllegalGraphArgumentException {
        ArrayList<Vertex<String>> base = new ArrayList<>();
        base.add(new Vertex<>("one"));
        base.add(new Vertex<>("two"));

        ListBasedGraph<String> graphToTest = getGraphBasedOnVertex(base);

        assertEquals(graphToTest.getPath(base.get(0),  base.get(1)), base);
    }

    private ListBasedGraph<String> getGraphBasedOnVertex(ArrayList<Vertex<String>> vertexes) {
        ListBasedGraph<String> graphToTest = new ListBasedGraph<>();
        for (Vertex<String> v : vertexes) {
            graphToTest.addVertex(v);
        }
        return graphToTest;
    }
}
