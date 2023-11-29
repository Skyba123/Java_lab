package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecoderTest {

    @Test
    public void testReplaceDigits() {
        String input = "t2st3ng";
        String expected = "testing";
        String result = Decoder.replaceDigits(input);
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceConsonants() {
        String input = "gekko";
        String expected = "hello";
        String result = Decoder.replaceConsonants(input);
        assertEquals(expected, result);
    }
}