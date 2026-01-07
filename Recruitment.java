import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public class Recruitment {
    // do priority queue with teachers as the first priority and hires second
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer for k:");
        int k = input.nextInt();
        input.nextLine();

        System.out.println("Enter nonnegative integer for w:");
        int w = input.nextInt();
        input.nextLine();

        System.out.println("Enter a list of hires from each venue:");
        String hired = input.nextLine();

        System.out.println("Enter a list of required teachers for each trip:");
        String taught = input.nextLine();
    }
}
