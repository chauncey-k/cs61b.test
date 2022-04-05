public class ArrayDeque<T> {
    private int size;
    private T[] array;

    private void resize(int newSize) {
        T[] resizedArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, resizedArray, 0, size);
    }

    private void testUsage() {
        if (size / array.length <= 0.25) {
            size /= 4;
        }
    }

    public void addFirst(T item) {
        if (size == array.length) {
            resize(size * 2);
        }
        int i = size - 1;
        while (i > 0) {
            array[i + 1] = array[i];
            --i;
        }
        array[0] = item;
        ++size;

        this.testUsage();
    }

    public void addLast(T item) {
        if (size == array.length) {
            resize(size * 2);
        }
        array[size] = item;
        ++size;

        this.testUsage();
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = 0;
        while (i < size) {
            if (i == size - 1) {
                System.out.println(array[i]);
            }
            System.out.print(array[i] + " ");
            ++i;
        }
    }

    public T removeFirst() {
        if (array[0] == null) {
            return null;
        }
        T temp = array[0];
        int i = 1;
        while (i < size) {
            array[i - 1] = array[i];
        }
        --size;

        this.testUsage();
        return temp;
    }

    public T removeLast() {
        if (array[size - 1] == null) {
            return null;
        }
        T temp = array[size - 1];
        array[size - 1] = null;
        --size;

        this.testUsage();
        return temp;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return array[index];
    }

    public ArrayDeque() {
        size = 0;
        array = (T[]) new Object[8];
    }

    public ArrayDeque(ArrayDeque other) {
        T[] temp = (T[]) new Object[other.size];
        System.arraycopy(other, 0, temp, 0, size);
    }

}
