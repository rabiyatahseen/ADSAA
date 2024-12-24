import java.util.Scanner;

public class binarysearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements (in sorted order):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int x = sc.nextInt();

        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }

    public static int binarySearch(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If the element is present at the middle
            if (arr[mid] == x) {
                return mid;
            }

            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x) {
                return binarySearch(arr, low, mid - 1, x);
            }

            // Else the element can only be present in right subarray
            return binarySearch(arr, mid + 1, high, x);
        }

        // We reach here when the element is not present
        // in array
        return -1;
    }
}
