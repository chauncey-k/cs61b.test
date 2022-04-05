public class LinkedListDeque<T> {

    private int size;
    private IntNode sentinel;

    private class IntNode {
        private T item;
        private IntNode prev;
        private IntNode next;

        private IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }

    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        IntNode p = sentinel.next;
        IntNode temp = new IntNode(sentinel, item, p);
        sentinel.next = temp;
        p.prev = temp;

        size += 1;
    }

    public void addLast(T item) {
        IntNode p = sentinel.prev;
        IntNode temp = new IntNode(p, item, sentinel);
        sentinel.prev = temp;
        p.next = temp;

        size += 1;
    }

    public boolean isEmpty() {
        return (sentinel.next == sentinel);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel.next;
        int i = 0;
        while (i < size) {
            if (i == size - 1) {
                System.out.println(p.item);
            }
            System.out.print(p.item + " ");
            i += 1;
        }
    }

    public T removeFirst() {
        IntNode temp = sentinel.next;
        if (temp == sentinel) {
            return null;
        }
        sentinel.next = temp.next;
        temp.next.prev = sentinel;

        size -= 1;
        return temp.item;
    }

    public T removeLast() {
        IntNode temp = sentinel.prev;
        if (temp == sentinel) {
            return null;
        }
        sentinel.prev = temp.prev;
        temp.prev.next = sentinel;

        size -= 1;
        return temp.item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode temp = sentinel;
        while (index >= 0) {
            temp = temp.next;
            index -= 1;
        }
        return temp.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursive(0, index, sentinel.next);
    }

    private T getRecursive(int pos, int index, IntNode x) {
        if (pos == index) {
            return x.item;
        }
        return getRecursive(pos + 1, index, x.next);
    }

}
