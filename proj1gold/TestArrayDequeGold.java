import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

//    @Source StudentArrayDequeLauncher
    @Test
    public void test() {
        StudentArrayDeque<Integer> stu1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol1 = new ArrayDequeSolution<>();

        stu1.addFirst(5);
        sol1.addFirst(5);
        assertEquals("addFirst(5)", stu1.get(0), sol1.get(0));
        stu1.addFirst(3);
        sol1.addFirst(3);
        assertEquals("addFirst(5)\naddFirst(3)", stu1.get(1), sol1.get(1));
        int stu1Int = stu1.removeFirst();
        int sol1Int = sol1.removeFirst();
        assertEquals("addFirst(5)\naddFirst(3)\nremoveFirst()", stu1Int, sol1Int);
    }
}