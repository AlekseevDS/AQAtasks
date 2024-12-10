package collections;

import java.util.*;

public class WordsUtils {
    protected static void uniqWords(ArrayList<String> list) {
        System.out.println(new HashSet<>(List.of(list.toArray())));
    }

    protected static void wordsCounter(ArrayList<String> list) {
        Map<String, Integer> cityCount = new HashMap<>();
        for (String city : list) {
            cityCount.put(city, cityCount.getOrDefault(city, 0) + 1);
        }
        System.out.println(cityCount);
    }
}