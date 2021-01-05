package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeWayPartitioning {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }

    public static void sort012(int a[], int n){
        // code here
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid<=high){
            switch(a[mid]){
                case 0: {
                    swap(a, mid, low);
                    mid++;
                    low++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(a, mid, high);
                    high--;
                    break;
                }

            }
        }

    }

    private static void swap(int a[], int i, int i1) {
        int temp=a[i];
        a[i]=a[i1];
        a[i1]=temp;
    }
}
