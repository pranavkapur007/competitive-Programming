/**
 * Question: Rearranging array alternatively, with using extra space.
 * Given a sorted array of positive integers, rearrange the array alternately i.e
 * first element should be the maximum value, second minimum value, third-second max,
 * fourth-second min and so on.
 * <p>
 * Example:
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
 * Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RearrangeArrayAlternativelyWithoutExtraSpace {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            //size of array
            int n = Integer.parseInt(read.readLine());
            int[] temp = new int[n];

            String str[] = read.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++)
                temp[i] = Integer.parseInt(str[i]);

            //calling rearrange() function
            rearrange(temp, n);
            StringBuffer sb = new StringBuffer();

            //appending and printing the elements
            for (int i = 0; i < n; i++)
                sb.append(temp[i] + " ");
            System.out.println(sb);

        }
    }

    private static void rearrange(int[] arr, int n) {
        int minIndex = 0;
        int maxIndex = n - 1;
        boolean flag = true;
        int maxElement = arr[maxIndex] + 1;
        for (int i = 0; i < n; i++) {
            if (flag) {
                arr[i] = arr[i] + (arr[maxIndex--] % maxElement) * maxElement;
            } else {
                arr[i] = arr[i] + (arr[minIndex++] % maxElement) * maxElement;
            }
            flag = !flag;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / maxElement;
        }
    }
}
