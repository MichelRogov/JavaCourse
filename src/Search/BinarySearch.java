package Search;

public class BinarySearch {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 8};

        Integer val = binarySearch(arr, 3);
        System.out.println(val);
    }

    public static Integer binarySearch(Integer[] arr, Integer value) {
        for (int left = 0, right = arr.length - 1; left <= right; ) {
            int mid = left + (right - left) / 2;

            if (arr[mid].equals(value)) {
                return mid;
            }
            if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
