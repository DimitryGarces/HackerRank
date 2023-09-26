package Basic;


import java.io.*;

class Result3 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        // Write your code here
        String horaN = "";
        String h = s.substring(0, 2);
        if (s.contains("AM") && h.equals("12")) {
            horaN += "00" + s.substring(2, s.length() - 2);
        } else if (s.contains("AM")) {
            horaN += s.substring(0, s.length() - 2);
        } else if (s.contains("PM") && h.equals("12")) {
            horaN += "12" + s.substring(2, s.length() - 2);
        } else {
            int x = Integer.parseInt(h);
            x += 12;
            horaN += x + s.substring(2, s.length() - 2);
        }
        return horaN;
    }

}

public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result3.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
