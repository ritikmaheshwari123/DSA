package PayoneerAssessment;

// Animesh has been given an array arr of length len with its elements in ascending order
// that has been rotated at some point.
// If he finds the assigned value, he must return true else false.
public class SortedRotatedArraySearch {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 5;

        System.out.println(searchIn(arr, target));
    }

    public static boolean searchIn(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
            }
            // Left part is sorted
            else if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right part is sorted
            else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
