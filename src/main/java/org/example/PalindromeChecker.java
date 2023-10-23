package org.example;

public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        word = word.replaceAll(" ", "").toLowerCase();

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
