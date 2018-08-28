package com.socgen.test.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

    private Map<Integer, Map<Integer, List<String>>> instance;
    private String fileName;

    public Dictionary(String fileName) {
        this.fileName = fileName;
        instance = new HashMap<>();
    }


    public Map<Integer, Map<Integer, List<String>>> getInstance() {
        return instance;
    }

    public boolean add(String word) {
        word = word.toLowerCase();

        int length = word.length();
        int sum = word.chars().sum();
        synchronized (this) {
            List<String> listOfStringWithSameSum = getListOfStringsWithSameSum(length, sum);
            return listOfStringWithSameSum.contains(word) ? false : listOfStringWithSameSum.add(word);
        }
    }

    public boolean remove(String word) {
        word = word.toLowerCase();

        int length = word.length();
        int sum = word.chars().sum();
        synchronized (this) {
            List<String> listOfStringWithSameSum = getListOfStringsWithSameSum(length, sum);
            return listOfStringWithSameSum.remove(word);
        }
    }

    private List<String> getListOfStringsWithSameSum(int length, int sum) {
        Map<Integer, List<String>> digestEntry = instance.get(length);

        if (digestEntry == null) {
            digestEntry = new HashMap<>();
            instance.put(length, digestEntry);
        }

        List<String> listOfStringWithSameSum = digestEntry.get(sum);
        if (listOfStringWithSameSum == null) {
            listOfStringWithSameSum = new ArrayList<>();
            digestEntry.put(sum, listOfStringWithSameSum);
        }
        return listOfStringWithSameSum;
    }

    public void process() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                this.add(sCurrentLine);
            }
        } catch (IOException e) {

        }
    }
}
