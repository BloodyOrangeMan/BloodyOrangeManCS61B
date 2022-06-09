public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for(int i=0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = this.wordToDeque(word);
        return isPalindrome(deque);
    }
    public boolean isPalindrome(Deque<Character> deque) {
        if(deque.size() <= 1) {
            return true;
        }
        return deque.removeFirst() == deque.removeLast() && isPalindrome(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = this.wordToDeque(word);
        return isPalindrome(deque, cc);
    }

    public boolean isPalindrome(Deque<Character> deque, CharacterComparator cc) {
        if(deque.size() <= 1) {
            return true;
        }
        return cc.equalChars(deque.removeFirst(), deque.removeLast()) && isPalindrome(deque, cc);
    }



}
