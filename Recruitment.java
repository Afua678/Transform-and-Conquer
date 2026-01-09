import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

/* Time Complexity: O(nlogn + klogn)
Input parsing takes O(n). Building the staff priority queue takes O(nlogn) because it goes through
n venues with each add to the queue taking logn. Moving the venues from staff to finStaff takes 
O(nlogn) because each poll and add take log n for each poll and add. The loop selecting up to 
k venues happens at most k times and each poll takes logn so take (klogn). If k<n, the overall 
complexity is just nlogn.


Space Complexity: O(n)
[arrays of size n take O(n), 2 priority queues which are O(n), 
the number of Recruits Objects is also 0(n), 
and the number of variables are constant O(1)]
 */
public class Recruitment {
    static class Recruits { // create a class to aid in priority queue
        int hires;
        int teachers;

        Recruits(int a, int b) {
            hires = a;
            teachers = b;
        }
    }

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
        int[] hiring = new int[temp.length]; // turn into array for hires (input parsing)
        for (int i = 0; i < temp.length; i++) {
            hiring[i] = Integer.parseInt(temp[i].trim());
        }

        System.out.println("Enter a list of required teachers for each trip:");
        String taught = input.nextLine();

        taught = taught.substring(1, taught.length() - 1);
        String[] tp = taught.split(",");
        int[] teaching = new int[tp.length]; // turn into array for teachers (input parsing)
        for (int i = 0; i < tp.length; i++) {
            teaching[i] = Integer.parseInt(tp[i].trim());
        }

        PriorityQueue<Recruits> staff = new PriorityQueue<>( // this queue should order by teachers needed
                                                             // starting with the least teachers, then by # of hires
                (a, b) -> {
                    if (a.teachers == b.teachers) { // if teachers are equal, take largest hires
                        return b.hires - a.hires;
                    }
                    return a.teachers - b.teachers;
                });

        for (int i = 0; i < hiring.length; i++) { // add values from both arrays to queue
            Recruits b = new Recruits(hiring[i], teaching[i]);
            staff.add(b);
        }

        PriorityQueue<Recruits> finStaff = new PriorityQueue<>( // the final staff queue should have only
                                                                // recruitments that do not need more teachers than w
                (a, b) -> {
                    return b.hires - a.hires; // so only compare the hires
                });

        while (staff.peek() != null && staff.peek().teachers <= w) { // poll only recruitments that need
                                                                     // fewer teachers than w
            Recruits z = staff.poll();
            finStaff.add(z);
        }

        while (k > 0) { // poll from priority queue until k is 0
            while (staff.peek() != null && staff.peek().teachers <= w) {
                Recruits z = staff.poll();
                finStaff.add(z);
            }
            if (finStaff.peek() != null) {
                int z = finStaff.poll().hires;
                w += z;
                k--;
            } else {
                break;
            }

        }

        System.out.println("The maximum number of teachers is: " + w);
    }
}
