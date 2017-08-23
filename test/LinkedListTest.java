import linkedlist.MyLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    private MyLinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new MyLinkedList();
    }

    @Test
    public void testLinkedList_emptySize() throws Exception {
        assertEquals(linkedList.size(), 0);
    }

    @Test
    public void testLinkedList_addItem() throws Exception {
        linkedList.add(1);
        assertEquals(linkedList.size(), 1);
    }

    @Test
    public void testLinkedList_addThreeItems() throws Exception {
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        assertEquals(linkedList.size(), 3);
        assertEquals(linkedList.get(0), 3);
        assertEquals(linkedList.get(1), 4);
        assertEquals(linkedList.get(2), 5);
    }

    @Test
    public void testLinkedList_getItem() throws Exception {
        linkedList.add(1);
        assertEquals(linkedList.get(0), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLinkedList_getItemFirstEmpty() throws Exception {
        linkedList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLinkedList_getItemEmpty() throws Exception {
        linkedList.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLinkedList_getItemTooLargeIndex() throws Exception {
        linkedList.add(1);
        linkedList.get(3);
    }

    @Test
    public void testLinkedList_insertItemOnStart() throws Exception {
        linkedList.add(1);
        linkedList.insert(0, 2);
        assertEquals(linkedList.size(), 2);
        assertEquals(linkedList.get(0), 2);
    }

    @Test
    public void testLinkedList_insertItemInside() throws Exception {
        linkedList.add(1);
        linkedList.add(2);
        assertEquals(linkedList.size(), 2);
        linkedList.insert(1, 3);
        assertEquals(linkedList.size(), 3);
        assertEquals(linkedList.get(1), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLinkedList_insertItemTooLargeIndex() throws Exception {
        linkedList.add(1);
        linkedList.insert(3, 5);
    }
}
