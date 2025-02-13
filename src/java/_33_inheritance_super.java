import java.util.*;
import java.io.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class BiCycle{
    String define_me() { return "a vehicle with pedals."; }
}

class MotorCycle extends BiCycle{
    String define_me() { return "a cycle with an engine."; }
    MotorCycle(){
        System.out.println("Hello I am a motorcycle, I am " + define_me());
        System.out.println("My ancestor is a cycle who is " + super.define_me());
    }    
}
class Solution{
    public static void main(String []args){
        new MotorCycle();
    }
}
