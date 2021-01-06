/*
Problem: Move all negative numbers to beginning and positive to end with constant extra space

Approach 1: This approach uses quick sort partition algorithm logic
 */
package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveAllNegativeElementsToBegApproachOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-->0){
            int arraySize = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split("\\s+");
            int[] arr = new int[arraySize];
            for(int i=0;i<arraySize;i++){
                arr[i]=Integer.parseInt(elements[i]);
            }
            moveNegativeElements(arr);
            for (int i=0;i<arraySize;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    private static void moveNegativeElements(int[] arr){
        int j=0, temp;

        for(int i=0;i<arr.length;i++){
            if (arr[i]<0){
                if (i!=j){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                j++;
            }
        }
    }
}
