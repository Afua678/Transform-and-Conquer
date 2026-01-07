import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

/* Time Complexity: 
Space Complexity: n [arrays of size n, priority queue takes size n, and variable are constant (1)]
 */
public class Recruitment {

    // create a class to aid in priority queue

    static class Recruits { // implements Comparable<Recruits>
        int hires;
        int teachers;

        Recruits(int a, int b) {
            hires = a;
            teachers = b;
        }

        // @Override
        // public int compareTo(Recruits other) {
        // if (this.teachers == other.teachers) {
        // return Integer.compare(other.hires, this.hires); // max priority for hires
        // }
        // return Integer.compare(this.teachers, other.teachers); // min priority for
        // teachers
        // }
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

        hired = hired.substring(1, hired.length() - 1);
        String[] temp = hired.split(",");
        int[] hiring = new int[temp.length]; // turn into array for hires
        for (int i = 0; i < temp.length; i++) {
            hiring[i] = Integer.parseInt(temp[i].trim());
        }

        System.out.println("Enter a list of required teachers for each trip:");
        String taught = input.nextLine();

        taught = taught.substring(1, taught.length() - 1);
        String[] tp = taught.split(",");
        int[] teaching = new int[tp.length]; // turn into array for teachers
        for (int i = 0; i < tp.length; i++) {
            teaching[i] = Integer.parseInt(tp[i].trim());
        }

        PriorityQueue<Recruits> staff = new PriorityQueue<>(
                (a, b) -> {
                    if (a.teachers == b.teachers) { // a.teachers < w && b.teachers < w
                        return b.hires - a.hires;
                    }
                    return a.teachers - b.teachers;
                });
        for (int i = 0; i < hiring.length; i++) { // add values from both arrays to queue
            Recruits b = new Recruits(hiring[i], teaching[i]);
            staff.add(b);
        }

        while (w >= 0 && k > 0) {
            Recruits a = staff.poll();
            System.out.println(a.hires + " " + a.teachers);
            if (w - a.teachers >= 0) {
                w += a.hires;
                System.out.println(w);
            }
            System.out.println(w);
            k--;
        }

        if (w <= 0) {
            System.out.println("The maximum number of teachers is: 0");
        } else {
            System.out.println("The maximum number of teachers is: " + w);
        }
        /*
         * for loop through the end of the array
         * adding
         * pq.add(new Recruits(hire, teacher))
         */
    }
}
