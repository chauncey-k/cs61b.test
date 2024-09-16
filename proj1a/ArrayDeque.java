public class ArrayDeque<T> {
    // the number of elements stored in array
    private int size;

    // former index of the first element
    private int nextFirst;

    // store the address of the array
    private T[] array;

    // next index of the last element
    private int nextLast;

    private void resize(int newSize) {
        T[] resizedArray = (T[]) new Object[newSize];
        if (newSize > size) {
            for (int i = (nextFirst + 1) % array.length; i < size; i += 1) {
                resizedArray[newSize - 1 - (size - 1 - i)] = array[i];
            }
            for (int j = 0; j < nextLast; j += 1) {
                resizedArray[j] = array[j];
            }
            nextFirst = newSize - 1 - (size - 1 - nextFirst);
        } else {
            if (nextLast > nextFirst) {
                System.arraycopy(array, nextFirst + 1, resizedArray, 0, size);
            } else {
                System.arraycopy(array, nextFirst + 1, resizedArray, 0, array.length - (nextFirst + 1));
                System.arraycopy(array, 0, resizedArray, array.length - (nextFirst + 1), nextLast);
            }
            nextFirst = resizedArray.length;
            nextLast = size;
        }
        array = resizedArray;
    }

    private void testUsage() {
        if (array.length >= 16) {
            if (size * 1.0 / array.length < 0.25) {
                resize(size / 2);
            }
        }
    }

    public void addFirst(T item) {
        if (size == array.length) {
            resize(size * 2);
        }
        array[nextFirst] = item;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst += array.length;
        }
        size += 1;

        testUsage();
    }

    public void addLast(T item) {
        if (size == array.length) {
            resize(size * 2);
        }
        array[nextLast] = item;
        nextLast += 1;
        nextLast = nextLast % array.length;
        size += 1;

        testUsage();
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
                System.out.println(array[nextLast - 1]);
            }
            System.out.print(array[nextFirst + 1 + i] + " ");
            i += 1;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T temp = array[(nextFirst + 1) % array.length];
        nextFirst += 1;
        if (nextFirst >= array.length) {
            nextFirst -= array.length;
        }
        size -= 1;
        testUsage();
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T temp;
        if (nextLast == 0) {
            temp = array[nextLast - 1 + array.length];
        } else {
            temp = array[nextLast - 1];
        }
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast += array.length;
        }
        size -= 1;
        testUsage();
        return temp;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return array[(nextFirst + 1 + index) % array.length];
    }

    public ArrayDeque() {
        size = 0;
        array = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }

}
