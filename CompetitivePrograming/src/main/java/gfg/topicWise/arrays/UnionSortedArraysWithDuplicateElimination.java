package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionSortedArraysWithDuplicateElimination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-->0){
            String[] sizes = br.readLine().split("\\s+");
            int n = Integer.parseInt(sizes[0]);
            int m = Integer.parseInt(sizes[1]);
            int[] a = new int[n];
            int[] b = new int[m];

            String[] elements = br.readLine().split("\\s+");
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

    private static int countUnion(int[] a, int[] b) {
        int unionCount=0;
        int auxArraySize;
        if (a[a.length-1]>b[b.length-1]){
            auxArraySize = a[a.length-1];
        }
        else{
            auxArraySize = b[b.length-1];
        }
        int auxArray[] = new int[auxArraySize+1];

        auxArray[a[0]]++;
        unionCount++;

        for(int i=1;i<a.length;i++){
            if (a[i]!=a[i-1]){
                auxArray[a[i]]++;
                unionCount++;
            }
        }

        for(int j=0;j<b.length;j++){
            if (auxArray[b[j]]==0){
                auxArray[b[j]]++;
                unionCount++;
            }
        }
        return unionCount;
    }
}
