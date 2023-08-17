//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
           // Step 1: Check if all digits are 9
        boolean allNines = true;
        for (int digit : num) {
            if (digit != 9) {
                allNines = false;
                break;
            }
        }
        
        if (allNines) {
            Vector<Integer> result = new Vector<>();
            result.add(1);
            for (int i = 0; i < n - 1; i++) {
                result.add(0);
            }
            result.add(1);
            return result;
        }
        
        // Step 2: Increment and adjust middle digits
        int mid = n / 2;
        int left = mid - 1;
        int right = (n % 2 == 0) ? mid : mid + 1;
        
        while (left >= 0 && num[left] == num[right]) {
            left--;
            right++;
        }
        
        boolean leftSmaller = false;
        if (left < 0 || num[left] < num[right]) {
            leftSmaller = true;
        }
        
        while (left >= 0) {
            num[right] = num[left];
            left--;
            right++;
        }
        
        // Step 3: Create a palindrome
        if (leftSmaller) {
            int carry = 1;
            left = mid - 1;
            if (n % 2 == 1) {
                num[mid] += carry;
                carry = num[mid] / 10;
                num[mid] %= 10;
                right = mid + 1;
            } else {
                right = mid;
            }
            
            while (left >= 0) {
                num[left] += carry;
                carry = num[left] / 10;
                num[left] %= 10;
                num[right] = num[left];
                left--;
                right++;
            }
        }
        
        Vector<Integer> result = new Vector<>();
        for (int digit : num) {
            result.add(digit);
        }
        return result;
    }
}