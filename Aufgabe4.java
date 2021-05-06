/* VOLODYMYR DINUL
 * GOIT
 * Hausaufgaben #10
 * Aufgabe #4
 * Используя Stream.iterate сделайте бесконечный стрим рандомных чисел,
 * но не используя Math.random. Реализуйте свой "линейный конгруэнтный генератор".
 * для этого начните с x[0] = seed и затем каждый следующий элемент x[n + 1] = 1 (a x[n] + c) % m,
 * для корректных значений a, c, и m.
 * Необходимо имплементировать метод, который принимает на вход параметры a, c, m и seed и возвращает Stream<Long>.
 * Для теста используйте данные a = 25214903917, c = 11 и m = 2^48 (2 в степени 48).
 */

package main.java.ua.goit.hw10;

import java.util.stream.Stream;

public class Aufgabe4 {

    public static Stream<Long> generadorCongruencialLineal(Long seed, Long a, Long c, Long m) {
        Stream<Long> stream = Stream.iterate(seed, i -> ( a * i + c) % (m))
                .limit(10);
        return stream;
    }

    public static void main(String[] args) {
        Long seed = 2L;
        Long a = 25214903917L;
        Long c = 11L;
        Long m = (2^48L);

        Stream<Long> stream = generadorCongruencialLineal(seed, a, c, m);
        stream.forEach(System.out::println);
    }
}
