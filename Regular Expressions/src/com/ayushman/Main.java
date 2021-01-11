package com.ayushman;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string, yes I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphaNumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));  //. is the character class that matches all characters, replaces all with 'Y'

        System.out.println(alphaNumeric.replaceAll("^abcDeee", "YYY"));     //^ matches the beginning of a string, precedes the regex pattern
        System.out.println(alphaNumeric.replaceAll("ijkl99z$", "THE END")); //$ matches the end of a string, comes after the regex pattern

        System.out.println(alphaNumeric.replaceAll("[aei]", "X"));          //replaces all occurrences of a, e, or i with X
        System.out.println(alphaNumeric.replaceAll("[aei][Fj]", "X"));      //replaces two letters a, e or i, followed by the letter F or j
        System.out.println(alphaNumeric.matches("^abcDeee"));                           //returns false because the matches() method tries to match the whole string with the regex

        System.out.println("Harry can also be written as harry".replaceAll("[Hh]arry", "Harry"));   //replaces harry starting with an upper or lower case h with "Harry"

        System.out.println(alphaNumeric.replaceAll("[^ej]", "X"));
        //a caret can be used a boundary matcher as well as a character class (in the example above) when used inside []

        System.out.println(alphaNumeric.replaceAll("[a-f3-8]", "X"));
        //replaces all characters that fall in the range specified (inclusive)
    }
}
