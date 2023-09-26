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

class Result17 {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size() / 2, res = 0;
        for (int i = 0; i < matrix.size(); i++) {
            int izSup = matrix.get(i).get(0) + matrix.get(i).get(1),
                    derSup = matrix.get(i).get(matrix.size()-1) + matrix.get(i).get(matrix.size()-2),
                    izInf = matrix.get(matrix.size()-1).get(0) + matrix.get(matrix.size()-2).get(0),
                    derInf = matrix.get(matrix.size()-1).get(matrix.size()-1) + matrix.get(matrix.size()-2).get(matrix.size()-1);
            if (izSup>izInf) {

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += matrix.get(i).get(j);
            }
        }
        return res;
    }

}

public class Solution17 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result17.flippingMatrix(matrix);

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
