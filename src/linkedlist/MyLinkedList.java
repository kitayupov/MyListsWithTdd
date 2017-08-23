package linkedlist;

public class MyLinkedList {

    private int size;
    private MyLinkedElement first;

    public MyLinkedList() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size == 0) {
            first = new MyLinkedElement(value);
        } else {
            MyLinkedElement element = first;
            while (element.next != null) {
                element = element.next;
            }
            element.next = new MyLinkedElement(value);
            if (size == 1) {
                first.next = new MyLinkedElement(value);
            }
        }
        size++;
    }

    public int get(int index) {
        return getElementByIndex(index).getValue();
    }

    private MyLinkedElement getElementByIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        MyLinkedElement item = first;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item;
    }

    public void insert(int index, int value) {
        MyLinkedElement element = new MyLinkedElement(value);
        if (index == 0) {
            element.next = first;
            first = element;
        } else {
            MyLinkedElement prevElem = getElementByIndex(index - 1);
            element.next = prevElem.next;
            prevElem.next = element;
        }
        size++;
    }

    private void print() {
        System.out.println("\n");
        MyLinkedElement element = first;
        while (element != null) {
            System.out.println(element.getValue());
            element = element.next;
        }
    }
}
