package be.gestatech.petclinic.core.datatables.specification;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private final String name;
    private final T data;
    private List<Node<T>> children = new ArrayList<>();

    public Node(String name, T data) {
        this.name = name;
        this.data = data;
    }

    public Node(String name) {
        this.name = name;
        this.data = null;
    }

    public void addChild(Node<T> child) {
        children.add(child);
    }

    public Node<T> getOrCreateChild(String name) {
        for (Node<T> child : children) {
            if (child.name.equals(name)) {
                return child;
            }
        }
        Node<T> child = new Node<T>(name);
        children.add(child);
        return child;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public T getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    List<Node<T>> getChildren() {
        return children;
    }
}