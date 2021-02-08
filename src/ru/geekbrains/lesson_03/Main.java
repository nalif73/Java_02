package ru.geekbrains.lesson_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>(Arrays.asList("Игорь", "Игорь", "Василий",
                "Иван", "Максим", "Андрей", "Николай", "Алексей", "Александр", "Василий", "Игорь",
                "Петр", "Андрей", "Иван"));

        printUniqueWords(arrayList);
        System.out.println();
        printCountWords(arrayList);
        System.out.println();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(234567, "Иванов");
        phoneBook.add(254678, "Петров");
        phoneBook.add(134519, "Иванов");
        phoneBook.add(434343, "Сидоров");
        phoneBook.add(434343, "Кузнецов");  //пытаемся добавить с существующим телефоном в базе
        phoneBook.add(834837, "Петров");
        phoneBook.add(294939, "Петров");
        phoneBook.print();
        System.out.println(phoneBook.get("Кузнецов"));
        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Сидоров"));

    }

    public static void printUniqueWords(List<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int count = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j))) count++;
            }
            if (count == 1) System.out.println("Уникальное слово " + arrayList.get(i));
        }
    }

    public static void printCountWords(List<String> arrayList) {
        Map<String, Integer> arrayMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayMap.containsKey(arrayList.get(i))) {
                int count = 0;
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(i).equals(arrayList.get(j))) count++;
                }
                arrayMap.put(arrayList.get(i), count);
            }
        }
            for (Map.Entry<String, Integer> pair : arrayMap.entrySet()) {
                System.out.println("Слово " + pair.getKey() + " встречается " + pair.getValue() + " раз(а)");
            }
    }
}
