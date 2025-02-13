import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- You need to find the maximum number of unique integers 
//-- among all the possible contiguous subarrays of size M.
//-- This code uses the ─Sliding Window algorithm─
//-- https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
public class _60_v2_dequeue_subarrays_contigous {
    
    //-- implementation of the ─Sliding Window algorithm─
    public static int maxUniqueInSubarraysDequeSet(int[] inputArray, int m) {

        int n = inputArray.length, left = 0, maxUnique = 0;
        
        //-- using a deque for sliding window technique
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> uniqueSet = new HashSet<>();

        for (int right = 0; right < n; right++) {

            deque.offer(inputArray[right]);
            uniqueSet.add(inputArray[right]);

            //-- shrink the window from the left if its size exceeds m
            if (right - left + 1 > m) {
                //-- remove from the front of the window
                int leftElement = deque.poll(); 
                //-- remove the left element from the set only if it's not present in the current window
                if (!deque.contains(leftElement)) {
                    uniqueSet.remove(leftElement);
                }
                left++;
            }
            //-- if the window size is exactly m, calculate the number of unique elements
            if (right - left + 1 == m) {
                maxUnique = Math.max(maxUnique, uniqueSet.size());  // Track the maximum unique count
            }
        }
        return maxUnique;
    }
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            inputArray[i] = num;
        }
        
        //-- v2 
       int maxUnique = maxUniqueInSubarraysDequeSet(inputArray, m);
        System.out.println(maxUnique);
    }    
}


