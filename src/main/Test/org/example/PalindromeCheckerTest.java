package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeCheckerTest {
    public void testWithPalindrome() {
        assertTrue(PalindromeChecker.isPalindrome("level"));
        assertTrue(PalindromeChecker.isPalindrome("refer"));
        assertTrue(PalindromeChecker.isPalindrome("Madam i'm Adam"));
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