package my.homework.graphs;

import java.util.*;

public class ListBasedGraph<T> {

    private Map<Vertex<?>, List<Vertex<T>>> adjVertices = new HashMap<>();


    public void addVertex(T val) {
        addVertex(new Vertex<>(val));
    }


    public void addVertex(Vertex<T> vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }


    public void addEdge(T label1, T label2) {
        Vertex<T> v1 = new Vertex<>(label1);
        Vertex<T> v2 = new Vertex<>(label2);
        addEdge(v1, v2);
    }


    public void addEdge(Edge<T> edge) {
        addEdge(edge.getNextVertex(), edge.getNextVertex());
    }


    public void addEdge(Vertex<T> v1, Vertex<T> v2) {
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    /**
     * @param oneVertex     - a vertex
     * @param nextOneVertex - another vertex
     * @return returns a list of edges between 2 vertices (path doesn’t have to be optimal)
     */


    public List<Vertex<T>> getPath(Vertex<T> oneVertex, Vertex<T> nextOneVertex) throws IllegalGraphArgumentException {
        List<Edge<T>> resultList = new ArrayList<>();
        LinkedList<Vertex<T>> visited = new LinkedList<>();
        Queue<Vertex<T>> toBeProcessed = new LinkedList<>();
        visited.add(oneVertex);
        toBeProcessed.add(oneVertex);

        checkInputArgument(oneVertex);
        checkInputArgument(nextOneVertex);

        while (!toBeProcessed.isEmpty()) {
            Vertex<T> vtx = toBeProcessed.poll();
            for (Vertex<T> v : getJoinedVertex(vtx)) {
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


    public List<Vertex<T>> getJoinedVertex(Vertex<T> oneVertex) {
        return adjVertices.putIfAbsent(oneVertex, new ArrayList<>());
    }

    private void checkInputArgument(Vertex<T> input) throws IllegalGraphArgumentException {

        if (adjVertices.get(input).isEmpty()) {
            throw new IllegalGraphArgumentException();
        }
    }
}
