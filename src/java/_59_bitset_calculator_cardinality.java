import java.util.*;
import java.util.BitSet;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class BitOper {
    //-- AND, OR, XOR, FLIP, SET
    public String oper;
    public int arg1;
    public int arg2;
    public BitOper(String oper, int arg1, int arg2) {
        this.oper = oper; this.arg1 = arg1; this.arg2 = arg2;
    }
}

class BitCalculator {    
    private int N = 0;
    private BitSet B1 = null, B2=null;
     
    public BitCalculator(int N) {
        this.N = N;
        this.B1 = new BitSet(N);
        this.B2 = new BitSet(N);
    }
    
    public void execOper(BitOper o) {
        switch(o.oper) {
            case "AND" : AND  (o.arg1, o.arg2); break;
            case "OR"  : OR   (o.arg1, o.arg2); break;
            case "XOR" : XOR  (o.arg1, o.arg2); break;
            case "FLIP": FLIP (o.arg1, o.arg2); break;
            case "SET" : SET  (o.arg1, o.arg2); break;
        }
    }
    
    public BitSet getById(int id) {
        return (id==1) ? this.B1 : this.B2;
    }
    
    public void print() {
        System.out.printf("%d %d\n", 
            this.B1.cardinality(), this.B2.cardinality());
    }
    
    //-- binary-operations
    //-- params:: set1, set2: 1 (for B1), 2 (for B2)
    //-- where set1 is the left operand and set2 is the right-operand
    
    public void AND(int set1, int set2) {
        BitSet b1 = this.getById(set1);
        BitSet b2 = this.getById(set2);
        b1.and(b2);
        print();
    }
     
    public void OR(int set1, int set2) {
        BitSet b1 = this.getById(set1);
        BitSet b2 = this.getById(set2);
        b1.or(b2);
        print();
    }
     
    public void XOR(int set1, int set2) {
        BitSet b1 = this.getById(set1);
        BitSet b2 = this.getById(set2);
        b1.xor(b2);
        print();
    }
     
    //-- unary-operations
    //-- params:: setx (1->B1, 2->B2) | index (0...N-1)
    
    public void FLIP(int setx, int index) {
        BitSet b = this.getById(setx);
        b.flip(index);
        print();        
    }
    
    public void SET(int setx, int index) {
        BitSet b = this.getById(setx);
        b.set(index);
        print();        
    }
}

//-- input: N=bitset-size | M=operations
//-- for N=3: B1=0,0,0 ; B2=0,0,0
public class Solution {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int M = in.nextInt();
            in.nextLine();
            
            List<BitOper> operations = new ArrayList<>();
            for(int i=0; i < M; i++) {
                String line = in.nextLine();
                String[] lineArr = line.split("\\s+");
                operations.add (
                    new BitOper(
                        lineArr[0],
                        Integer.parseInt(lineArr[1]),
                        Integer.parseInt(lineArr[2]) ) 
                );
            }
            
            //-- exec operations
            BitCalculator calc = new BitCalculator(N);
            for(BitOper oper : operations) {
                calc.execOper(oper);
            }
        }
    }
}

