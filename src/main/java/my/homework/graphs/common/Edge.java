package my.homework.graphs.common;

public class Edge<T> {

    public Vertex<T> getVertex1() {
        return vertex1;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    Vertex<T> getNextVertex(){
        Vertex<T> temp = vertex1;
        vertex1 = vertex2;
        vertex2 = temp;
        return temp;
    }

    private Vertex<T> vertex1;
    private Vertex<T> vertex2;

    public Edge(T p1, T p2) {
        vertex1 = new Vertex<>(p1);
        vertex2 = new Vertex<>(p2);
    }

    public Edge(Vertex<T> p1, Vertex<T> p2) {
        vertex1 = p1;
        vertex2 = p2;
    }
}
