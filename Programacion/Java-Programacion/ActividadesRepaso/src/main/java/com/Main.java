package com;

public class Main {
    public static void main(String[] args) {
        String s0 = "Something inside";
        String s1 = "GUAU!";
        String s2 = "The dog says ... ";
        String s3 = new String("The cat says... ");
        String s4 = new String("MIAU!");
        System.out.println("The lowercase value of s0 is : " + s0.toLowerCase());
        System.out.println("The uppercase value of s0 is : " + s0.toUpperCase());
        System.out.println("The value of s1 is : " + s1 + " and has " + s1.length() +
                " characters");
        System.out.println("The value of s2 is : " + s2 + " and has it's first 's' on " +
                s2.indexOf('s') + " position");
        System.out.println("The trimed value of s3 is : \"" + s3.trim() + "\"");
        s2 = s2.concat(s1);
        s3 = s3.concat(s4);
        System.out.println("The concatenation of s2 and s4 is : " + s2);
        System.out.println("The first 5 characters of s3 are : \"" + s3.substring(0, 5) + "\"");
        if (s3.startsWith(s4)) {
            System.out.println("s3 starts with \"" + s4 + "\"");
        }
        else {
            System.out.println("s3 doesn't start with \"" + s4 + "\"");
        }
        if (s3.endsWith(s4)) {
            System.out.println("s3 ends with \"" + s4 + "\"");
        }
        else {
            System.out.println("s3 doesn't end with \"" + s4 + "\"");
        }
        if (s2.contains("dog")) {
            System.out.println("s3 contains the \"dog\" substring");
        }
        else {
            System.out.println("s3 doesn't contains the \"dog\" substring");
        }
        System.out.println("The value of s3 after a replacement : " + s3.replace(s4, s1));
        System.out.println("The value of a boolean false is : " + String.valueOf(false));
        System.out.println("The value of the max int value is : " +
                String.valueOf(Integer.MAX_VALUE));
        String splits[] = s2.split(" ");
        System.out.println("The content of splits is :");
        for(int i = 0; i < splits.length; i++) {
            System.out.println("[" + i + "] : " + splits[i]);
        }
    }
}