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
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int res = 0;
        List<Integer> arrAux = new ArrayList<Integer>();
        for (int i = 0; i < s.size(); i++) {
            int sumAux = s.get(i);
            if (!arrAux.contains(sumAux)) {
                int x = i + (m - 1);
                List<Integer> temp = new ArrayList<Integer>(), temp2 = new ArrayList<Integer>();
                temp = s;
                temp2 = arrAux;
                if (x < s.size()) {
                    for (int j = i + 1; j <= x; j++) {
                        if (j < s.size()) {
                            sumAux += s.get(j);
                            arrAux.add(s.get(j));
                            s.remove(j);
                        }
                    }
                    s.remove(i);
                    if (sumAux == d) {
                        res++;
                    } else {
                        s = temp;
                        arrAux = temp2;
                    }
                } else if (s.size() >= m) {
                    for (int i2 = 0; i2 < s.size() - 1; i2++) {
                        for (int j = 0; j < s.size() - i2 - 1; j++) {
                            if (s.get(j) < s.get(j + 1)) {
                                int aux = s.get(j + 1);
                                s.set(j + 1, s.get(j));
                                s.set(j, aux);
                            }
                        }
                    }
                    res += birthday(s, d, m);
                }
            } else {
                arrAux.add(sumAux);
                s.remove(i);
                i = -1;
            }
        }
        return res;
    }
}

public class Solution18 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
