package linked_list;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyListInterface<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    private Node<E> getNode(int index) throws IndexOutOfBoundsException {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(E e) {
        Node<E> temp = head;
        Node<E> newNode = new Node<>();
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        newNode.element = e;
        newNode.next = temp;
        if (temp != null) {
            temp.prev = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> temp = tail;
        Node<E> newNode = new Node<>();
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        newNode.element = e;
        newNode.prev = temp;
        if (temp != null) {
            temp.next = newNode;
        }
        this.size++;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            this.size++;

            Node<E> indexedNode = getNode(index);
            Node<E> prev = indexedNode.prev;

            Node<E> newNode = new Node<>();
            newNode.element = element;
            newNode.next = indexedNode;
            indexedNode.prev = newNode;
            newNode.prev = prev;
            prev.next = newNode;
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> indexedNode = getNode(index);
        return indexedNode.element;
    }

    @Override
    public E getFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.element;
    }

    @Override
    public E getLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.element;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> indexedNode = getNode(index);
        Node<E> next = indexedNode.next;
        Node<E> prev = indexedNode.prev;

        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }

        if (indexedNode.prev != null) {
            prev.next = next;
        } else {
            head = indexedNode.next;
        }

        this.size--;
        return indexedNode.element;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;
    }
}
