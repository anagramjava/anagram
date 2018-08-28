package com.socgen.test.rest;

import com.socgen.test.entity.Dictionary;
import com.socgen.test.usecase.FindAnagrams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WordEndpoint {

    private Dictionary dictionary;
    private FindAnagrams findAnagrams;

    public WordEndpoint(Dictionary dictionary, FindAnagrams findAnagrams) {
        this.dictionary = dictionary;
        this.findAnagrams = findAnagrams;
    }

    @GetMapping(value = "anagrams/{word}")
    public ResponseEntity<List<String>> getAnagrams(@PathVariable String word){
        return new ResponseEntity<>(findAnagrams.findAnagrams(word) , HttpStatus.OK);
    }

    @PostMapping(value = "words")
    public ResponseEntity<Object> addWordToDictionary(@RequestBody Map<String, String> body){
        return new ResponseEntity<>(dictionary.add(body.get("word")) , HttpStatus.OK);
    }

    @DeleteMapping(value = "words")
    public ResponseEntity<Object> removeWordToDictionary(@RequestBody Map<String, String> body){

        return new ResponseEntity<>(dictionary.remove(body.get("word")) , HttpStatus.OK);
    }
}
