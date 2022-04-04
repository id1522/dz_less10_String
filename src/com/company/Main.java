package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Doc.info();

        String text = "my name is Bob and I like eating";
        System.out.println("Bob talks: "+text);

        StringTokenizer st = new StringTokenizer(text);
        StringTokenizer st1 = new StringTokenizer(text);
        int maxLengthOfWord = 0;
        int minLengthOfWord1 = 0;
        String myText = "";
        String myText1 = "";

        while (st.hasMoreTokens()) {
            while (st1.hasMoreTokens()) {
                String word1 = st1.nextToken();
                int word1Length = word1.length();
                if (minLengthOfWord1 == 0) {
                    myText1 = word1;
                    minLengthOfWord1 = word1Length;
                } else if (word1Length < minLengthOfWord1) {
                    minLengthOfWord1 = word1Length;
                    myText1 = word1;
                }
            }
            String word = st.nextToken();
            int wordLength = word.length();
            if (maxLengthOfWord == 0) {
                myText = word;
                maxLengthOfWord = wordLength;
            } else if (wordLength > maxLengthOfWord) {
                maxLengthOfWord = wordLength;
                myText = word;
            }
        }
        if (maxLengthOfWord > 0) {
            if (minLengthOfWord1 > 0)
                System.out.println("Min  word = " + myText1);

            else {
                System.out.println("No word in string!");

            }
            System.out.println("Max  word = " + myText);
        } else {
            System.out.println("No word in string!");

        }

        String str = "fffff ab f 1234 jkjk";
        System.out.println(getWordWithMinimumDifferentChars(str));
    }

    public static String getWordWithMinimumDifferentChars(String src) {
        return Arrays.stream(src.replaceAll("\\p{Punct}", "").split("\\s+"))
                .map(PairStrDistChar::new)
                .max(Comparator.comparing(PairStrDistChar::getDiffRealCountCharVsDistChar))
                .toString();
        // \p{Punct}	Пунктуация: один из !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
        // \\s+         один или больше space символов, то же что и [\n\t\r\f]
    }

    private static class PairStrDistChar {
        String word;
        int diffRealCountCharVsDistChar;

        public PairStrDistChar(String word) {
            this.word = word;
            this.diffRealCountCharVsDistChar = word.length() / (int) word.chars().distinct().count();
        }

        public int getDiffRealCountCharVsDistChar() {
            return diffRealCountCharVsDistChar;
        }

        @Override
        public String toString() {
            return "word='" + word + '\'' +
                    ", countDisChar=" + diffRealCountCharVsDistChar +
                    '}';
        }
    }
}






