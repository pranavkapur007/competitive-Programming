package gfg.topicWise.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kthSmallestElement {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0)
        {
            int n=sc.nextInt();

            int arr[]=new int[n];

            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            int k=sc.nextInt();

            System.out.println(kthSmallest(arr, 0, n-1, k));
        }
    }

    private static int kthSmallest(int[] arr, int low, int n, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1.compareTo(o2)>0){
                    return -1;
                }
                else
                    return 1;
            }
        });

        // add elements to the queue
        for(int i=0;i< n;i++){
            queue.add(arr[i]);

            if (queue.size() > k )
                queue.remove();
        }

        // print the peek()

        return queue.peek();
    }

}
