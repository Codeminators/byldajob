package in.policyhack.byldajob;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pujamathur on 19/4/15.
 */
public class SortingClass {

    public static ArrayList<Employee> sortEmployees(int[] ratings, HashMap<Integer,Employee> hashMap){
        ArrayList<Employee> sorted = new ArrayList<>();
        bubbleSort(ratings);
        for(int i = ratings.length - 1; i >= 0; i++){
            sorted.add(hashMap.get(ratings[i]));
        }
        return sorted;
    }

    private static void bubbleSort(int[] input){
        for(int i=0; i<input.length;i++){
            for(int j=0; j<input.length-i-1; j++){
                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
    }
}
