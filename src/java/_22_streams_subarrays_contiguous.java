import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _22_streams_subarrays {

    // int d=1...n;                    --range of dimensions
    // int subarrays = n-d+1;          --total-subarrays for d-dimension
    // int start-indexes = 0,1,...n-d  --range of indexes for d-dimension
    // generate subarrays of contiguous-elements stored in a 3-dimensions-array
    private static int [][][] create3DarraySubsequentPattern(int[] inputArray, int n) {
        //--           n-depth|rows|columns
        int array[][][] = new int [n][][];
        for(int d=1; d <= n; d++) {
            int numSubarrays = n - d + 1; //-- total subarrays of dimension-d
            array[d - 1] = new int[numSubarrays][d];
            for (int r = 0; r < numSubarrays; r++) {  
                array[d - 1][r] = Arrays.copyOfRange(inputArray, r, r + d);
            }
        }
        return array;
    }

    private static void print3Darray(int[][][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(Arrays.toString(array[i][j]));
            }
        }
    }    

    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            scan.nextLine();
            String line = scan.nextLine();

            int[] inputArray = Arrays.stream(line.split("\\s+"))
                .mapToInt(s->Integer.parseInt(s)).toArray();
                
            int subarrays[][][] = create3DarraySubsequentPattern(inputArray, n);

            long countNegativeSum = Arrays.stream(subarrays)
                .flatMap(subarray -> Arrays.stream(subarray))
                .mapToInt(subarray -> Arrays.stream(subarray).sum())
                .filter(sum -> sum < 0)
                .count();
            System.out.println(countNegativeSum);
        }
    }
}