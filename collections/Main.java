package collections;

import java.util.*;
import static collections.WordsUtils.uniqWords;
import static collections.WordsUtils.wordsCounter;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> cityList = new ArrayList<>(Arrays.asList(
                "Москва", "Санкт-Петербург", "Казань", "Новосибирск",
                "Екатеринбург", "Москва", "Казань", "Сочи",
                "Владивосток", "Калининград", "Сочи", "Москва",
                "Самара", "Уфа", "Новосибирск"));

        PhoneBook testPhoneBook = new PhoneBook();
        testPhoneBook.add(5433, "Иванов");
        testPhoneBook.add(4321, "Петров");
        testPhoneBook.add(2232, "Сидоров");
        testPhoneBook.add(4532, "Карпов");
        testPhoneBook.add(6754, "Иванов");

        uniqWords(cityList);
        wordsCounter(cityList);
        testPhoneBook.get("Иванов");
    }
}