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

class Result14 {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        // Write your code here DDUUDDUDUUUD    UDDDUDUU
        // 398
        int res = 0, ar = 0, ab = 0, nivel = 0;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                nivel++;
                if (nivel <= 0) {
                    ar++;
                    if (ar == ab) {
                        res++;
                        ar = ab = 0;
                    }
                }
            } else {
                if (nivel <= 0) {
                    ab++;
                }
                nivel--;
            }

        }
        return res;
    }

}

public class Solution14 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result14.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
