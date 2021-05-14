/* VOLODYMYR DINUL
 * GOIT
 * Hausaufgaben #10
 * Aufgabe #3
 * Дан массив: ["1, 2, 0", "4, 5"]
 * Получить из массива все числа, вернуть в отсортированном виде, разделенные запятой, то есть "0, 1, 2, 4, 5"
 */

package main.java.ua.goit.hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aufgabe3 {
    public static void main(String[] args) {
        String[] reihe = {"1, 2, 0", "4, 5"};
        List<Integer> intReihe = new ArrayList<>();  // the resulting list that will hold the integers
                                                    // we will parse from the original array
        // exctract the integers from the given array of strings
        for (String str : reihe) {
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
                    intReihe.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }
        // in this stream we sort the resulting list of integers
        List<Integer> result = (List<Integer>) intReihe.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
