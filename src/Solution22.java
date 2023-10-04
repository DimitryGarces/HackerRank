
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
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */
    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Write your code here
        List<Integer> res = new ArrayList();
        sticks.sort(null);
        for (int i = 2; i < sticks.size(); i++) {
            if (isTriangle(sticks.get(i - 2), sticks.get(i - 1), sticks.get(i))) {
                int triplet = sticks.get(i - 2) + sticks.get(i - 1) + sticks.get(i);
                if (!res.isEmpty()) {
                    int aux = res.get(0) + res.get(1) + res.get(2);
                    if (triplet > aux) {
                        res = new ArrayList();
                        res.add(sticks.get(i - 2));
                        res.add(sticks.get(i - 1));
                        res.add(sticks.get(i));
                    }
                } else {
                    res.add(sticks.get(i - 2));
                    res.add(sticks.get(i - 1));
                    res.add(sticks.get(i));
                }

            }
        }
        return res.isEmpty() ? List.of(-1) : res;
    }

    private static boolean isTriangle(int a, int b, int c) {
        return a + b > c;
    }

}

public class Solution22 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
