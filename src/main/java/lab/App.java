package lab;

import java.util.*;
import java.util.function.Consumer;
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
     * @param nameList - input names list
     * @return - formatted string with odd elements
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
     * @param stringList - input strings list
     * @return - upper cased list with reverse order sorting
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
     * @param stringList - input list with numbers strings to split
     * @return - list after splitting
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
     * @param first - first input stream
     * @param second - second input stream
     * @param <T> - type
     * @return alternate stream
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Stream.Builder<T> builder = Stream.builder();
        Iterator<T> firstIterator = first.iterator();
        second.forEachOrdered(new Consumer<T>() {
            @Override
            public void accept(T t) {
                if(firstIterator.hasNext()){
                    builder.accept(firstIterator.next());
                    builder.accept(t);
                }
            }
        });
        return builder.build();
    }

    /**
     * Task 6(Optional):
     * It should be possible to concurrently collect stream results in a single ArrayList,
     * instead of merging multiple array lists, provided it has been constructed with the
     * stream's size, since concurrent set operations at disjoint positions are threadsafe.
     * How can you achieve this?
     *
     */
    public static <T> List<T> concurrentCollect(Stream<List<T>> listStream){
        List<T> resultList = new ArrayList<>();
//        final Long size = listStream.flatMap(Collection::stream).spliterator().getExactSizeIfKnown();
//        if (size != -1L){
//
//        }
        return resultList;
    }


}
