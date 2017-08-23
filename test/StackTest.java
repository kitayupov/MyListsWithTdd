import org.junit.Before;
import org.junit.Test;
import stack.MyStack;

import static org.junit.Assert.assertEquals;

public class StackTest {

    private MyStack stack;

    @Before
    public void setUp() throws Exception {
        stack = new MyStack();
    }

    @Test
    public void testStack_EmptySize() throws Exception {
        assertEquals(stack.size(), 0);
    }

    @Test
    public void testStack_pushItem() throws Exception {
        stack.push(1);
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testStack_pushTwoItems() throws Exception {
        stack.push(1);
        stack.push(2);
        assertEquals(stack.size(), 2);
    }

    @Test
    public void testStack_popItem() throws Exception {
        stack.push(1);
        assertEquals(stack.pop(), 1);
        assertEquals(stack.size(), 0);
    }

    @Test
    public void testStack_popTwoItems() throws Exception {
        stack.push(3);
        stack.push(4);
        assertEquals(stack.pop(), 4);
        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), 3);
        assertEquals(stack.size(), 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testStack_popEmpty() throws Exception {
        stack.pop();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testStack_popMoreThanPush() throws Exception {
        stack.push(1);
        stack.pop();
        stack.pop();
    }

    @Test
    public void testStack_pushFullStack() throws Exception {
        for (int i = 0; i < 8; i++) {
            stack.push(1);
        }
        assertEquals(stack.size(), 8);
        stack.push(1);
        assertEquals(stack.size(), 9);
    }

    /*@Test
    public void test_pushStackReduce() throws Exception {
        for (int i = 0; i < 17; i++) {
            stack.push(1);
        }
        assertEquals(stack.stack.length, 32);
        for (int i = 0; i < 9; i++) {
            stack.pop();
        }
        assertEquals(stack.size(), 8);
        assertEquals(stack.stack.length, 16);
    }*/

    /*@Test
    public void test_pushStackDoNotReduceLessThanDefaultSize() throws Exception {
        for (int i = 0; i < 9; i++) {
            stack.push(1);
        }
        assertEquals(stack.stack.length, 16);
        for (int i = 0; i < 8; i++) {
            stack.pop();
        }
        assertEquals(stack.size(), 1);
        assertEquals(stack.stack.length, 8);
    }*/
}
