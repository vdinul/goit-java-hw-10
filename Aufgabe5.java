package main.java.ua.goit.hw10;

/*Задание 5#
Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second),
который "перемешивает" элементы из стримов first и second,
останавливается тогда, когда у одного из стримов закончатся элементы.*/

/* try to create Iterator for each stream and in the while scope you should
check whether each of the stream has an element. If not, you can leverage shuffle(0) method.*/

import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Aufgabe5 {

    /**
     * https://stackoverflow.com/questions/53307682/how-to-interleave-merge-two-java-8-streams
     **/
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        return interleave(first, second, Stream::of).flatMap(s -> s);
    }

    /**
     * https://stackoverflow.com/questions/17640754/zipping-streams-using-jdk8-with-lambda-java-util-stream-streams-zip
     **/
    private static <A, B, C> Stream<C> interleave(Stream<A> streamA, Stream<B> streamB, BiFunction<A, B, C> zipper) {
        final Iterator<A> iteratorA = streamA.iterator();
        final Iterator<B> iteratorB = streamB.iterator();
        final Iterator<C> iteratorC = new Iterator<C>() {
            @Override
            public boolean hasNext() {
                 return iteratorA.hasNext() && iteratorB.hasNext();
            }

            @Override
            public C next() {
                return zipper.apply(iteratorA.next(), iteratorB.next());
            }
        };
        final boolean parallel = streamA.isParallel() || streamB.isParallel();
        return iteratorToFiniteStream(iteratorC, parallel);
    }

    private static <T> Stream<T> iteratorToFiniteStream(Iterator<T> iterator, boolean parallel) {
        final Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

    public static void main(String[] args) {
        Stream<String> mannlich = Stream.of("Pavlo", "Petro", "Vasyl", "Ivan", "Stepan", "Semen");
        Stream<String> weiblich = Stream.of("Anna", "Julia", "Helena", "Kate", "Maria");
        Stream<String> menschlich = zip(mannlich, weiblich);
        List<String> result = menschlich.collect(Collectors.toList());
        System.out.println(result);
    }
}


