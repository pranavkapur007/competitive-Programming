/*
*
* Problem: Move all negative numbers to beginning and positive to end with constant extra space
*
* Approach 2: This approach uses two pointers.
*  left = 0;
*  right = n-1;
*  Check If
* 1) the left and right pointer elements are negative then simply increment the left pointer.
* 2) Otherwise, if the left element is positive and the right element is negative then simply swap the elements, and Simultaneously increment or decrement the left and right pointers.
* 3) Else if the left element is positive and the right element is also positive then simply decrement the right pointer.
* 4) Repeat the above 3 steps until the left pointer ≤ right pointer.
 */
package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveAllNegativeElementsToBegApproachTwo {

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

    private static void moveNegativeElements(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            if (arr[left]<0 && arr[right]<0){
                left++;
            }
            else if (arr[left]>0 && arr[right]<0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right]= temp;
                left++;
                right--;
            }
            else if (arr[left]>0 && arr[right]>0){
                right--;
            }
            else{
                left++;
                right--;
            }
        }
    }
}
