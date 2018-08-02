/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterfrequency;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ryanprice
 */
public class LetterFrequency {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Map<Character, Integer> letterFreqMap = new HashMap();
        String fileName= "../letters.txt";
        Scanner sc = new Scanner(new File(fileName));
        String currentWord;
        Set<Character> alphabet = new HashSet();
        char[] chars = 
        {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
        'v','w','x','y','z'};
        for( int i = 0; i < chars.length; i++){
            alphabet.add(chars[i]);
        }
        int currentValue;
        char currentLetter;
        while(sc.hasNext()){
            currentWord = sc.next().toLowerCase();
            for(int i = 0; i <currentWord.length(); i++){
                currentLetter = currentWord.charAt(i);
                if(alphabet.contains(currentLetter)){
                    if(letterFreqMap.containsKey(currentLetter)){
                        currentValue= letterFreqMap.get(currentLetter) + 1;
                        letterFreqMap.replace(currentLetter, currentValue);
                    }
                    else{
                        letterFreqMap.put(currentWord.charAt(i), 1);
                    }
                }
            }
        }
        System.out.println(letterFreqMap);
        
    }
    
}
