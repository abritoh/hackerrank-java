import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class Sports {
    String getName() {
        return "Generic Sports";
    }
    void getNumberOfTeamMembers() {
        System.out.println( "Each team has n players in " + getName() );
    }
}

class Soccer extends Sports {
    private static final int TOTAL_PLAYERS = 11;    
    @Override
    String getName(){
        return "Soccer Class";
    }
    @Override

     void getNumberOfTeamMembers() {
        System.out.printf( "Each team has %d players in %s\n", TOTAL_PLAYERS, getName());
    }
}

public class Solution {
    public static void main(String[] args) {
        Sports sport = new Sports();
        Soccer soccer = new Soccer();
        
        System.out.println(sport.getName());
        sport.getNumberOfTeamMembers();
        System.out.println(soccer.getName());
        soccer.getNumberOfTeamMembers();
    }
}

