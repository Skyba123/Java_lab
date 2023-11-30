package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecoderTest {

    @Test
    public void testReplaceDigits() {
        String input = "testing";
        String expected = "t2st3ng";
        String result = Decoder.replaceDigits(input);
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceConsonants() {
        String input = "hello";
        String expected = "jemmo";
        String result = Decoder.replaceConsonants(input);
        assertEquals(expected, result);
    }
}