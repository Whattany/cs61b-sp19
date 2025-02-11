import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
public class TestArrayDequeGold {
    @Test
    public void testTask() {
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> solutionArray = new ArrayDequeSolution<Integer>();
        String log = "";
        for (int i = 0; i < 1000; i++) {
            int methodNumber = StdRandom.uniform(8);
            int insertNumber = StdRandom.uniform(100);
            switch (methodNumber) {
                case 0:
                    assertEquals(log, solutionArray.isEmpty(), testArray.isEmpty());
                    break;
                case 1:
                    assertEquals(log, solutionArray.size(), testArray.size());
                    break;
                case 2:
                    int testNum = StdRandom.uniform(testArray.size() + 3);
                    if (testArray.size() == 0 || testNum >= testArray.size()) {
                        assertEquals(log, null, testArray.get(testNum));
                    } else {
                        assertEquals(log, solutionArray.get(testNum), testArray.get(testNum));
                    }
                    break;
                case 3:
                    log = log.concat("\nremoveFirst()");
                    assertEquals(log, solutionArray.removeFirst(), testArray.removeFirst());
                    break;
                case 4:
                    log = log.concat("\nremoveLast()");
                    assertEquals(log, solutionArray.removeLast(), testArray.removeLast());
                    break;
                case 5:
                    log = log.concat("\naddFirst(" + insertNumber + ")");
                    testArray.addFirst(insertNumber);
                    solutionArray.addFirst(insertNumber);
                    break;
                case 6:
                    log = log.concat("\naddLast(" + insertNumber + ")");
                    testArray.addLast(insertNumber);
                    solutionArray.addLast(insertNumber);
                    break;
                case 7:
                    ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
                    PrintStream casheStream = new PrintStream(tempStream);
                    PrintStream oldStream = System.out;
                    System.setOut(casheStream);
                    testArray.printDeque();
                    String log1 = tempStream.toString();
                    tempStream.reset();
                    solutionArray.printDeque();
                    String log2 = tempStream.toString();
                    System.setOut(oldStream);
                    assertEquals(log, log2, log1);
                    break;
                default:
                    break;
            }
        }
    }
}
