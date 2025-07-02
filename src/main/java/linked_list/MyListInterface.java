package linked_list;

import java.util.NoSuchElementException;

public interface MyListInterface<E> {
    int size();
    boolean isEmpty();
    void addFirst(E e);
    void addLast(E e);
    void add(int index, E element) throws IndexOutOfBoundsException;
    E get(int index) throws IndexOutOfBoundsException;
    E getFirst() throws NoSuchElementException;
    E getLast() throws NoSuchElementException;
    E remove(int index) throws IndexOutOfBoundsException;
    E removeFirst() throws NoSuchElementException;
    E removeLast() throws NoSuchElementException;
}
