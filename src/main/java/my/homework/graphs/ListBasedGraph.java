package my.homework.graphs;

import my.homework.graphs.api.Graph;

import java.util.*;

public class ListBasedGraph<T> implements Graph<T> {

    private final Map<Vertex<T>, List<Vertex<T>>> vertices = new HashMap<>();

    /**
     * Appends the specified Vertex to this graph.
     *
     * @param v - vertex for appends
     */
    @Override
    public void addVertex(Vertex<T> v) {
        vertices.putIfAbsent(v, new ArrayList<>());
    }

    /**
     * Appends the specified Edge to this graph.
     *
     * @param v1 - one point of an edge
     * @param v2 - next one point of an edge
     */
    @Override
    public void addEdge(Vertex<T> v1, Vertex<T> v2) {
        vertices.get(v1).add(v2);
        vertices.get(v2).add(v1);
    }

    /**
     * @param oneVertex     - a vertex
     * @param nextOneVertex - another vertex
     * @return returns a list of edges between 2 vertices (path doesn’t have to be optimal)
     */
    @Override
    public List<Vertex<T>> getPath(Vertex<T> oneVertex, Vertex<T> nextOneVertex) {
        LinkedList<Vertex<T>> visited = new LinkedList<>();
        Queue<Vertex<T>> toBeProcessed = new LinkedList<>();
        visited.add(oneVertex);
        toBeProcessed.add(oneVertex);

        checkInputArgument(oneVertex);
        checkInputArgument(nextOneVertex);

        while (!toBeProcessed.isEmpty()) {
            Vertex<T> vtx = toBeProcessed.poll();
            for (Vertex<T>  v : getJoinedVertex(vtx)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    toBeProcessed.add(v);
                }
                if (v.equals(nextOneVertex))
                    return visited;
            }
        }
        return new ArrayList<>();
    }

    private List<Vertex<T>> getJoinedVertex(Vertex<T> oneVertex) {
        return vertices.putIfAbsent(oneVertex, new ArrayList<>());
    }

    private void checkInputArgument(Vertex<T> input) throws IllegalGraphArgumentException {
        if (input == null || vertices.get(input).isEmpty())
            throw new IllegalGraphArgumentException();
    }
}

