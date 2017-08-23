import arraylist.MyArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {

    private MyArrayList arrayList;

    @Before
    public void setUp() throws Exception {
        arrayList = new MyArrayList();
    }

    @Test
    public void testArrayList_emptyZeroSize() throws Exception {
        assertEquals(arrayList.size(), 0);
    }

    @Test
    public void testArrayList_addOneItem() throws Exception {
        arrayList.add(1);
        assertEquals(arrayList.size(), 1);
    }

    @Test
    public void testArrayList_addTwoItems() throws Exception {
        arrayList.add(1);
        arrayList.add(2);
        assertEquals(arrayList.size(), 2);
    }

    @Test
    public void testArrayList_addItemInFullList() throws Exception {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        assertEquals(arrayList.size(), 8);
        arrayList.add(9);
        assertEquals(arrayList.size(), 9);
    }

    @Test
    public void testArrayList_getItem() throws Exception {
        arrayList.add(3);
        arrayList.add(4);
        assertEquals(arrayList.get(0), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayList_getItemWithTooLargeIndex() throws Exception {
        arrayList.add(3);
        arrayList.add(4);
        arrayList.get(42);
    }

    @Test
    public void testArrayList_putItem() throws Exception {
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.put(1, 8);
        assertEquals(arrayList.get(1), 8);
        assertEquals(arrayList.get(2), 4);
    }

    @Test
    public void testArrayList_putItemInFirst() throws Exception {
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.put(0, 8);
        assertEquals(arrayList.get(0), 8);
        assertEquals(arrayList.get(1), 3);
    }

    @Test
    public void testArrayList_putItemInLast() throws Exception {
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.put(2, 8);
        assertEquals(arrayList.get(2), 8);
        assertEquals(arrayList.get(3), 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayList_putItemInAfterLast() throws Exception {
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.put(3, 8);
    }

    @Test
    public void testArrayList_putItemInFullList() throws Exception {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        assertEquals(arrayList.size(), 8);
        arrayList.put(2, 9);
        assertEquals(arrayList.size(), 9);
        assertEquals(arrayList.get(2), 9);
        assertEquals(arrayList.get(3), 3);
    }
}
