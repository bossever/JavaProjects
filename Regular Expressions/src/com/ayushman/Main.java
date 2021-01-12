package com.ayushman;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string, yes I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphaNumeric = "abcDeeeF12abcDeeeGhhiiiijkl99z";

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

        /*____________________________________________________________________________*/
        /*_________________________________QUANTIFIERS________________________________*/
        /*____________________________________________________________________________*/

        String copyOfAlphaNumeric = "abcDeeeF12abcDeeeGhhiiiijkl99z";
        System.out.println(copyOfAlphaNumeric.replaceAll("^abcDe{3}", "YYY"));
        //the quantifier {3} occurs AFTER the character being quantified, in this case, replacement will happen only if e occurs exactly thrice in the string

        //+ is used to match ONE OR MORE e's
        System.out.println(copyOfAlphaNumeric.replaceAll("^abcDe+", "YYY"));

        //* is used to match ZERO OR MORE e's
        System.out.println(copyOfAlphaNumeric.replaceAll("^abcDe*", "YYY"));

        //match all strings with 2 to 5 e's
        System.out.println(copyOfAlphaNumeric.replaceAll("^abcDe{2,5}", "YYY"));

        //replace all occurrences of h, followed by any number of i's, followed by at least one j
        System.out.println(copyOfAlphaNumeric.replaceAll("h+i*j+", "Y"));

        /*____________________________________________________________________________*/
        /*____________________________________________________________________________*/
        /*____________________________________________________________________________*/



        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary you were looking for.</p>");

        String h2Pattern = "<h2>";                  //there can be anything before and after <h2> tag
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        //finding all occurrences of "<h2>" in the string which is being matched by matcher
        matcher.reset();
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        //Using group methods in Matcher
        String h2GroupPattern = "(<h2>.*?</h2>)";
        /*
            If greedy quantifier * is used, it keeps looking for matches even after it has found one,
            for our requirements, we need to use a lazy/reluctant quantifier.

            By adding the ? in front of the *, we turn it from a greedy quantifier into a lazy quantifier.
         */
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));     //group(1) because we are looking for the first group which is <h2>, group 0 is thee whole string
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));    //group(2) because we are looking for the second group, which is (.+?) --> the text between the h2 tags
        }

        /*____________________________________________________________________________*/
        /*__________________________________OPERATORS_________________________________*/
        /*____________________________________________________________________________*/

        /*                                 NOT OPERATOR                               */

        String tvTest = "tstvtkt";                                     //our goal is to find all t's not followed by a v
        String tNotVRegex = "t[^v]";
        /*
            Caret ^ is used as the NOT character in this case, but it consumes a character.
            In other words, there must be a character after t, or else it won't find a match
         */
        Pattern tNotVPattern = Pattern.compile(tNotVRegex);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }



        /*
            - In order to match the last 't' in the string, we must use the ! 'Lookahead Negation Operator'.
            - Lookahead operators do not include the regex specified in the match, they just look for them,
              that is why they are called Lookahead operators.
            - Positive lookahead matcher --> (?!regex)
            - Negative lookahead matcher --> (?=regex)
         */
        tNotVRegex = "t(?!v)";
        tNotVPattern = Pattern.compile(tNotVRegex);
        tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }
    }
}
