package stack;

public class MyStack {

    private static final int DEFAULT_CAPACITY = 8;
    private int size;

    private int[] stack;

    public MyStack() {
        stack = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void push(int item) {
        checkFullCapacity();
        stack[size] = item;
        size++;
    }

    private void checkFullCapacity() {
        if (size == stack.length - 1) {
            enlargeList();
        }
    }

    private void enlargeList() {
        int[] oldList = stack.clone();
        stack = new int[oldList.length * 2];
        for (int i = 0; i < oldList.length; i++) {
            stack[i] = oldList[i];
        }
    }

    public int pop() {
        int item = stack[size - 1];
        size--;
        checkQuarterFullness();
        return item;
    }

    private void checkQuarterFullness() {
        if (size >= DEFAULT_CAPACITY / 2 && size == stack.length / 4) {
            reduceList();
        }
    }

    private void reduceList() {
        int[] oldList = stack.clone();
        stack = new int[size * 2];
        for (int i = 0; i < size; i++) {
            stack[i] = oldList[i];
        }
    }
}
