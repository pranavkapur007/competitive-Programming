package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionSortedArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-->0){
            String sizes[] = br.readLine().split("\\s+");
            int n = Integer.parseInt(sizes[0]);
            int m = Integer.parseInt(sizes[1]);
            int a[] = new int[n];
            int b[] = new int[m];

            String elements[] = br.readLine().split("\\s+");
            for (int i=0;i<n;i++){
                a[i]= Integer.parseInt(elements[i]);
            }
            elements = br.readLine().split("\\s+");
            for (int i=0;i<m;i++){
                b[i]= Integer.parseInt(elements[i]);
            }
            System.out.println(countUnion(a, b));
        }

    }
    private static int countUnion(int a[], int b[]){
        int i = 0;
        int j = 0;
        int unionCount = 0;
        while(i<a.length && j<b.length){
            if (a[i]<b[j]){
                i++;
                unionCount++;
            }
            else if (a[i]==b[j]){
                i++;
                j++;
                unionCount++;
            }
            else{
                j++;
                unionCount++;
            }
        }
        while (i<a.length){
            i++;
            unionCount++;
        }
        while (j<b.length){
            j++;
            unionCount++;
        }
        return unionCount;
    }
}
