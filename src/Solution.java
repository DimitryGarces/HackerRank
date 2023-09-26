
import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

class Result {

    public static String XOR(String one, String two) {
        // Write your code here
        return "";
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String one =bufferedReader.readLine().trim();
        String two =bufferedReader.readLine().trim();

        String res = Result.XOR(one, two);

        bufferedWriter.write(res);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
