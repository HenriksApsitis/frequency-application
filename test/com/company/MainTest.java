package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class MainTest {
    Main mainTest = new Main();

    @Test
    void getUsedLetterCount() throws FileNotFoundException {
        System.out.println("Running test No.2.");
        String filePath = "testText.txt";
        String tempData = mainTest.readFileToStringLowerCase(filePath);
        HashMap<Character, Integer> tempFrequencyHashMap = mainTest.frequencyFinder(tempData);
        Integer result = mainTest.getUsedLetterCount(tempFrequencyHashMap);
        Integer expected = 18;
        Assertions.assertEquals(expected, result);
        System.out.println("Done");
    }

    @Test
    void frequencyFinder() throws FileNotFoundException {
        System.out.println("Running test No.3.");
        String filePath = "testText.txt";
        String tempData = mainTest.readFileToStringLowerCase(filePath);
        HashMap<Character, Integer> result = mainTest.frequencyFinder(tempData);
        HashMap<Character, Integer> expected = new HashMap<Character, Integer>();
        expected.put('a',5);
        expected.put('b',2);
        expected.put('c',2);
        expected.put('d',3);
        expected.put('e',9);
        expected.put('h',1);
        expected.put('i',8);
        expected.put('l',3);
        expected.put('m',4);
        expected.put('n',8);
        expected.put('o',3);
        expected.put('p',2);
        expected.put('r',3);
        expected.put('s',6);
        expected.put('t',6);
        expected.put('u',2);
        expected.put('v',1);
        expected.put('w',1);
        Assertions.assertEquals(expected, result);
        System.out.println("Done");
    }

    @Test
    public void readFileToStringLowerCase() {
        System.out.println("Running test No.4.");

        String filePath = "testText.txt";
        String resultData = null;
        try {
            resultData = mainTest.readFileToStringLowerCase(filePath);

        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
        String expected = "impossible considered invitation him men instrument saw celebrated unpleasant.";
        Assertions.assertEquals(expected, resultData);
        System.out.println("Done");
    }
}