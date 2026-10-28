package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        class MinMax {
            T min, max;
            boolean empty = true;

            void add(T e){
                if (empty){
                    min = max = e;
                    empty = false;
                } else {
                    if (order.compare(e, min) < 0) min = e;
                    if (order.compare(e, max) > 0) max = e;
                }
            }
        }

        MinMax mima = new MinMax();
        stream.forEach(mima::add);

        if(mima.empty){
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(mima.min, mima.max);
        }
    }
}
