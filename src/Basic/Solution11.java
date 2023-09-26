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
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */
    public static long flippingBits(long n) {
        // Write your code here
        if (n < 0) {
            return 0;
        }
        StringBuilder binario = new StringBuilder();
        while (n > 0) {
            int residuo = (int) (n % 2);
            n = n / 2;
            binario.insert(0, String.valueOf(residuo));
        }
        while (binario.length() < 32) {
            binario.insert(0, 0);
        }
        long res = 0;
        int v = 0;
        for (int i = binario.length() - 1; i >= 0; i--) {
            if (binario.toString().charAt(i) == '0') {
                res += Math.pow(2, v);
            }
            v++;
        }
        return res;
    }

}

public class Solution11 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result.flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
