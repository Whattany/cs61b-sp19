import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
public class TestArrayDequeGold {
    @Test
    public void testTask() {
        StudentArrayDeque<Integer> stuTest = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> testSolution = new ArrayDequeSolution<Integer>();
        String str = "";
        int i = 0;
        while (true) {
            int methodNumber = StdRandom.uniform(8);
            switch (methodNumber) {
                case 0:
                    str = str.concat("\nisEmpty()");
                    assertEquals(str, testSolution.isEmpty(), stuTest.isEmpty());
                    break;
                case 1:
                    str = str.concat("\nsize()");
                    assertEquals(str, testSolution.size(), stuTest.size());
                    break;
                case 2:
                    int testNum = StdRandom.uniform(stuTest.size() + 10);
                    str = str.concat("\nget(" + testNum + ")");
                    if (stuTest.size() == 0 || testNum >= stuTest.size()) {
                        assertEquals(str, null, stuTest.get(testNum));
                    } else{
                        assertEquals(str, testSolution.get(testNum), stuTest.get(testNum));
                    }
                    break;
                case 3:
                    str = str.concat("\nremoveFirst()");
                    assertEquals(str, testSolution.removeFirst(), stuTest.removeFirst());
                    break;
                case 4:
                    str = str.concat("\nremoveLast()");
                    assertEquals(str, testSolution.removeLast(), stuTest.removeLast());
                    break;
                case 5:
                    int insertNumber1 = StdRandom.uniform(100);
                    str = str.concat("\naddFirst(" + insertNumber1 + ")");
                    stuTest.addFirst(insertNumber1);
                    testSolution.addFirst(insertNumber1);
                    break;
                case 6:
                    int insertNumber = StdRandom.uniform(100);
                    str = str.concat("\naddLast(" + insertNumber + ")");
                    stuTest.addLast(insertNumber);
                    testSolution.addLast(insertNumber);
                    break;
                case 7:
                    str = str.concat("\nprintDeque()");
                    ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
                    PrintStream casheStream = new PrintStream(tempStream);
                    PrintStream oldStream = System.out;
                    System.setOut(casheStream);
                    stuTest.printDeque();
                    String str1 = tempStream.toString();
                    tempStream.reset();
                    testSolution.printDeque();
                    String str2 = tempStream.toString();
                    System.setOut(oldStream);
                    assertEquals(str, str2, str1);
                    break;
            }
        }
    }
}
