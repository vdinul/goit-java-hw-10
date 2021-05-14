/* VOLODYMYR DINUL
 * GOIT
 * Hausaufgaben #10
 * Aufgabe #2
 * Метод принимает на вход список из строк (можно список из Задания 1).
 * Возвращает список этих строк в верхнем регистре и отсортированные по убыванию (от Z до А).
 */

package main.java.ua.goit.hw10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Aufgabe2 {

    public static List<String> sorting(List<String> reihe) {
        List<String> result = reihe.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return result;
    }

    public static void main(String[] args) {
        final List<String> input = Arrays.asList("Pavlo", "Petro", "Vasyl", "Ivan", "Stepan", "Semen");
        List<String> result = sorting(input);

        System.out.println(result);
    }
}
