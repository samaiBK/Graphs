package my.homework.graphs.api;

import my.homework.graphs.Vertex;

import java.util.List;

public interface Graph<T> {


    abstract void addVertex(Vertex<T> v);

    void addEdge(Vertex<T> v1, Vertex<T> v2);

    List<Vertex<T>> getPath(Vertex<T> oneVertex, Vertex<T> nextOneVertex);

}

