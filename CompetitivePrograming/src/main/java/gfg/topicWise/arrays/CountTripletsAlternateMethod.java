package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountTripletsAlternateMethod {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String line = br.readLine();
            String[] str = line.split("\\s+");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // sort the array
            Arrays.sort(arr);
            int count = 0;
            for (int i = n - 1; i > 1; i--) {
                int j = 0;
                int k = i - 1;
                while (j < k) {
                    if (arr[j] + arr[k] == arr[i]) {
                        count++;
                        j++;
                        k--;
                    } else if (arr[j] + arr[k] < arr[i]) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            if (count == 0) {
                System.out.println("-1");
            } else {
                System.out.println(count);
            }
        }
    }
}
