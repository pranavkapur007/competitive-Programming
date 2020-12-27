/*
* Question: Given two arrays X and Y of positive integers, find the number of pairs such that xy > yx (raised to power of)
* where x is an element from X and y is an element from Y.
*
 */
package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfPairs {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            int[] x = new int[n];
            str = (br.readLine()).trim().split(" ");
            for (int i = 0; i < n; i++)
                x[i] = Integer.parseInt(str[i]);

            str = (br.readLine()).trim().split(" ");
            int[] y = new int[m];
            for (int i = 0; i < m; i++) {
                y[i] = Integer.parseInt(str[i]);

            }
            System.out.println(countPairs(x, y, n, m));
        }
    }

    private static int countPairs(int[] x, int[] y, int n, int m) {

        //1) store counts of 0,1,2,3 and 4 in array y
        int noOfY[] = new int[5];
        for (int i = 0; i < m; i++) {
            if (y[i] < 5) {
                noOfY[y[i]]++;
            }
        }
        // 2) sort y
        Arrays.sort(y);

        // 3) for each x, find number greater than x in y, using binary search
        int totalPairs = 0;

        for (int i = 0; i < x.length; i++) {
            totalPairs += count(x[i], y, noOfY);
        }
        return totalPairs;
    }

    private static int count(int x, int[] y, int[] noOfY) {

        // condition 1: if x is 0, there cannot be any y such that x^y>y^x
        if (x == 0) return 0;

        // condition 2: if x is 1, then no. of pairs equal to no. of zeros in y
        if (x == 1) return noOfY[0];

        // condition 3: Find number of elements in Y[] with values greater than x
        int index = Arrays.binarySearch(y, x);
        int ans = 0;
        if (index < 0) {
            index = Math.abs(index + 1);
        } else {
            while (index < y.length && y[index] == x) {
                index++;
            }
        }
        ans += y.length - index;

        // condition 4: check for y==0, y==1, since it got eliminated in the above cases
        ans += noOfY[0] + noOfY[1];

        // condition 5: Decrease number of pairs for x=2 and (y=4 or y=3)
        if (x == 2)
            ans -= (noOfY[3] + noOfY[4]);

        // condition 6: Increase number of pairs for x=3 and y=2
        if (x == 3)
            ans += noOfY[2];

        return ans;
    }
}
