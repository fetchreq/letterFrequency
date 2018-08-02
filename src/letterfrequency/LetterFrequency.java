/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterfrequency;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
        
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;

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
        Map<Character, Double> letterFreqMap = new HashMap();
        String fileName= "../letters.txt";
        Scanner sc = new Scanner(new File(fileName));
        String currentWord;
        Set<Character> alphabet = new HashSet();
        List<String> chars2= new ArrayList(); 
        char[] chars = 
        {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
        'v','w','x','y','z'};
        String[] chars3 =
        {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u",
        "v","w","x","y","z"};
        double[]nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        for( int i = 0; i < chars.length; i++){
            alphabet.add(chars[i]);
            chars2.add(chars3[i]);
        }

        
        double currentValue;
        char currentLetter;
        while(sc.hasNext()){
            currentWord = sc.next().toLowerCase();
            for(int i = 0; i <currentWord.length(); i++){
                currentLetter = currentWord.charAt(i);
                if(alphabet.contains(currentLetter)){
                    if(letterFreqMap.containsKey(currentLetter)){
                        currentValue= (letterFreqMap.get(currentLetter) + 1.0);
                        letterFreqMap.replace(currentLetter, currentValue);
                    }
                    else{
                        letterFreqMap.put(currentWord.charAt(i), 1.0);
                    }
                }
            }
        }
        System.out.println(letterFreqMap);
        List<Double> freqValues = new ArrayList();
        for(int i= 0; i< chars.length; i++){
            freqValues.add(letterFreqMap.get(chars[i]));
        }
        CategoryChart chart = new CategoryChartBuilder().height(600).title("Letter Frequency").xAxisTitle("Letters").yAxisTitle("Times Seen").build();
        chart.addSeries("Frequency", chars2, freqValues);
        
        new SwingWrapper(chart).displayChart();
    }
    
}
