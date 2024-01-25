import java.util.List;
import java.util.stream.Collectors;

public class FP03MethodReferences {

    private static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {


        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF",
                "Azure", "Docker", "Kubernetes");


        courses.stream()
                .map(String::toUpperCase)
                .forEach(FP03MethodReferences::print);



    }

}
