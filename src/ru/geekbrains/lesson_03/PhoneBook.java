package ru.geekbrains.lesson_03;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<Integer, String> mapPhone = new HashMap<>();

    public Map<Integer, String> get(String surmane) {
        if (mapPhone.containsValue(surmane)) {
            Map<Integer, String> getPhone = new HashMap<>();
            for (Map.Entry<Integer, String> pair : mapPhone.entrySet()) {
                if (pair.getValue().equals(surmane)) {
                    getPhone.put(pair.getKey(), pair.getValue());
                }
            }
            return getPhone;
        }
        return null;
    }

    public boolean add(Integer phone, String surname) {
        if (mapPhone.containsKey(phone)) return false;
        mapPhone.put(phone, surname);
        return true;
    }

    public void print() {
        for (Map.Entry<Integer, String> pair : mapPhone.entrySet()) {
            System.out.println(pair.getKey() + "  " + pair.getValue());
        }
    }
}
