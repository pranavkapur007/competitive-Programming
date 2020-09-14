package gfg.topicWise.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountTriplets {

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

            // logic goes here
            // create freq array
            int maxVal = 0;
            for (int i = 0; i < n; i++)
                maxVal = Math.max(maxVal, arr[i]);
            int freq[] = new int[maxVal + 1];
            for (int i = 0; i < n; i++)
                freq[arr[i]]++;

            int ans = 0; //stores the no. of ways

            //case 1: 0,0,0
            ans += (freq[0] * (freq[0] - 1) * (freq[0] - 2)) / 6;

            // case 2: 0,x,x
            for (int i = 1; i < maxVal; i++) {
                ans += freq[0] * (freq[i] * freq[i] - 1) / 2;
            }

            // case 3: x,x,2x
            for (int i = 1; 2 * i <= maxVal; i++) {
                ans += (freq[i] * (freq[i] - 1)) / 2 * freq[2 * i];
            }

            // case 4: x,y,x+y
            for (int i = 1; i <= maxVal; i++) {
                for (int j = i + 1; i + j <= maxVal; j++) {
                    ans += freq[i] * freq[j] * freq[i + j];
                }
            }
            if (ans == 0)
                System.out.println("-1");
            else
                System.out.println(ans);
        }
    }
}
