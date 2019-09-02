package my.homework.graphs;

import java.util.Objects;

public class Vertex<T> {
    private T value;

    Vertex(T val) {
        value = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(value, vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "my.homework.graphs.Vertex{" +
                "label='" + value + '\'' +
                '}';
    }
}
