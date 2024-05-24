import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testisPalindrome() {
        Palindrome a = new Palindrome();
        assertTrue(a.isPalindrome("racecar"));
        assertTrue(a.isPalindrome("n"));
        assertTrue(a.isPalindrome(""));
        assertFalse(a.isPalindrome("cat"));
        assertFalse(a.isPalindrome("horse"));

    }
}
