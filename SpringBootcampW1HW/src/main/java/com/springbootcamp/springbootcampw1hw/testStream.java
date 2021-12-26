package com.springbootcamp.springbootcampw1hw;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testStream {

    public static void main(String[] args){

        testStreams();

    }

    public static void testStreams(){
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 8, 6, 3, 5, 3, 6, 2, 9));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 3, 4, 6, 7, 9));
        List<List<String>> arr3 = new ArrayList<>();
        arr3.add(new ArrayList<>(Arrays.asList("One", "Ring")));
        arr3.add(new ArrayList<>(Arrays.asList("To", "Rule", "Them", "All")));

        List<Integer> ls = arr1.stream().map(num -> num*num).collect(Collectors.toList());
        System.out.println("Java map : " + ls);

        ls = Stream.concat(arr1.stream(), arr2.stream()).collect(Collectors.toList());
        System.out.println("Java concat : " + ls);

        ls = arr1.stream().distinct().collect(Collectors.toList());
        System.out.println("Java distinct : " + ls);

        ls = arr1.stream().filter(number -> !arr2.contains(number)).collect(Collectors.toList());
        System.out.println("Java difference : " + ls);

        ls = arr1.stream().skip(2).collect(Collectors.toList());
        System.out.println("Java drop : " + ls);

        ls = arr1.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println("Java filter : " + ls);

        List<String> lsS = arr3.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("Java flatmap : " + lsS);
        // Both flatMap and Flatten operations are the same ??

        // Groupby function, not totally understand the limits..

        ls = arr1.stream().filter(number -> arr2.contains(number)).distinct().collect(Collectors.toList());
        System.out.println("Java intersection : " + ls);

        int total = arr1.stream().reduce(0, (accumulator, number) -> accumulator + number);
        System.out.println("Java reduce : " + total);

        int lastposition = 4;
        int firstposition = 2;
        ls = arr1.stream().skip(firstposition).limit(arr1.size() - lastposition - firstposition).collect(Collectors.toList());
        System.out.println("Java slice (between numbers) : " + ls);

        ls = arr1.stream().sorted().collect(Collectors.toList());
        System.out.println("Java sorted : " + ls);

        ls = Stream.concat(arr1.stream(), arr2.stream()).distinct().collect(Collectors.toList());
        System.out.println("Java union : " + ls);
    }
}
