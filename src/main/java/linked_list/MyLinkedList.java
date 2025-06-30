package linked_list;

import java.util.*;

public class MyLinkedList<E> implements List<E> {
    private class Node {
        private E element;
        private Node next;
        private Node prev;
    }

    private int size;
    private Node head;
    private Node tail;

    private Node getNode(int index) throws IndexOutOfBoundsException {
        Node temp = head;
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
        Node temp = head;
        Node newNode = new Node();
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
        Node temp = tail;
        Node newNode = new Node();
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

            Node indexedNode = getNode(index);
            Node prev = indexedNode.prev;

            Node newNode = new Node();
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

        Node indexedNode = getNode(index);
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

        Node indexedNode = getNode(index);
        Node next = indexedNode.next;
        Node prev = indexedNode.prev;

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

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
