import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {


    public static void main(String[] args) {




        Predicate<Integer> integerPredicate = x -> x % 2 == 0;

        Function<Integer, Integer> integerIntegerFunction = x -> x * x;

        Function<Integer, String> integerStringFunction = x -> x + " ";

        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;  //Input 1 Integer type & return same type

        Supplier<Integer> randomIntegerSupplier = () -> {

            Random random = new Random();

            return random.nextInt(1000);
        } ;

//        System.out.println(randomIntegerSupplier.get());  //Supplier will not take any input , But give out put.


        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;  //

//        System.out.println(unaryOperator.apply(10));


        BiPredicate<Integer, String> biPredicate = (number, str) ->  {
            return number<10 && str.length()>5;
        };

        System.out.println(biPredicate.test(1,"Dileep")); // Bipridicate return boolean, when you wanted to check on both values.


        BiFunction<Integer, String, String> biFunction = (x, y) -> x+" " + y+" "; //Return any type

        System.out.println(biFunction.apply(2,"Dileep")); // BiFunction is giving 2 types and final out put in 3rd Type


        BiConsumer<Integer, String> biConsumer = (x, y) -> {System.out.println(x); System.out.println(y);};

        biConsumer.accept(15, "Dileep");



        List<Integer> numbers = List.of(12, 21, 45, 1, 2, 8, 9, 6, 5);


//        filterAndPrint(numbers, integerPredicate);
//
//        filterAndPrint(numbers, number->number%2 != 0);
//
//
//
//        System.out.println(mapAndCreateNewList(numbers,
//                integerIntegerFunction));
//        System.out.println(mapAndCreateNewList(numbers, x->x*x*x));

//        numbers.stream()
//                .filter(number -> number % 2 == 0)
//                .forEach(System.out::println);
//
//        numbers.stream()
//                .filter(number -> number % 2 != 0)
//                .forEach(System.out::println);


    }

    public static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate){

        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);

    }

    public static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> function){

       return numbers.stream()
                .map(function)
               .collect(Collectors.toList());


    }



}
