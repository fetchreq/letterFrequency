/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterfrequency;

/***********************
For graphs 
************************/
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;

        
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
        Iterator mapValues = letterFreqMap.values().iterator();
        System.out.println(letterFreqMap);
        List<Double> freqValues = new ArrayList();
        while(mapValues.hasNext()){
            freqValues.add((Double) mapValues.next());
        }
        displayGraph(chars2, freqValues);

    }
    
    public static void displayGraph(List xAxis, List yAxis){
        CategoryChart chart = new CategoryChartBuilder().height(600).title("Letter Frequency").xAxisTitle("Letters").yAxisTitle("Times Seen").build();
        chart.addSeries("Frequency", xAxis, yAxis);
        new SwingWrapper(chart).displayChart();
    }
    
}
