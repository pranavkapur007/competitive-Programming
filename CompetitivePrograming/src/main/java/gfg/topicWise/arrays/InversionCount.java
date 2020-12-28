/*
 * Question: Inversion count of array.
 * Inversion count: nversion Count: For an array, inversion count indicates how far (or close)
 * the array is from being sorted. If array is already sorted then the inversion count is 0.
 * If an array is sorted in the reverse order then the inversion count is the maximum.
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 */
package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InversionCount {
    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String strs[] = br.readLine().trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            int temp[] = new int[n];
            long inversions = mergeSort(arr, 0, n - 1, temp);
            System.out.println(inversions);
        }
    }

    private static long mergeSort(int arr[], int left, int right, int[] temp) {
        int mid;
        long inversionCount = 0;
        if (right > left) {
            mid = (left + right) / 2;
            inversionCount = mergeSort(arr, left, mid, temp);
            inversionCount += mergeSort(arr, mid + 1, right, temp);
            inversionCount += merge(arr, left, mid, right, temp);
        }
        return inversionCount;
    }

    private static long merge(int arr[], int left, int mid, int right, int temp[]) {
        long inversionCount = 0;
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }
        return inversionCount;
    }
}