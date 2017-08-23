package arraylist;

public class MyArrayList {

    private static final int DEFAULT_CAPACITY = 8;

    private int[] list;

    private int size;

    public MyArrayList() {
        list = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(int item) {
        checkCapacity();
        list[size] = item;
        size++;
    }

    private void checkCapacity() {
        if (size == list.length - 1) {
            resizeList();
        }
    }

    private void resizeList() {
        int[] oldList = list.clone();
        list = new int[oldList.length * 2];
        for (int i = 0; i < oldList.length; i++) {
            list[i] = oldList[i];
        }
    }

    public int get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public void put(int index, int item) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        putItemInsideList(index, item);
        size++;
    }

    private void putItemInsideList(int index, int item) {
        int[] right = getListTail(index);
        checkCapacity();
        list[index] = item;
        for (int i = 0; i < right.length; i++) {
            list[index + 1 + i] = right[i];
        }
    }

    private int[] getListTail(int index) {
        int[] right = new int[size - index];
        for (int i = 0; i < right.length; i++) {
            right[i] = list[index + i];
        }
        return right;
    }
}
