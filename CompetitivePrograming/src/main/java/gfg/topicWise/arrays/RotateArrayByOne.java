package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArrayByOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-->0){
            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split("\\s+");
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]= Integer.parseInt(elements[i]);
            }
            int temp = arr[n-1];
            for(int i=n-2;i>=0;i--){
                arr[i+1]=arr[i];
            }
            arr[0]=temp;
            for (int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
