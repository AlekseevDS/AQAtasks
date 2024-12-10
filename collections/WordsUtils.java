package collections;

import java.util.*;

public class WordsUtils {
    protected static void uniqWord(ArrayList<String> list) {
        System.out.println(new HashSet<>(List.of(list.toArray())));
    }

    protected static void wordCounter(ArrayList<String> list) {
        Map<String, Integer> wordCounterMap = new HashMap<>();
        for (String word : list) {
            wordCounterMap.put(word, wordCounterMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCounterMap);
    }
}