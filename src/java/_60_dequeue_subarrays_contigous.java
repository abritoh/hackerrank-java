import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- You need to find the maximum number of unique integers 
//-- among all the possible contiguous subarrays of size M.
public class _60_dequeue_subarrays_contigous {    
    private static int[][] create2DarraySubsequentPattern(int[] inputArray, int d) {
        int n = inputArray.length;
        int numSubarrays = n - d + 1; //-- total subarrays of dimension-d
        int[][] array = new int[numSubarrays][];
        for(int r=0; r<numSubarrays; r++) {
            array[r] = Arrays.copyOfRange(inputArray, r, r+d);
        }
        return array;
    }

    private static void print2Darray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
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
        
        int[][] subarrays = create2DarraySubsequentPattern(inputArray, m);
        //-- print2Darray(subarrays);        
        int maxCount = Arrays.stream(subarrays)
                .mapToInt(subarray -> (int) Arrays.stream(subarray).distinct().count())
                .max().orElse(0);
        System.out.println(maxCount);
    }    
}


