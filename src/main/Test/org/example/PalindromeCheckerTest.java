package org.example;

import org.junit.Test;

import static org.example.PalindromeChecker.isPalindrome;
import static org.junit.Assert.*;

public class PalindromeCheckerTest {
    public void testWithPalindrome() {
        assertTrue(PalindromeChecker.isPalindrome("level"));
        assertTrue(PalindromeChecker.isPalindrome("refer"));
        System.out.println(isPalindrome("Yawn a more Roman way"));
    }

    @Test
    public void testWithNonPalindrome() {
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("war"));
    }
    @Test
    public void testWithSingleCharacter() {
        assertTrue(PalindromeChecker.isPalindrome("s"));
    }
    @Test
    public void testWithEmptyString() {
        assertTrue(PalindromeChecker.isPalindrome(""));
    }

}