import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class Flower {
    private final String NAME = "I have many names and types.";
    String whatsYourName() { return this.NAME; }
}

class Jasmine extends Flower {
    private final String NAME = "Jasmine";
    String whatsYourName() { return this.NAME; }    
}

class Lotus extends Flower {
    private final String NAME = "Lotus";
    String whatsYourName() { return this.NAME; }    
}

class Lily extends Flower {
    private final String NAME = "Lily";
    String whatsYourName() { return this.NAME; }    
}

class Region {
    Flower yourNationalFlower() { return new Flower(); }
}

class WestBengal extends Region {
    Jasmine yourNationalFlower() { return new Jasmine(); }    
}

class AndhraPradesh extends Region {
    Lily yourNationalFlower() { return new Lily(); }        
}

public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String s = reader.readLine().trim();
      Region region = null;
      switch (s) {
        case "WestBengal":
          region = new WestBengal();
          break;
        case "AndhraPradesh":
          region = new AndhraPradesh();
          break;
      }
      Flower flower = region.yourNationalFlower();
      System.out.println(flower.whatsYourName());
    }
}