package main.java.ua.goit.hw10;

/*Задание 5#
Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second),
который "перемешивает" элементы из стримов first и second,
останавливается тогда, когда у одного из стримов закончатся элементы.*/


import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Aufgabe5 {

    public static <L, R, T> Stream<T> zip(Stream<L> leftStream, Stream<R> rightStream, BiFunction<L, R, T> combiner) {
        Spliterator<L> lefts = leftStream.spliterator();
        Spliterator<R> rights = rightStream.spliterator();
        return StreamSupport.stream(new Spliterators.AbstractSpliterator<T>(Long.min(lefts.estimateSize(),
                rights.estimateSize()), lefts.characteristics() & rights.characteristics()) {
            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                return lefts.tryAdvance(left->rights.tryAdvance(right->action.accept(combiner.apply(left, right))));
            }
        }, leftStream.isParallel() || rightStream.isParallel());

    }

    public static void main(String[] args) {
        Stream<String> leftStream = Stream.of("Pavlo", "Petro", "Vasyl", "Ivan", "Stepan", "Semen");
        Stream<String> rightStream = Stream.of("Anna", "Julia", "Helena", "Isabel", "Maria");
        Stream<String> ergebnis = zip(leftStream, rightStream, (a, b) -> a + " is for " + b);

        System.out.println(ergebnis);
    }
}


