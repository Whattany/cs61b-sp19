public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque d = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public Boolean isPalindrome(String word) {
        Palindrome a = new Palindrome();
        Deque wordeque = a.wordToDeque(word);

        return recursiveHelper(wordeque);
    }
    // front rear
    private boolean recursiveHelper(Deque w) {
        if (w.size() <= 1) {
            return true;
        } else {
            if (w.removeFirst() != w.removeLast()) {
                return false;
            } else {
                return recursiveHelper(w);
            }
        }
    }


    public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome a = new Palindrome();
        Deque wordeque = a.wordToDeque(word);
        return recursiveHelper(wordeque, cc);
    }

    private boolean recursiveHelper(Deque<Character> w, CharacterComparator cc) {
        if (w.size() <= 1) {
            return true;
        }

        if (!cc.equalChars(w.removeFirst(), w.removeLast())) {
            return false;
        }

        return recursiveHelper(w, cc);


    }
}
