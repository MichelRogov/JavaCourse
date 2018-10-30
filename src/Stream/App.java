package Stream;

import Stream.Stream_Api.functional_interface.SquareRoot;
import Stream.Stream_Api.functional_interface.impl.SquareRootImpl;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");


        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        Collections.sort(names, (a, b) -> b.compareTo(a));


        Consumer<String> c = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println;

        final int num = 1;
        Consumer<String> cons  = (from) -> String.valueOf(from + num);

        int num2 = 1;
        Consumer<String> cons2 = (from) -> String.valueOf(from + num2);

        int num3 = 1;
        Consumer<String> cons3 = (from) -> String.valueOf(from + num3);
//        num3 = 3;

        // another collection in a stream
        List<String> prefixes = Arrays.asList("p", "a", "m");

        List<String> collect = names
                .stream()
                .filter(p -> prefixes.indexOf(p.substring(0, 1)) != -1)
                .collect(Collectors.toList());

        System.out.println(collect);


        int[] numArr = new int[] {4,5,6,7,8,9};
        SquareRoot squareRoot = new SquareRootImpl();

        Arrays.stream(numArr).mapToDouble(squareRoot::findSquareRoot).forEach(System.out::println);
    }

}
