package Basic;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result0 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int[] m = {0, 0, 0};
        int v, t=arr.size();
        for (int i = 0; i < t; i++) {
            v = arr.get(i);
            if (v > 0) {
                m[0] += 1;
            } else if (v < 0) {
                m[1] += 1;
            } else {
                m[2] += 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            if(m[i]!=0){
                double d =(double)m[i]/(double)t;
                System.out.println(String.format("%.6f", d));
            }else{
                double d=0;
                System.out.println(String.format("%.6f", d));
            }
        }
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result0.plusMinus(arr);

        bufferedReader.close();
    }
}
