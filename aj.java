import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // variables to store marks
        int mark1, mark2, mark3;
        // variables to store sum and average marks
        int totalMark;
        double avgMark;

        // create Scanner class object to take input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter marks of three subjects: ");
        mark1 = scan.nextInt();
        mark2 = scan.nextInt();
        mark3 = scan.nextInt();

        // calculate sum of marks
        totalMark = mark1 + mark2 + mark3;

        // calculate average of marks
        avgMark = (double) totalMark / 3;

        System.out.println("Total Mark: " + totalMark);
        System.out.println("Average Mark: " + Math.round(avgMark));

        scan.close();
    }
}