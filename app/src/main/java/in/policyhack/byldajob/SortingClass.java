package in.policyhack.byldajob;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by pujamathur on 19/4/15.
 */
public class SortingClass {

    public static void sortEmployees(double[] ratings, HashMap<Double,Employee> hashMap){
        Arrays.sort(ratings);
        for(int i = ratings.length - 1; i >= 0; i--){
            Employee.chosenEmployee.add(hashMap.get(ratings[i]));
        }
        return;
    }

}
