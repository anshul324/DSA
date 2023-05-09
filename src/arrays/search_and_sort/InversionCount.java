package arrays.search_and_sort;

import java.util.Arrays;

public class InversionCount {
    private static long mergeAndCountInversion(long[] arr, int start, int mid, int end) {
        long[] left = Arrays.copyOfRange(arr, start, mid + 1);
        long[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);
        long inversionCount = 0;
        int i = 0;
        int j = 0;
        int k = start;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                inversionCount += (mid + 1) - (start + i);
                arr[k++] = right[j++];
            }
        }
        while(i < left.length) {
            arr[k++] = left[i++];
        }
        while(j < right.length) {
            arr[k++] = right[j++];
        }
        return inversionCount;
    }
    private static long mergeSortAndCountInversion(long[] arr, int start, int end) {
        long inversionCount = 0;
        if(start < end) {
            int mid = start + (end - start) / 2;
            inversionCount += mergeSortAndCountInversion(arr, start, mid);
            inversionCount += mergeSortAndCountInversion(arr, mid + 1, end);
            inversionCount += mergeAndCountInversion(arr, start, mid, end);
        }
        return inversionCount;
    }
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        return mergeSortAndCountInversion(arr, 0, n - 1);
    }
}
