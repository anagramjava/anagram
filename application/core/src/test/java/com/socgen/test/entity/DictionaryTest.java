package com.socgen.test.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DictionaryTest {

    private Dictionary  dictionary;

    @Before
    public void setUp(){
        dictionary = new Dictionary(getClass().getClassLoader().getResource("words_duplicate.txt").getPath());
        dictionary.process();
    }


    @Test
    public void testIfWeCanAddSameWordTwice(){
        String word = "bat";
        dictionary.add(word);
        int sizeFirstTime = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();

        dictionary.add(word);
        int sizeSecondTime = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();
        Assert.assertEquals(sizeFirstTime,sizeSecondTime);
    }


    @Test
    public void testIfWeCanAddSameWordTwiceInDifferentCase(){
        String word = "bat";
        dictionary.add(word);
        int sizeFirstTime = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();

        dictionary.add(word.toUpperCase());
        int sizeSecondTime = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();
        Assert.assertEquals(sizeFirstTime,sizeSecondTime);
    }

    @Test
    public void testIfWeCanRemoveWord(){
        String word = "bat";
        dictionary.add(word);
        int sizeFirstTime = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();

        dictionary.remove(word);
        int sizeAfterRemove = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();
        Assert.assertEquals(sizeFirstTime-1,sizeAfterRemove);
    }

    @Test
    public void testIfWeCanRemoveWordDifferentCase(){
        String word = "bat";
        dictionary.add(word);
        int sizeFirstTime = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();

        dictionary.remove(word.toUpperCase());
        int sizeAfterRemove = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();
        Assert.assertEquals(sizeFirstTime-1,sizeAfterRemove);
    }

    @Test
    public void testIfWeCanCallRemoveTwice(){
        String word = "bat";
        dictionary.add(word);
        int sizeFirstTime = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();

        dictionary.remove(word);
        int sizeAfterRemove = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();
        Assert.assertEquals(sizeFirstTime-1,sizeAfterRemove);
        dictionary.remove(word);
        int sizeAfterRemoveTwice = dictionary.getInstance().get(word.length()).get(word.chars().sum()).size();
        Assert.assertEquals(sizeFirstTime-1,sizeAfterRemoveTwice);
    }

}
