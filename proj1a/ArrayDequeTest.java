public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(1);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.addLast(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);
        ArrayDeque.addFirst(9);
        ArrayDeque.addLast(10);
        ArrayDeque.removeFirst();
        ArrayDeque.removeLast();
        ArrayDeque.addLast(13);
        ArrayDeque.removeLast();
        ArrayDeque.get(3);
        ArrayDeque.removeLast();
        ArrayDeque.removeFirst();
        ArrayDeque.removeLast();
        ArrayDeque.removeFirst();
        ArrayDeque.removeLast();
        ArrayDeque.removeLast();
    }
}
