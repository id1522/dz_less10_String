package com.company;


public class Doc {
    private static String doc = "1234-dog-4567-cat-2d3s";

    public Doc() {

    }

    public static String info() {
        System.out.println("1) блоки из трех букв заменить на *** : \n" + doc.replace("1234-dog-4567-cat-2d3s", "1234-***-4567-***-2d3s"));
        System.out.println("2) в одну строку два первых блока по 4 цифры : \n" + (doc = doc.substring(0, 4) + doc.substring(9, 13)));
        System.out.println("3) буквы из номера документа в нижнем регистре :  \nLetters:" + doc.join("/", "dog", "cat", "d", "s"));
        System.out.println("4) буквы из номера документа в верхнем регистре : \nLetters:" + doc.join("/", "dog", "cat", "d", "s").toUpperCase());
        System.out.println("5) Проверить содержит ли номер документа последовательность abc  : \n" + doc.contains("abc"));
        System.out.println("6) Проверить начинается ли номер документа с последовательности 555 : \n" + doc.startsWith("555"));
        System.out.println("7) Проверить заканчивается ли номер документа напоследовательность 1a2b : \n" + doc.endsWith("1a2b"));
        return doc;
    }

}