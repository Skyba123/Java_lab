package org.example;

public class Decoder {

    public static String replaceDigits(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(getVowelForNumber(Character.getNumericValue(c)));
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

    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }

    private static char getNextConsonant(char c) {
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        int index = consonants.indexOf(c);
        int nextIndex = (index + 1) % consonants.length();
        return consonants.charAt(nextIndex);
    }

    private static char getVowelForNumber(int number) {
        switch (number) {
            case 1:
                return 'a';
            case 2:
                return 'e';
            case 3:
                return 'i';
            case 4:
                return 'o';
            case 5:
                return 'u';
            default:
                return (char) ('a' + number - 1);
        }
    }
}