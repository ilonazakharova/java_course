package ru.stqa.pft.sandbox.Lecture6;
import java.util.ArrayList;
import java.util.List;
public class Runner {
  public static final int FIVE = 5;
  public static final int TWO = 2;

  public static void main(String[] args) {
    List<Student> group = new ArrayList<>();

    group.add(new Student("Иван", "Иванов", 5, 5, 5));
    group.add(new Student("Вася", "Пупкин", 5, 5, 5));
    group.add(new Student("Сидор", "Сидоров", 4, 4, 4));
    group.add(new Student("Петр", "Петров", 3, 3, 3));
    group.add(new Student("Александр", "Aлександров", 2, 2, 2));
    group.add(new Student("Потап", "Потапович", 5, 5, 2));

    System.out.println("Cписок студентов отличников");
    group.stream().filter(Runner::isHighScoreGuy).map(Object::toString).sorted().forEach(System.out::println);
    System.out.println("---------------------------------------------------------------------------------------");
    System.out.println("Cписок студентов с неудовлетворительными ошибками");
    group.stream().filter(Runner::isLowScoreGuy).map(Object::toString).sorted().forEach(System.out::println);
    System.out.println("---------------------------------------------------------------------------------------");
    System.out.println("Средний балл студентов группы: " + group.stream().mapToDouble(Runner::getStudentAverage).average().getAsDouble());
    System.out.println("---------------------------------------------------------------------------------------");
    System.out.println("Cтуденты группы");
    System.out.println(group);
  }

  private static boolean isHighScoreGuy(Student student){
    return student.getProgramming() == FIVE && student.getMathematics() == FIVE && student.getEnglish() == FIVE;
  }

  private static boolean isLowScoreGuy(Student student){
    return student.getProgramming() == TWO | student.getMathematics() == TWO | student.getEnglish() == TWO;
  }

  private static double getStudentAverage(Student student){
    return (student.getProgramming() + student.getMathematics() + student.getEnglish()) / 3;
  }
}
