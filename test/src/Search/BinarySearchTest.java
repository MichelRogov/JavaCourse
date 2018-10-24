package Search;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class BinarySearchTest {

    private static final Integer [] MULTI_ARR = new Integer[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50};

    @Test
    public void shouldReturnDefaultByNull(){
        Integer [] arr = null;
        Integer value = 7;
        assertTrue(BinarySearch.binarySearch(arr, value) == -1);
    }

    @Test
    public void shouldReturnDefaultByEmptyArr(){
        Integer [] arr = new Integer[0];
        Integer value = 7;
        assertTrue(BinarySearch.binarySearch(arr, value) == -1);
    }

    @Test
    public void shouldFindValueInOneElArr(){
        Integer [] arr = new Integer[]{7};
        Integer value = 7;
        assertTrue(BinarySearch.binarySearch(arr, value) == 0);
    }

    @Test
    public void shouldReturnDefaultByMissingValueLeftInOneElArr(){
        Integer [] arr = new Integer[]{7};
        Integer value = -20;
        assertTrue(BinarySearch.binarySearch(arr, value) == -1);
    }

    @Test
    public void shouldReturnDefaultByMissingValueRightInOneElArr(){
        Integer [] arr = new Integer[]{7};
        Integer value = 20;
        assertTrue(BinarySearch.binarySearch(arr, value) == -1);
    }

    @Test
    public void shouldReturnDefaultByOutOfRangeValueLeftInThreeElArr(){
        Integer [] arr = new Integer[]{7, 0, 20};
        Integer value = -30;
        assertTrue(BinarySearch.binarySearch(arr, value) == -1);
    }

    @Test
    public void shouldReturnDefaultByMissingValueLeftInThreeElArr(){
        Integer [] arr = new Integer[]{7, 0, 20};
        Integer value = 12;
        assertTrue(BinarySearch.binarySearch(arr, value) == -1);
    }

    @Test
    public void shouldReturnDefaultByOutOfRangeValueRightInThreeElArr(){
        Integer [] arr = new Integer[]{7, 0, 20};
        Integer value = 30;
        assertTrue(BinarySearch.binarySearch(arr, value) == -1);
    }

    @Test
    public void shouldFindFirstElementInThreeElArr(){
        Integer [] arr = new Integer[]{7,0,20};
        Integer value = 7;
        assertTrue(BinarySearch.binarySearch(arr, value) == 0);
    }

    @Test
    public void shouldFindMiddleElementInThreeElArr(){
        Integer [] arr = new Integer[]{7,0,20};
        Integer value = 0;
        assertTrue(BinarySearch.binarySearch(arr, value) == 1);
    }

    @Test
    public void shouldFindLastElementInThreeElArr(){
        Integer [] arr = new Integer[]{7,0,20};
        Integer value = 20;
        assertTrue(BinarySearch.binarySearch(arr, value) == 2);
    }

    @Test
    public void shouldReturnDefaultByOutOfRangeValueLeftMultiArr(){
        Integer value = -30;
        assertTrue(BinarySearch.binarySearch(MULTI_ARR, value) == -1);
    }

    @Test
    public void shouldReturnDefaultByOutOfRangeValueMiddleMultiArr(){
        Integer value = 40;
        assertTrue(BinarySearch.binarySearch(MULTI_ARR, value) == -1);
    }

    @Test
    public void shouldReturnDefaultByOutOfRangeValueRightMultiArr(){
        Integer value = 60;
        assertTrue(BinarySearch.binarySearch(MULTI_ARR, value) == -1);
    }

    @Test
    public void shouldFindFirstElementInMultiArr(){
        Integer value = -16;
        assertTrue(BinarySearch.binarySearch(MULTI_ARR, value) == 0);
    }

    @Test
    public void shouldFindMiddleElementsInMultiArr(){
        Integer value = 7;
        assertTrue(BinarySearch.binarySearch(MULTI_ARR, value) == 5);

        value = 20;
        assertTrue(BinarySearch.binarySearch(MULTI_ARR, value) == 8);

        value = 24;
        assertTrue(BinarySearch.binarySearch(MULTI_ARR, value) == 9);
    }

    @Test
    public void shouldFindLastElementInMultiArr(){
        Integer value = 50;
        assertTrue(BinarySearch.binarySearch(MULTI_ARR, value) == 14);
    }
}
