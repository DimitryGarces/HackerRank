package Basic;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void fizzBuzz(int n) {

        List<String> strings = new ArrayList<String>();
        strings.add("FizzBuzz");
        strings.add("Fizz");
        strings.add("Buzz");
        for (int i =1 ; i<=n ; i++) {
            if ((i % 3) == 0 && (i % 5) == 0) {
                System.out.println(strings.get(0));
            }else if((i % 3) == 0 && (i % 5) != 0){
                System.out.println(strings.get(1));
            }else if((i % 3) != 0 && (i % 5) == 0){
                System.out.println(strings.get(2));
            }else {
                System.out.println(i);
            }

        }
    }

}

public class Solution8 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.fizzBuzz(n);

        bufferedReader.close();
    }
}
