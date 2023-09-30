
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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        ArrayList<Integer> type = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        for (int i = 0; i < arr.size(); i++) {
            switch (arr.get(i)) {
                case 1 -> {
                    type.set(0, type.get(0) + 1);
                }
                case 2 -> {
                    type.set(1, type.get(1) + 1);
                }
                case 3 -> {
                    type.set(2, type.get(2) + 1);
                }
                case 4 -> {
                    type.set(3, type.get(3) + 1);
                }
                default -> {
                    type.set(4, type.get(4) + 1);
                }
            }
        }
        int mayor = 0;
        for (int i = 0; i < type.size(); i++) {
            for (int sig = i + 1; sig < type.size(); sig++) {
                if (type.get(mayor) < type.get(sig)) {
                    mayor = sig;
                    i = sig - 1;
                    break;
                }
            }

        }
        return mayor + 1;
    }

}

public class Solution21 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
