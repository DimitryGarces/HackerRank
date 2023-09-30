
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

/**
 *
 * @author Diego
 */
class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int np = 0;
        Set<Integer> sockSet = new HashSet<>();

        for (Integer sock : ar) {
            if (sockSet.contains(sock)) {
                np++;
                sockSet.remove(sock);
            } else {
                sockSet.add(sock);
            }
        }

        return np;

        /*
        Option alternatve :
        int np = 0;
        boolean v = true;
        while (ar.size() >= 2 && v) {
            v = false;
            if (ar.size() == 2) {
                if (ar.get(0).equals(ar.get(1))) {
                    np++;
                }
                return np;
            }
            for (int i = 1; i < ar.size(); i++) {
                if (ar.get(0).equals(ar.get(i))) {
                    ar.remove(i);
                    ar.remove(0);
                    np++;
                    v = true;
                    break;
                }
            }
            if (ar.size() >= 2 && !v) {
                v = true;
                ar.remove(0);
            }
        }
        return np;
         */
    }

}

public class Solution20 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
