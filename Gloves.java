import java.util.Arrays;
import java.util.Scanner;

public class Gloves {

    // time complexity: O(nlogn)
    // splitting the input and converting it to integers would take O(n), mergesort takes O(nlogn),
    // and counting the pairs would take O(n) so mergesort dominates the time complexity which is why it is O(nlogn)

    // space complexity: 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a list of integers: ");
        
        String input = in.nextLine();

        input = input.substring(1, input.length() - 1);
        String[] temp = input.split(",");

        int[] inputArray = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            inputArray[i] = Integer.parseInt(temp[i].trim());
        }

        int[] sortedArray = mergeSort(inputArray);
        int pairs = 0;

        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] == sortedArray[i+1]) {
                pairs++;
                i++;
            }
        }

        System.out.println("The number of matching pairs is: " + pairs);

        
        in.close();
        
    }

    public static int[] mergeSort(int[] a) {
        if (a.length < 2) {
            return a;
        }

        int[] newArrLeft = Arrays.copyOfRange(a, 0, a.length/2);
        int[] newArrRight = Arrays.copyOfRange(a,a.length/2, a.length);

        return mergeLists(mergeSort(newArrLeft), mergeSort(newArrRight));
    }


    public static int[] mergeLists(int[] a, int[] b) {
        int[] merged = new int [a.length + b.length];

        int i = 0;
        int j = 0;

        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                merged[k++] = a[i++];
            }
            else {
                merged[k++] = b[j++];
            }
        }
        while (i < a.length) {
            merged[k++] = a[i++];
        }
        while (j < b.length) {
            merged[k++] = b[j++];
        }

        return merged;
    }

}
