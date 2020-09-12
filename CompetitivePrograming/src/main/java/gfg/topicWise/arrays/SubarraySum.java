/**
 * Question: Subarray with a given sum: Given an unsorted array A of size n of non-negative integers,
 * find a contiguous sub-array which adds to a given number
 */


package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubarraySum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine());
        while (numberOfTestCases-- > 0) {
            String line = br.readLine();
            String[] str1 = line.split("\\s");
            int arraySize = Integer.parseInt(str1[0]);
            int arraySum = Integer.parseInt(str1[1]);
            int array[] = new int[arraySize];
            String line2 = br.readLine();
            String strs2[] = line2.trim().split("\\s+");
            for (int i = 0; i < arraySize; i++) {
                array[i] = Integer.parseInt(strs2[i]);
            }

            // logic goes here
            int start = 0;
            int currentSum = 0;
            int count = 0;
            for (int i = 0; i < arraySize; i++) {
                currentSum += array[i];
                while (currentSum > arraySum && start <= i) {
                    currentSum -= array[start];
                    start++;
                }
                if (currentSum == arraySum) {
                    System.out.println((start + 1) + " " + (i + 1));
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("-1");
            }
        }
    }
}
