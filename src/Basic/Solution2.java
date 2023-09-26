package Basic;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(j)>arr.get(i)) {
                     int x=arr.get(i);
                     arr.set(i, arr.get(j));
                     arr.set(j, x);
                }
            }
            
        }
    long min=0, max=0;
        for (int i = 1; i < arr.size(); i++) {
            min+=arr.get(i);
        }
        for (int j = 0; j < arr.size()-1; j++){
            max+=arr.get(j);
        }
        System.out.println(min+" "+max);
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result2.miniMaxSum(arr);

        bufferedReader.close();
    }
}
