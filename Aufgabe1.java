/* VOLODYMYR DINUL
 * GOIT
 * Hausaufgaben #10
 * Aufgabe #1
 * Метод принимает на вход список имен.
 * Вернуть строку в виде: "1. Ivan, 3. Peter ...", с именами из списка,
 * стоящими под нечетным индексом (1, 3 и т.д.).
 * */

package main.java.ua.goit.hw10;

import java.util.Arrays;
import java.util.List;

public class Aufgabe1 {

    // Have no clue whatsoever how to do this with streams
    public static String removing(List<String> reihe) {
        String result = "";
        for (int i = 1; i < reihe.size(); i=i+2) {
            result = result.concat(i + ". ");
            result = result.concat(reihe.get(i) + ", ");
        }
        return result;
    }

    public static void main(String[] args) {
        final List<String> input = Arrays.asList("Pavlo", "Petro", "Vasyl", "Ivan", "Stepan", "Semen", "Mykola");
        String result = removing(input);
        System.out.println(result);
    }
}
