import java.util.List;

public class FP02Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 21, 33, 45, 64, 11, 67, 23);

        int sum = addListFunctional(numbers);

        System.out.println(sum);




    }

    public static int addListFunctional(List<Integer> numbers){


        return numbers.stream()
                .reduce(0, Integer::sum);
    }


}
