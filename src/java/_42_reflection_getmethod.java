import java.io.*;
import java.lang.reflect.*;
import java.security.*;
import java.util.*;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            
            //-- Must be used to hold the reference of the instance of
            //-- the class Solution.Inner.Private
            Object o; 

            //-- Write your code here
            //-- --------------------------------------
            o = (new Solution.Inner()).new Private();

            //-- is equivalent to:
            //--    Solution.Inner outerInstance = new Solution.Inner();
            //-- outerInstance.new is a special syntax in Java used for instantiating 
            //-- a non-static nested class from an instance of its outer class.
            //--    Solution.Inner.Private privateInstance = outerInstance.new Private();
            //--    Object o = privateInstance;

            Method method = o.getClass().getDeclaredMethod("powerof2", int.class);
            method.setAccessible(true);            
            
            System.out.printf("%d is %s\n", num, method.invoke(o, num));
            //-- --------------------------------------

            System.out.println(
                "An instance of class: " 
                    + o.getClass().getCanonicalName() + " has been created");

        }
        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) 
                    ? "power of 2" : "not a power of 2";
            }
        }
    }

}

//-- This class prevents exit(0)
class DoNotTerminate { 

    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
