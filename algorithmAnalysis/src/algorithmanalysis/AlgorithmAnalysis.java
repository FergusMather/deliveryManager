/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmanalysis;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author fergus
 */
public class AlgorithmAnalysis {

    public static int[] randomArray(int arrLength, int numberVariance){
        //generate random array
        Random random = new Random();
        int[] output = new int[arrLength];
        
        //populate array with random integers
        for(int i = 0; i < output.length; i++){
            output[i] = random.nextInt(numberVariance);
        }
        
        return output;
    }
    
    public static int[] countSort(int[] array){
        
        //ouput initial array
        System.out.println(Arrays.toString(array));
        int comparisons = 0;
        int copies = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        //find the min and max value
        for(int i = 0; i<array.length; i++){
            comparisons ++;
            if(array[i]< min){
                min = array[i];
            }
            comparisons ++;
            if(array[i] > max){
                max = array[i];
            }
        }
        
        //create an array to store frequencies for array elements
        //and store count for each character
        int[] frequencies = new int[max - min + 1];
        for(int i = 0; i<array.length; i++){
            comparisons ++ ;
            frequencies[array[i]-min]++;
            
        }
        
        int outPos = 0;
        //generate the output array using frequencies(sorted from min to high)
        //of course the range of values fall in [min: max]
        for (int i = 0; i<frequencies.length; i++){
            for(int j = 0; j<frequencies[i]; j++){
                comparisons ++;
                array[outPos++] = i + min;
            }
        }
        System.out.println(comparisons);
        return array;
                
    }
    
    public static int[] selectionSort(int[] array){
        
        //ouput initial array
        System.out.println(Arrays.toString(array));
        
        int arrayLength = array.length;
        
        //One by one move the boundary of the unsorted subarray
        //So from element 0 to element length - 1
        for(int iteration = 0; iteration < arrayLength - 1; iteration++){
            //Find the minimum element in unsorted array
            int min_index = iteration;
            for(int j = iteration + 1; j < arrayLength; j++){
                if(array[j] < array[min_index]){
                    min_index = j;
                }
            }        
        
        //Swap the found minimum element with the first element
        int temp = array[min_index];
        array[min_index] = array[iteration];
        array[iteration] = temp;
        }
        
        return array;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Test algorithms
        System.out.println("hello\n");
        System.out.println(Arrays.toString(countSort(randomArray(100,2))) + "\n");
        //System.out.println(Arrays.toString(selectionSort(randomArray(10,10))) + "\n");
    }
    
}