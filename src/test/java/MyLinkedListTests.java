import linked_list.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTests {
    private List<Integer> list;

    // [0, 1, 2, 3, 4]
    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
        list.addFirst(3);
        list.addFirst(0);
        list.add(1, 2);
        list.add(1, 1);
        list.addLast(4);
    }

    @Test
    public void testLinkedListSize() {
        assertEquals(5, list.size());
        list.addFirst(4);
        assertEquals(6, list.size());
    }

    @Test
    public void testEmptyList() {
        list = new MyLinkedList<>();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testLinkedListElementGetter() {
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), i);
        }
    }


    @Test
    public void testFirstElementGetter() {
        assertEquals(0, list.getFirst());
        list = new MyLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    @Test
    public void testWrongIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + 1));
    }

    @Test
    public void testDeleteByIndex() {
        assertEquals(2, list.remove(2));
        assertEquals(4, list.size());
        assertEquals(3, list.remove(2));
        assertEquals(0, list.remove(0));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveByNotExistingIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
    }

    @Test
    public void testRemoveLast() {
        assertEquals(4, list.removeLast());
        assertEquals(4, list.size());
    }

    @Test
    public void testRemoveFirst() {
        assertEquals(0, list.removeFirst());
        assertEquals(4, list.size());
    }

    @Test
    public void testAddAfterDeleteAllElements() {
        list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.removeFirst();
        list.removeFirst();

        list.addLast(3);
        assertEquals(1, list.size());
        assertEquals(3, list.getFirst());
    }
}