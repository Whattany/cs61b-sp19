public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque);
    }
    private boolean isPalindromeHelper(Deque<Character> wordDeque) {
        if (wordDeque.size() <= 1) {
            return true;
        }
        Character a = wordDeque.removeFirst();
        Character b = wordDeque.removeLast();
        if (a != b) {
            return false;
        }
        return isPalindromeHelper(wordDeque);
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque, cc);
    }
    private boolean isPalindromeHelper(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() <= 1) {
            return true;
        }
        Character a = wordDeque.removeFirst();
        Character b = wordDeque.removeLast();
        if (!cc.equalChars(a, b)) {
            return false;
        }
        return isPalindromeHelper(wordDeque, cc);
    }
}
