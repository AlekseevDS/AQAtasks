package collections;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<Integer, String> phoneBook = new HashMap<>();

    public void add(Integer number, String lastName) {
        phoneBook.put(number, lastName);
    }

    public void get(String lastName) {
        for (Map.Entry<Integer, String> entry : phoneBook.entrySet()) {
            String phoneBookValue = entry.getValue();
            if (phoneBookValue.equalsIgnoreCase(lastName)) {
                System.out.println(phoneBookValue + " - " + entry.getKey());
            }
        }
    }
}


