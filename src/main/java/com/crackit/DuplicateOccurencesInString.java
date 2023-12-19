package com.crackit;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateOccurencesInString {
    public static void main(String[] args) {
        String str1 = "Welcome to crackit youtube channel." +
                " Crackit youtube channel helps to understand the concepts clear for your interviews.";

        //Find duplicate words in a String
        List<String> wordsList = Arrays.stream(str1.toLowerCase().split(" ")).collect(Collectors.toList());
        Set<String> tempSet = new HashSet<>();
        List<String> collect = wordsList.stream().filter(
                w -> !tempSet.add(w)
        ).collect(Collectors.toList());
        System.out.println(collect);

        //Find occurences of a string
        Map<String, Integer> collect1 = wordsList.stream().collect(Collectors.toMap(
                Function.identity(),
                w -> 1,
                Math::addExact
        ));
        System.out.println(collect1);

        //Find duplicate occurences only
        Map<String, Integer> collect2 = collect1.entrySet().stream()
                .filter(s -> s.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect2);


    }
}

/****
 * convert this string lowercase
 * Convert String to array of words
 * Identify the words that are duplicated
 * Set -> not allow duplicate elements
 */

/****
 * convert this string lowercase
 * Convert String to array of words
 * map -> (k-> word, v-> no.of times)
 */