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

class Result16 {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int marsExploration(String s) {
        // Write your code here SOSSOSSOS
        //PPPQQQGGGGGGGGGGGGGGGMMMMMMMMMFFFFFFDDDERT 42   SOSSPSSQSSOR
        int cont = 0, t = 1;
        for (int i = 0; i < s.length(); i++) {
            if (t % 2 != 0) {
                if (s.charAt(i) != 'S') {
                    cont++;
                }
            } else {
                if (s.charAt(i) != 'O') {
                    cont++;
                }
            }
            t++;
            if (t == 4) {
                t = 1;
            }
        }
        return cont;
    }

}

public class Solution16 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result16.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
