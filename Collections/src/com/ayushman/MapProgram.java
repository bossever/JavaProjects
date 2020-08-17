package com.ayushman;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {

        Map<String,String> languages = new HashMap<>();
        languages.put("Java", "a compiled, high level, platform independent, object oriented programming language");
        languages.put("Python", "an interpreted, object oriented, high-level programming language");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All Purpose Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        }
        else {
            System.out.println(languages.put("Java", "This course is about Java"));
        }

//        languages.remove("Lisp");
        if (languages.remove("Algol", "a family of algorithmic languages")) {
            System.out.println("Algol removed");
        }
        else {
            System.out.println("Algol not removed");
        }

        System.out.println(languages.replace("Lisp", "a functional programming language with imperative features"));
        System.out.println(languages.replace("Scala", "this will not be added"));

        
        System.out.println("======================================");
        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
        System.out.println("======================================");
    }
}
