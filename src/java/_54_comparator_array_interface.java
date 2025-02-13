import java.util.*;
import java.util.Comparator;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- Comparator<T> : int Compare(T a, T b) {...}
class Checker implements Comparator<Player> {
    //-- returns: -1 if a < b | 0 if a==b | 1 if a > b
    //-- for ASC comparisson compare a vs b
    //--    Strings: a.comapareTo(b) | Nums: (a - b)
    //-- for DESC comparisson compare b vs a
    //--    Strings: b.compareTo(a) | Numbs (b - a)
    @Override
    public int compare(Player a, Player b) {
        if (a.score == b.score ) {
            return a.name.compareTo(b.name);
        } else {
            return (b.score - a.score);
        }
    }
}

class Player{
    String name;
    int score;
    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        //-- Uses Arrays.sort(arrayDS, comparatorImp)
        //-- sorts the array (player) using the comparator (checker)
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

