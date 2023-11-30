package org.example;

public class Decoder {

    public static String replaceDigits(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (isVowel(c)) {
                    result.append(getNumberForVowel(c));
                } else {
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String replaceConsonants(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (isConsonant(c)) {
                result.append(getNextConsonant(c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    private static int getNumberForVowel(char vowel) {
        switch (Character.toLowerCase(vowel)) {
            case 'a':
                return 1;
            case 'e':
                return 2;
            case 'i':
                return 3;
            case 'o':
                return 4;
            case 'u':
                return 5;
            default:
                // In case it's not a recognized vowel, return 0 or handle it as needed.
                return 0;
        }
    }

    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }

    private static char getNextConsonant(char c) {
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        int index = consonants.indexOf(c);
        int nextIndex = (index + 1) % consonants.length();
        return consonants.charAt(nextIndex);
    }

    public static void main(String[] args) {
        String input1 = "testing";
        String input2 = "hello";

        String result1 = replaceDigits(input1);
        System.out.println("Заміна голосних на числа: " + result1);

        String result2 = replaceConsonants(input2);
        System.out.println("Заміна приголосних на наступні приголосні: " + result2);
    }
}