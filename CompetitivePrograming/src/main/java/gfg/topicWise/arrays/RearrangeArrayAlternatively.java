/**
 * Question: Rearranging array alternatively, with using extra space.
 * Given a sorted array of positive integers, rearrange the array alternately i.e
 * first element should be the maximum value, second minimum value, third-second max,
 * fourth-second min and so on.
 *
 * Example:
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
 * Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RearrangeArrayAlternatively {
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

            RearrangeAlternate obj = new RearrangeAlternate();

            //calling rearrange() function
            obj.rearrange(temp, n);
            StringBuffer sb = new StringBuffer();

            //appending and printing the elements
            for (int i = 0; i < n; i++)
                sb.append(temp[i] + " ");
            System.out.println(sb);
        }
    }
}


// } Driver Code Ends


class RearrangeAlternate {

    // This function wants you to rearrange the temp array as required
    // and returns a StringBuffer with all elements of modified temp array
    // appended to it.
    // temp: input array
    // n: size of array
    public static void rearrange(int arr[], int n) {

        // Your code here
        int left = 0;
        int right = n - 1;
        boolean flag = true;
        int[] temp = arr.clone();
        for (int i = 0; i < n; i++) {
            if (flag) {
                arr[i] = temp[right--];
            } else {
                arr[i] = temp[left++];
            }
            flag = !flag;
        }
    }

}
