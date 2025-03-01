public class ArrayDeque<T> implements Deque<T> {
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
        if (newSize > array.length) {
            for (int i = (nextFirst + 1) % array.length; i < size; i += 1) {
                resizedArray[newSize - 1 - (size - 1 - i)] = array[i];
            }
            for (int j = 0; j < nextLast; j += 1) {
                resizedArray[j] = array[j];
            }
            if (nextFirst == array.length - 1) {
                nextFirst = newSize - 1 - size;
            } else {
                nextFirst = newSize - 1 - (size - 1 - nextFirst);
            }
        } else {
            if (nextLast > nextFirst || nextLast == 0 || nextFirst == array.length - 1) {
                System.arraycopy(array, (nextFirst + 1) % array.length, resizedArray, 0, size);
            } else {
                System.arraycopy(array, nextFirst + 1,
                        resizedArray, 0, array.length - (nextFirst + 1));
                System.arraycopy(array, 0,
                        resizedArray, array.length - (nextFirst + 1), nextLast);
            }
            nextFirst = newSize - 1;
            nextLast = size % newSize;
        }
        array = resizedArray;
    }

    private void testUsage() {
        if (array.length >= 16) {
            if (size * 1.0 / array.length < 0.25) {
                resize(array.length / 2);
            }
        }
    }

    @Override
    public void addFirst(T item) {
        if (size == array.length) {
            resize(size * 2);
        }
        array[nextFirst] = item;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = array.length - 1;
        }
        size += 1;

        testUsage();
    }

    @Override
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

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
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

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T temp = array[(nextFirst + 1) % array.length];
        array[(nextFirst + 1) % array.length] = null;
        nextFirst += 1;
        if (nextFirst >= array.length) {
            nextFirst -= array.length;
        }
        size -= 1;
        testUsage();
        return temp;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T temp;
        if (nextLast == 0) {
            temp = array[array.length - 1];
            array[array.length - 1] = null;
        } else {
            temp = array[nextLast - 1];
            array[nextLast - 1] = null;
        }
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = array.length - 1;
        }
        size -= 1;
        testUsage();
        return temp;
    }

    @Override
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
