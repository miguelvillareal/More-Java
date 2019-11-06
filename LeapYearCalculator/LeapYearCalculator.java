import java.util.Scanner;

public class LeapYearCalculator {

    public static void main(String[] args) {

      Scanner reader = new Scanner(System.in);
      System.out.println("Enter year please:");
      int year = reader.nextInt();

      if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
        System.out.println("The year " + year + " is a leap year");
      else
        System.out.println("The year " + year + " is not a leap year");
    }


}
