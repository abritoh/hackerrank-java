import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _24_streams_play_and_leap {

    private static final int START = 0, SAFE = 0, TRAP = 1;

    public static boolean goalreached(int[] game, int i, int leap) {
        int goal = game.length;
        if (i < goal) {
            if (game[i] == SAFE && (i + 1) >= goal) return true;
            if (game[i] == SAFE && (i + leap) >= goal) return true;
        }
        return false;
    }

    public static boolean canWin(int[] game, int leap, int i, boolean[] visited) {        
        if (i < 0 || i >= game.length || visited[i]) return false;
        visited[i] = true; 

        if (goalreached(game, i, leap)) return true;
        if (game[i] == TRAP) return false;

        if (canWin(game, leap, i + 1, visited)) return true; 
        if (canWin(game, leap, i - 1, visited)) return true; 
        if (canWin(game, leap, i + leap, visited)) return true; 

        return false;
    }

    public static boolean canWin(int[] game, int leap) {
        boolean[] visited = new boolean[game.length];
        return canWin(game, leap, 0, visited);
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new File("_24_data.txt"))) {
            int q = scan.nextInt(); // Number of queries

            if (!(q >= 1 && q <= 5000)) { System.out.println("NO"); return; }

            while (q-- > 0) {
                int n = scan.nextInt();
                int leap = scan.nextInt();

                if (!(n >= 2 && n <= 100)) { System.out.println("NO"); return;}
                
                if (!(leap >= 0 && leap <= 100)) { System.out.println("NO"); return;}

                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }

                System.out.println((canWin(game, leap)) ? "YES" : "NO");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        } catch (Exception ex2) {
            System.out.println("Exception: " + ex2.getMessage());
        }
    }
}