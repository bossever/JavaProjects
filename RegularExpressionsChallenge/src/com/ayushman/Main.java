package com.ayushman;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //challenge1
        String challenge1 = "I want a bike.";
        String challenge1Regex = "I want a bike.";
        System.out.println(challenge1Regex.matches(challenge1));

        //challenge2
        String challenge2 = "I want a ball.";
        String challenge2Regex = "^I want a .*";        //"I want a (ball|bike)." can also be used
        System.out.println(challenge1.matches(challenge2Regex) + ", " + challenge2.matches(challenge2Regex));

        //challenge3
        Pattern patternChallenge3 = Pattern.compile(challenge2Regex);
        Matcher matcherChallenge3 = patternChallenge3.matcher(challenge2);
        System.out.println(matcherChallenge3.matches());

        //challenge4
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        //challenge5
        String challenge5 = "aaabccccccccdddefffg";
        String challenge5Regex = "[a-g]+";
        System.out.println(challenge5.matches(challenge5Regex));

        //challenge6
        String challenge6 = "aaabccccccccdddefffg";
        String challenge6Regex = "a{3}bc{8}d{3}ef{3}g";
        System.out.println(challenge6.matches(challenge6Regex));

        //challenge7
        String challenge7 = "abcd.135";
        String challenge7Regex = "^[a-zA-Z]+\\.\\d+$";
        System.out.println(challenge7.matches(challenge7Regex));

        //challenge8
        String challenge8 = "abcd.135uvqz.7tzik.999";
        String challenge8Regex = "[a-zA-Z]+\\.(\\d+)";
        Pattern patternChallenge8 = Pattern.compile(challenge8Regex);
        Matcher matcherChallenge8 = patternChallenge8.matcher(challenge8);
        while (matcherChallenge8.find()) {
            System.out.println("Occurrence : " + matcherChallenge8.group(1));
        }

        //challenge9
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        String challenge9Regex = "[a-zA-Z]+\\.(\\d+)\\s";
        Pattern patternChallenge9 = Pattern.compile(challenge9Regex);
        Matcher matcherChallenge9 = patternChallenge8.matcher(challenge9);
        while (matcherChallenge9.find()) {
            System.out.println("Occurrence : " + matcherChallenge9.group(1));
        }

        //challenge10
        String challenge10 = "abcd.135uvqz.7tzik.999";
        String challenge10Regex = "[a-zA-Z]+\\.(\\d+)";
        Pattern patternChallenge10 = Pattern.compile(challenge10Regex);
        Matcher matcherChallenge10 = patternChallenge10.matcher(challenge10);
        while (matcherChallenge10.find()) {
            System.out.println("Occurrence : " + matcherChallenge10.group(1) + " from " + matcherChallenge10.start(1) + " to " + (matcherChallenge10.end(1) - 1));
        }

        //challenge11
        //challenge8
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        String challenge11Regex = "\\{(\\d+, \\d+)\\}";
        Pattern patternChallenge11 = Pattern.compile(challenge11Regex);
        Matcher matcherChallenge11 = patternChallenge11.matcher(challenge11);
        while (matcherChallenge11.find()) {
            System.out.println("Occurrence: " + matcherChallenge11.group(1));
        }

        //challenge12
        String challenge12 = "11111";
        String challenge12Regex = "^\\d{5}$";
        System.out.println(challenge12.matches(challenge12Regex));

        //challenge13
        String challenge13 = "11111-1111";
        String challenge13Regex = "^\\d{5}(-\\d{4})?$";
        System.out.println(challenge13.matches(challenge13Regex));

    }
}
