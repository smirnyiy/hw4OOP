package gb.list;

import gb.GBDeque;
import gb.GBList;

import java.util.Iterator;

public class GBLinkedList<T> implements GBDeque<T>, GBList<T> {
    private int size = 0;

    private GBNode<T> head;
    private GBNode<T> tail;

    public GBLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public GBLinkedList(T head) {
        this();
        addFirst(head);
    }

    @Override
    public void addFirst(T t) {
        GBNode<T> temp = new GBNode<>(t);
        if (isEmpty()) {
            tail = temp;
        }
        else {
            head.prev = temp;
        }

        temp.next = head;
        head = temp;
        size++;
    }

    public GBNode<T> getNode(int i) {
        GBNode<T> current = head;

        for (int pos = 0; current != null && pos < i; pos++) {
            current = current.next;
        }

        return current;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addLast(T t) {
        GBNode<T> temp = new GBNode<>(t);

        if (isEmpty()) {
            head = temp;
        }
        else {
            tail.next = temp;
        }

        temp.prev = tail;
        tail = temp;
        size++;
    }

    @Override
    public GBLinkedList<T> add(T t) {
        addLast(t);
        return this;
    }

    @Override
    public GBLinkedList<T> add(int i, T t) {
        if (i < 0 || i >= size) {
            return this;
        }

        GBNode<T> current = getNode(i);
        GBNode<T> temp = new GBNode<>(t, current.prev, current);
        current.prev.next = temp;
        current.prev = temp;
        return this;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }

        return getNode(i).data;
    }

    @Override
    public void remove(int i) {
        GBNode<T> removeNode = getNode(i);
        if (removeNode == null) {
            return;
        }

        if (removeNode != head) {
            removeNode.prev.next = removeNode.next;
        }
        else {
            head = removeNode.next;
        }

        if (removeNode != tail) {
            removeNode.next.prev = removeNode.prev;
        }
        else {
            tail = removeNode.prev;
        }

        removeNode.prev = removeNode.next = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }

    @Override
    public void update(int i, T t) {
        GBNode<T> currentNode = getNode(i);
        currentNode.data = t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // sb.append(this.getClass().getSimpleName());

        if (size < 1) {
            return sb.toString();
        }

        sb.append("size: ").append(size).append(" [");

        for (T el : this) {
            sb.append(el);
            sb.append(el == tail.data ? "]" : ", ");
        }

        return sb.toString();
    }
}