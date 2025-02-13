import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _24_streams_play_and_leap {

    private static final int START=0, SAFE=0, TRAP=1;

    public static boolean goalreached(int[] game, int i, int leap) {
        int goal = game.length;
        if(i < goal) {
            if( game[i]==SAFE && (i + 1) >= goal) return true;
            if( game[i]==SAFE && (i + leap) >= goal) return true;
        }
        return false;
    }

    public static boolean canjump(int[] game, int i, int jumpi) {
        int goal = game.length;
        if(i >=0  && i < goal && game[i]==SAFE) {
            if(jumpi <= (goal-1) && game[jumpi]==SAFE) return true;
        }
        return false;
    }

    //-- return true if you can win the game; otherwise, return false.
    //-- rules: starts at index-0
    //-- move to destination if destination exists and contains zero
    //--    destination can be: backward (i-1), fordward (i+1), leap (i+leap)
    //-- you win when:
    //--    you reach the end i > (n-1) or (i+leap >= n)
    //-- you lose when: 
    //--    you move or jump to a place with value-1 since you connot move anymore
    //-- validate with:
    //-- 51 21 (YES)
    //-- 0 1 1 1 1 0 1 1 1 1 0 1 1 0 0 0 1 0 1 0 0 0 0 1 1 1 1 0 1 0 0 1 0 0 1 1 0 1 0 0 1 0 1 1 1 0 0 0 1 0 1
    public static boolean canWin(int[] game, int leap) {
        boolean goto_top = false;
        int i = 0, backward_k, forward_k, jumpi;
        
        int goal = game.length;
        boolean[] visited = new boolean[goal];
    
        while (i < goal) {
            if (visited[i]) return false;
    
            visited[i] = true;
    
            if (goalreached(game, i, leap)) return true;
    
            if (game[i] == TRAP) return false;
    
            //-- move-backward until no TRAP found, check if goalreached
            backward_k = i;
            while (backward_k >= START) {
                jumpi = (backward_k + leap);
                if (goalreached(game, backward_k, leap)) return true;
                if (game[backward_k] == TRAP || backward_k == START) break;
                backward_k--;
            }
    
            //-- move-forward until no TRAP found, check if goalreached
            forward_k = i;
            while (forward_k >= START && forward_k < goal) {
                jumpi = (forward_k + leap);
                if (goalreached(game, forward_k, leap)) return true;
                if (game[forward_k] == TRAP || forward_k >= goal) break;
                forward_k++;
            }
    
            goto_top = false;
            //-- move-backward until no TRAP found, if jump break and continue
            backward_k = i;
            while (backward_k >= START) {
                jumpi = (backward_k + leap);
                if (canjump(game, backward_k, jumpi)) {
                    i = jumpi;
                    goto_top = true;
                    break;
                }
                if (game[backward_k] == TRAP || backward_k == START) break;
                backward_k--;
            }
            if (goto_top) continue;
    
            //-- move-forward until no TRAP found, if jump break and continue
            forward_k = i;
            while (forward_k >= START && forward_k < goal) {
                jumpi = (forward_k + leap);
                if (canjump(game, forward_k, jumpi)) {
                    i = jumpi; 
                    goto_top = true;
                    break;
                }
                if (game[forward_k] == TRAP || forward_k >= goal) break;
                forward_k++;
            }
            if (goto_top) continue;
    
            //-- if no moves are possible, try moving forward or backward one step
            if (i + 1 < goal && game[i + 1] == SAFE && !visited[i + 1]) {
                i++;
            } else if (i - 1 >= 0 && game[i - 1] == SAFE && !visited[i - 1]) {
                i--;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {        
        //try(Scanner scan = new Scanner(System.in)) {
        //try (Scanner scan = new Scanner(new File("_24_data_9.txt"))) {
        try (Scanner scan = new Scanner(new File("_24_data.txt"))) {
            
            //-- queries (game-rounds)
            int q = scan.nextInt();

            if ( !(q>=1 && q<=5000) ) { System.out.println("NO"); return; }
            
            //-- 2xq lines describing queries
            //-- line1: n=space, l= leap (size of leap)
            //-- line2: n-space 0 and 1 | 0 1 0 0 1 1
            while (q-- > 0) {
                int n = scan.nextInt();
                int leap = scan.nextInt();

                if ( !(n>=2 && n<=100) ) { System.out.println("NO"); return; }
                if ( !(leap>=0 && leap<=100) ) { System.out.println("NO"); return; }
                
                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }

                System.out.println( (canWin(game, leap)) ? "YES" : "NO" );
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        } catch (Exception ex2) {
            System.out.println("Exception: " + ex2.getMessage());
        }         
    }
}