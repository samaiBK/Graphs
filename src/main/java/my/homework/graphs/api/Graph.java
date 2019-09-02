package my.homework.graphs.api;

import my.homework.graphs.common.Edge;
import my.homework.graphs.common.Vertex;

import java.util.List;

public interface Graph<T> {

    void addVertex(T val);

    void addVertex(Vertex vertex);

    void addEdge(Object label1, Object label2);

    void addEdge(Edge edge);

    void addEdge(Vertex v1, Vertex v2);

    List getPath(Vertex oneVertex, Vertex nextOneVertex);

    List getJoinedVertex(Vertex oneVertex);
}

