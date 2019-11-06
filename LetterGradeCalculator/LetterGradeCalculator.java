import java.util.Scanner;

public class LetterGradeCalculator {

    public static void main(String[] args)
    {

      double average;

      Scanner reader = new Scanner(System.in);
      System.out.println("Enter score for exam 1:");
      int score1 = reader.nextInt();
      System.out.println("Enter score for exam 2:");
      int score2 = reader.nextInt();
      System.out.println("Enter score for exam 3:");
      int score3 = reader.nextInt();
      reader.close();

      average = (score1 + score2 + score3)/3;
      System.out.println("Average test score:"+average);

          if (average <= 100 && average >= 90) {
         System.out.println("Letter grade: A");
        } if (average <= 89 && average >= 80) {
         System.out.println("Letter grade: B");
        } if (average <= 79 && average >= 70) {
         System.out.println("Letter grade: C");
        } if (average <= 69 && average >= 60) {
         System.out.println("Letter grade: D");
        } if (average <= 59) {
         System.out.println("Letter grade: F");
        }

    }

}
