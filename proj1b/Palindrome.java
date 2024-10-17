public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> myDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            myDeque.addLast(word.charAt(i));
        }
        return myDeque;
    }

//    public boolean isPalindrome(String word){
//        Deque<Character> myDeque = wordToDeque(word);
//        int length = myDeque.size();
//        Character temp1 = 0;
//        Character temp2 = 0;
//        if (length % 2 == 0) {
//            while (!myDeque.isEmpty()) {
//                temp1 = myDeque.removeFirst();
//                temp2 = myDeque.removeLast();
//                if (temp1 != temp2) {
//                    return false;
//                }
//            }
//        }
//        else {
//            while (myDeque.size() != 1) {
//                temp1 = myDeque.removeFirst();
//                temp2 = myDeque.removeLast();
//                if (temp1 != temp2) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    };

    public boolean isPalindrome(String word) {
        Deque<Character> myDeque = wordToDeque(word);
        return isPalindromeHelper(myDeque);
    }

    private boolean isPalindromeHelper(Deque<Character> deque) {

        if (deque.size() <= 1) {
            return true;
        }

        Character first = deque.removeFirst();
        Character last = deque.removeLast();

        if (!first.equals(last)) {
            return false;
        } else {
            return isPalindromeHelper(deque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> myDeque = wordToDeque(word);
        while (myDeque.size() > 1) {
            char front = myDeque.removeFirst();
            char back = myDeque.removeLast();
            if (!cc.equalChars(front, back)) {
                return false;
            }
        }
        return true;
    }
}
