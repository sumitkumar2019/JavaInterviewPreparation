package com.sky.java.preparation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExample {
    public static void main(String[] args) {
        //1st way
        Pattern p = Pattern.compile("..m");
        Matcher m = p.matcher("aim");
        boolean b = m.matches();
        System.out.println(b);

        //2nd way
        boolean b2 = Pattern.compile(".m").matcher("monica").matches();
        System.out.println(b2);

        //3rd way
        boolean b3 = Pattern.matches(".m","am");
        System.out.println(b3);

        //=============================

        System.out.println(Pattern.matches("[amn]","acd"));
        System.out.println(Pattern.matches("[amn]","a"));
        System.out.println(Pattern.matches("[amn]","m"));
        System.out.println(Pattern.matches("[amn]","n"));

        System.out.println(Pattern.matches("[^amn]","a"));
        System.out.println(Pattern.matches("[^amn]","c"));

        System.out.println(Pattern.matches("[a-zA-S]","z"));
        System.out.println(Pattern.matches("[a-zA-S]","T"));
        System.out.println(Pattern.matches("[a-zA-S]","R"));

        System.out.println(Pattern.matches("[a-ds-u]","b"));

        System.out.println(Pattern.matches("[MS][a-z]{5}","Monica"));
        System.out.println(Pattern.matches("[MS][a-z]{5}","Sameer"));
        System.out.println(Pattern.matches("[MS][a-z]{5}","Amit"));
    }
}
