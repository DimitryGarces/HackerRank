package Basic;


import java.io.*;
import java.util.*;

class Result5 {

    public static String[] metodoC(String texto, int r) {
        // Write your code here
        String[] renglon = new String[r];
        char[] c = texto.toCharArray();
        System.out.println(c.length);
        String cadenaT = "";
        int cont = 0, j = 0;
        for (int i = 0; i < r; i++) {
            do {
                if (j == c.length) {
                    break;
                }
                if (cont == j) {
                    cadenaT += "" + c[j] + c[j + 1] + c[j + 2] + c[j + 3];
                    j += 4;
                    cont++;
                } else {
                    cadenaT += "" + c[j];
                    j++;
                }

            } while ((j != c.length - 1) && ((c[j] != 'S' && c[j + 1] != ';') || (c[j] != 'C' && c[j + 1] != ';')));
            if (j == c.length - 1) {
                cadenaT += c[j + 1];
                renglon[i] = cadenaT;
                cadenaT = "";
                cont = j;
            } else {
                renglon[i] = cadenaT;
                cadenaT = "";
                cont = j;
            }

        }
        for (int i = 0; i < r; i++) {
            cadenaT = renglon[i].substring(4, renglon[i].length());
            char op = renglon[i].charAt(0);
            char op2 = renglon[i].charAt(2);
            switch (op) {
                case 'S':
                    cadenaT = s(cadenaT);
                    switch (op2) {
                        case 'M':
                            if (cadenaT.charAt(cadenaT.length() - 1) == ')') {
                                cadenaT = cadenaT.substring(0, cadenaT.length() - 4);
                                renglon[i] = cadenaT.toLowerCase();
                            }
                            break;
                        case 'C':
                        case 'V':
                            renglon[i] = cadenaT.toLowerCase();
                            break;
                    }
                    break;
                case 'C':
                    cadenaT = co(cadenaT);
                    switch (op2) {
                        case 'M':
                            renglon[i] = mv(cadenaT,'M');
                            break;
                        case 'C':
                            renglon[i] = mv(cadenaT,'C');
                            break;
                        case 'V':
                            renglon[i] = mv(cadenaT,'V');
                            break;
                    }
                    break;
            }
        }
        return renglon;
    }

    public static String s(String cad) {
        char[] c2 = cad.toCharArray();
        cad = "";
        int j = 0;
        while (j != c2.length) {
            String l = "" + c2[j];
            if (l.equals(l.toUpperCase()) && j != 0) {
                cad += " " + l;
                j++;
            } else {
                cad += "" + l;
                j++;
            }
        }
        System.out.println(cad);
        return cad;
    }

    public static String co(String cad) {
        char[] c2 = cad.toCharArray();
        cad = "";
        for (int i = 0; i < c2.length; i++) {
            if (c2[i] == ' ') {
                String c = "" + c2[i + 1];
                c2[i + 1] = c.toUpperCase().charAt(0);
            } else {
                cad += "" + c2[i];
            }
        }
        return cad;
    }

    public static String mv(String cad, char o) {
        char[] c2 = cad.toCharArray();
        cad = "";
        boolean n = false;
        String l = c2[0] + "";
        switch (o) {
            case 'M':
                c2[0] = l.toLowerCase().charAt(0);
                n = true;
                break;
            case 'C':
                c2[0] = l.toUpperCase().charAt(0);
                break;
            default:
                c2[0] = l.toLowerCase().charAt(0);
        }
        for (int i = 0; i < c2.length; i++) {
            cad += c2[i];
        }
        if (n) {
            cad += "()";
        }

        return cad;
    }

}

public class Solution5 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String linea = "";
        while (scanner.hasNextLine()) {
            linea += scanner.nextLine();
        }
        scanner.close();
        int cont = 0;
        for (int i = 0; i < linea.length(); i++) {
            if (linea.charAt(i) == ';') {
                cont++;
            }
        }
        String[] clasif = Result5.metodoC(linea, cont / 2);
        for (int i = 0; i < cont / 2; i++) {
            System.out.println(clasif[i]);
        }

    }
}
