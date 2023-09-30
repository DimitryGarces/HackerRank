/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic;

import java.io.*;
import java.util.*;

/**
 *
 * @author Diego
 */

//NOTE: This exercise no working, anybody can run successfull, however this is my solution
public class Solution19 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line1 = br.readLine().toCharArray();
        char[] line2 = br.readLine().toCharArray();

        String res = "";
        for (int i = 0; i < line1.length; i++) {
            if (line1[i] != line2[i]) {
                res += "1";
            } else {
                res += "0";
            }
        }
        System.out.println(res);
    }
}
