package Search;

public class BinarySearch {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};

        Integer val = binarySearch(arr, 7);
        System.out.println(val);

        Integer[] arr1 = null;

        System.out.println(arr1);

        arr1 = new Integer[0];

        System.out.println(arr1);
        System.out.println(arr1.length);
    }

    public static Integer binarySearch(Integer[] arr, Integer value) {

        int res = -1;

        if (arr != null) {

            int left = 0;
            int right = arr.length;
            int mid;

            while (left < right) {
                mid = left + (right - left) / 2;

                if (arr[mid].equals(value)) {
                    res = mid;
                    break;
                }
                if(arr[0].equals(value)) {
                    res = 0;
                    break;
                }
                if (value < arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }
}
