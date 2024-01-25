import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//class Course {
//
//    private String name;
//    private String category;
//    private int reviewScore;
//    private int noOfStudents;
//
//
//    public Course(String name, String category, int reviewScore, int noOfStudents) {
//        this.name = name;
//        this.category = category;
//        this.reviewScore = reviewScore;
//        this.noOfStudents = noOfStudents;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public int getReviewScore() {
//        return reviewScore;
//    }
//
//    public void setReviewScore(int reviewScore) {
//        this.reviewScore = reviewScore;
//    }
//
//    public int getNoOfStudents() {
//        return noOfStudents;
//    }
//
//    public void setNoOfStudents(int noOfStudents) {
//        this.noOfStudents = noOfStudents;
//    }
//
//    @Override
//    public String toString() {
//        return name + ":" + noOfStudents + ":" + reviewScore;
//    }
//}

record Course(String name, String category, int reviewScore, int noOfStudents) {
}


public class FP04CustomClass {


    public static void main(String[] args) {


        List<Course> courses =

                List.of(new Course("Spring", "FareWork", 98, 20000),
                        new Course("Spring Boot", "FareWork", 95, 18000),
                        new Course("API", "Microservices", 97, 22000),
                        new Course("Microservices", "Microservices", 96, 25000),
                        new Course("FullStack", "FullStack", 91, 14000),
                        new Course("AWS", "Cloud", 92, 21000),
                        new Course("Azure", "Cloud", 99, 21000),
                        new Course("Docker", "Cloud", 92, 20000),
                        new Course("Kubernetes", "Cloud", 91, 20000));


        //allMatch, noneMatch, anyMatch

        //allMatch --> Review score greater than 90

        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.reviewScore() > 95;

        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.reviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.reviewScore() < 90;


        System.out.println(courses.stream()
                .allMatch(
                        reviewScoreGreaterThan95Predicate));


        System.out.println(courses.stream()
                .noneMatch(
                        reviewScoreLessThan90Predicate));

        System.out.println(courses.stream()
                .anyMatch(
                        reviewScoreLessThan90Predicate));

        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::noOfStudents);

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::noOfStudents).reversed();

        Comparator<Course> comparingByNoOfStudentsAndReviews = Comparator.comparingInt(Course::noOfStudents)
                .thenComparingInt(Course::reviewScore).reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsIncreasing)
                .toList());


        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsDecreasing)
                .takeWhile(course -> course.reviewScore() >= 95) //[Course[name=Microservices, category=Microservices,
                // reviewScore=96, noOfStudents=25000], Course[name=API, category=Microservices, reviewScore=97, noOfStudents=22000]]
                .limit(5)
                .toList());

        //Courses has same number of Students
        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndReviews)
                .dropWhile(course -> course.reviewScore() >= 95)  //[Course[name=FullStack, category=FullStack,
                // reviewScore=91, noOfStudents=14000]]
                .skip(5)
                .toList());


        System.out.println(courses.stream()
                .max(comparingByNoOfStudentsAndReviews));

        System.out.println(courses.stream()
                .min(comparingByNoOfStudentsAndReviews));


        //Reviews greater than 95, need to find total numbers of students & Average of it & count of such courses.

        Predicate<Course> totalNumberOfStudentsReviewsGreaterThan95 = course -> course.reviewScore() > 95;
        var totalNumberOfStudents = courses.stream()
                .filter(totalNumberOfStudentsReviewsGreaterThan95)
                .mapToInt(Course::noOfStudents)
                .count(); //sum() //average()
        System.out.println(totalNumberOfStudents);


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::category))); //THIS WILL COLLECT THE CATEGORY BY GROUPING KEY VALUE PAIR


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::category, Collectors.counting())));  // This will give the count of specific category

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::category,
                        Collectors.maxBy(Comparator.comparingInt(Course::reviewScore)))));  //This will give the max of review score on each
        // category

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::category,
                        Collectors.maxBy(Comparator.comparingInt(Course::reviewScore)))));


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::category, Collectors.mapping(Course::name,
                        Collectors.toSet()))));



    }

}
