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
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int findMedian(List<Integer> arr) {
//         Write your code here
        for (int i = arr.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int value = arr.get(j + 1);
                    arr.set(j + 1, arr.get(j));
                    arr.set(j, value);
                }
            }
        }
        return arr.get(arr.size() / 2);
    }
//        if (arr.size() <= 1000001 && arr.size() % 2 != 0) {
//            for (int i = 0; i < arr.size(); i++) {
//                for (int j = i + 1; j < arr.size(); j++) {
//                    if (arr.get(j) > arr.get(i)) {
//                        int x = arr.get(i);
//                        arr.set(i, arr.get(j));
//                        arr.set(j, x);
//                    }
//                }
//
//            }
//            return arr.get(arr.size() / 2);
//        }
//        return 0;
//    }

}

public class SolutionF {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
