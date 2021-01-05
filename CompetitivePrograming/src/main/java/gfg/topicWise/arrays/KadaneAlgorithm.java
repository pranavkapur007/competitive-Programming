package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadaneAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            //calling maxSubarraySum() function
            System.out.println(maxSubarraySum(arr, n));
        }
    }

    private static int maxSubarraySum(int[] arr, int n) {
        // Your code here
        int groupMax = arr[0];
        int curMax = arr[0];
        for (int i=1;i<n;i++){
            curMax = Math.max(arr[i], curMax+arr[i]);
            groupMax = Math.max(groupMax, curMax);
        }
        return groupMax;
    }
}
