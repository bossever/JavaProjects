package com.ayushman;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string, yes I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphaNumeric = "abcDeeeF12Ghhiiiijkl99z";

        //. is the character class that matches all characters, replaces all with 'Y'
        System.out.println(alphaNumeric.replaceAll(".", "Y"));

        //^ matches the beginning of a string, precedes the regex pattern
        System.out.println(alphaNumeric.replaceAll("^abcDeee", "YYY"));
        //$ matches the end of a string, comes after the regex pattern
        System.out.println(alphaNumeric.replaceAll("ijkl99z$", "THE END"));

        //replaces all occurrences of a, e, or i with X
        System.out.println(alphaNumeric.replaceAll("[aei]", "X"));
        //replaces two letters a, e or i, followed by the letter F or j
        System.out.println(alphaNumeric.replaceAll("[aei][Fj]", "X"));

        //returns false because the matches() method tries to match the whole string with the regex
        System.out.println(alphaNumeric.matches("^abcDeee"));

        //replaces harry starting with an upper or lower case h with "Harry"
        System.out.println("Harry can also be written as harry".replaceAll("[Hh]arry", "Harry"));

        //a caret can be used a boundary matcher as well as a character class (in the example above) when used inside []
        System.out.println(alphaNumeric.replaceAll("[^ej]", "X"));

        //replaces all characters that fall in the range specified (inclusive)
        System.out.println(alphaNumeric.replaceAll("[a-f3-8]", "X"));

        //replaces all characters that fall in the range specified (inclusive), but with case sensitivity turned off
        System.out.println(alphaNumeric.replaceAll("(?i)[a-f3-8]", "X"));
        /*
            (?i) --> ASCII strings
            (?iu) --> UNICODE strings
         */

        //replace all numbers [0-9] with X
        System.out.println(alphaNumeric.replaceAll("\\d", "X"));
        System.out.println(alphaNumeric.replaceAll("\\D", "X"));    //opposite

        //////////////////////////////////////////////////////////////////////////

        String hasWhiteSpace = "I have blanks, a\ttab, and also, a \nnewline.";
        System.out.println(hasWhiteSpace);

        //replaces all whitespaces in the string with "" (nothing)
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));    //opposite
        /*
            \\s     --> match whitespace characters
            \\S     --> match all non-whitespace characters

            \\s     --> match a single whitespace character
            \\s+    --> match sequence of one or more than one whitespace character

        These two behave differently when the string is replaced with a non-empty string
         */

        //replaces all word characters with X
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\W", "X"));   //opposite
        /*
            \w stands for "word character" --> [A-Za-z0-9_]
            \W stands for not a word character
         */

        //replaces all word boundaries with X
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\B", "X"));   //opposite
        /*
            \b      --> match all word boundaries (assuming that all words are separated by whitespaces)
         */


    }

}
