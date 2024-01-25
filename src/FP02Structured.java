import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP02Structured {

    public static void main(String[] args) {

//        Function<Integer, Integer> sum = (x, y) -> x + y;

        List<Integer> numbers = List.of(12, 21, 33, 45, 64, 11, 67, 23);

        int sum = addListStructured(numbers);

        System.out.println(sum);




    }

    public static int addListStructured(List<Integer> numbers){

     int sum = 0;

     for (int number : numbers){

         sum += number;

     }


        return sum;
    }



}
