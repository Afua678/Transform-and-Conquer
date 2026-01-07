import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public class Recruitment {

    // create a class to aid in priority queue

    static class Recruits implements Comparable<Recruits> {
        int hires;
        int teachers;

        Recruits(int a, int b) {
            hires = a;
            teachers = b;
        }

        @Override
        public int compareTo(Recruits other) {
            if (this.teachers == other.teachers) {
                return Integer.compare(this.hires, other.hires); // max priority for hires
            }
            return Integer.compare(other.teachers, this.teachers); // min priority for teachers
        }
    }
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

        /*
         * for loop through the end of the array
         * adding
         * pq.add(new Recruits(hire, teacher))
         */
    }
}
