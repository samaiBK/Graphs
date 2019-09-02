package my.homework.graphs.api;

import my.homework.graphs.Edge;
import my.homework.graphs.Vertex;

import java.util.List;

public interface Graph<T> {


    void addVertex(Vertex vertex);

    void addEdge(Vertex v1, Vertex v2);

    List getPath(Vertex oneVertex, Vertex nextOneVertex);

}

