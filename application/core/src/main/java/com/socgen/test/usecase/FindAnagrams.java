package com.socgen.test.usecase;

import com.socgen.test.entity.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAnagrams {

    private Dictionary dictionary;

    public FindAnagrams(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> findAnagrams(String enteredWord) {

        enteredWord = enteredWord.toLowerCase();

        List<String> anagrams = new ArrayList<>();

        String sortedEnteredWord = Stream.of(enteredWord.toLowerCase().split(""))
                .sorted().collect(Collectors.joining());

        List<String> allWordsWithSameCharacterSum =
                dictionary.getInstance()
                        .getOrDefault(enteredWord.length(), new HashMap<>()).get(enteredWord.chars()
                        .sum());

        if (allWordsWithSameCharacterSum == null) {
            return anagrams;
        }

        anagrams = allWordsWithSameCharacterSum.stream().filter(word ->
                sortedEnteredWord
                        .equals(Stream.of(word.split(""))
                                .sorted
                                        ().collect(Collectors.joining()))
        ).collect(Collectors.toList());

        anagrams.remove(enteredWord);

        return anagrams;
    }
}
