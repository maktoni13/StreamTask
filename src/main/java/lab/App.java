package lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class App
 */
public class App {

    public static void main(String[] args) {


    }

    /**
     * Task 1:
     * The method takes a list of names. Returns a string of the form
     * "1. Ivan, 3. Peter ...", only with names on odd indices, respectively.
     *
     * @param nameList
     * @return
     */
    private static String getOddValuesString(List<String> nameList) {
        return IntStream.range(0, nameList.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(index -> "" + (index + 1) + ". " + nameList.get(index))
                .reduce((name1, name2) -> name1 + ", " + name2).orElse("");
    }

    /**
     * Task 2:
     * The method map list of string to uppercase and then sort descending
     *
     * @param stringList
     * @return
     */
    private static List<String> getUppercaseDescList(List<String> stringList) {
        return stringList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * Task 3:
     * Given and collection = Arrays.asList ("1, 2, 0", "4, 5")
     * From the collection get all the numbers listed, separated by commas from all the elements
     *
     * @param stringList
     * @return
     */
    private static List<String> getAllTheNumbers(List<String> stringList) {
        return stringList.stream()
                .flatMap((p) -> Arrays.stream(p.split(",")))
                .collect(Collectors.toList());
    }

    /**
     * Task 4:
     * Using Stream.iterate, make an infinite stream of random numbers —
     * not by calling Math.random but by directly implementing a linear
     * congruential generator. In such a generator, you start with x[0] = seed
     * and then produce x[n + 1] = 1 (a x[n] + c) % m, for appropriate values
     * of a, c, and m. You should implement a method with parameters a, c, m,
     * and seed that yields a Stream<Long>. Try out a = 25214903917, c = 11,
     * and m = 2^48.
     *
     * @param seed - base element of the infinite stream
     * @param a - param of linear congruential generator
     * @param c - param of linear congruential generator
     * @param m - param of linear congruential generator
     * @return Stream<Long>
     */
    private static Stream<Long> getRandomInfinite(Long seed, Long a, Long c, Long m) {
        return Stream.iterate(seed, n -> (((a * n + c) % m)));
    }

    /**
     * Task 5:
     *
     * Write a method public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
     * that alternates elements from the stream first and second, stopping when one of
     * them runs out of elements
     *
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        //List<T> firstList = first.collect(Collectors.toList());
        //List<T> secondList = second.collect(Collectors.toList());
        return null;
    }

}
