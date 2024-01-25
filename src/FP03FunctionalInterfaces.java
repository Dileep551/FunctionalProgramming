import java.util.List;

public class FP03FunctionalInterfaces {

    public static void main(String[] args) {


        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int total = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .reduce(0, Integer::sum);

        System.out.println(total);




       int sum = numbers.stream()
                .reduce(0, FP03FunctionalInterfaces::getSum);

        System.out.println(sum);



    }

    public static int getSum(int x, int y){

        return x + y;
    }



}
