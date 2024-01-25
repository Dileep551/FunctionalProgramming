import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printAllNumbersInListFunctional(numbers);
        printOnlyOddNumbersInListFunctional(numbers);
        printAlltheCourses(courses);
        filterOnCourse(courses);
        filterNameHasAtLeast4letters(courses);
        printSquareOfEvenNumbers(numbers);
        printCubeOfOddNumbers(numbers);
        printNumberOfChars(courses);

    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //What to do ?
        //Covert into Stream of elements

        numbers.stream()
                //.filter(FP01Functional::isEven)
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println); //Method Reference

        System.out.println("--------------------------");
    }

    private static void printOnlyOddNumbersInListFunctional(List<Integer> numbers){

        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);

        System.out.println("---------------------------");


    }

    private static void printAlltheCourses(List<String> courses){

        courses.stream()
                .forEach(System.out::println);

        System.out.println("---------------------------");

    }

    private static void filterOnCourse(List<String> courses){

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        System.out.println("--------------------------------");

    }

    private static void filterNameHasAtLeast4letters(List<String> courses){

        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

        System.out.println("------------------------------------");
    }

    private static void printSquareOfEvenNumbers(List<Integer> numbers){

        numbers.stream()
                .filter(number->number % 2 == 0)
                .map(number -> number * number)
                .forEach(System.out::println);

        System.out.println("------------------------");

    }

    private static void printCubeOfOddNumbers(List<Integer> numbers){

        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);

        System.out.println("=================================");
    }


    private static void printNumberOfChars(List<String> courses){

        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);


    }



}
