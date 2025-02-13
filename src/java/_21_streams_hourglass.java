import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- ClusterBR (arcebrito@gmail.com) | 202501-26
class HourglassParser {
    // the 3x3 hourglasses (submatrices) for the 6x6 matrix are:
    // {r,c}, {r,c+1}, {r,c+2} | {r+1,c+1} | {r+2,c}, {r+2,c+1}, {r+2,c+2}
    // where : r=row index: r={0,1,2,3}, c=column index: c={0,1,2,3}    
    public static List<HourGlass3X3> getlistHGFromListInt(List<List<Integer>> arr) {
        List<HourGlass3X3> result = new ArrayList<HourGlass3X3>();
        //-- r={0,1,2,3} | c={0,1,2,3}
        IntStream.range(0, 4).forEach(r->{
            IntStream.range(0, 4).forEach(c->{
                HourGlass3X3 hg = new HourGlass3X3(r, c);
                hg.addItem(0, arr.get(r).get(c), arr.get(r).get(c+1), arr.get(r).get(c+2));
                hg.addItem(1, 0, arr.get(r+1).get(c+1), 0);
                hg.addItem(2, arr.get(r+2).get(c), arr.get(r+2).get(c+1), arr.get(r+2).get(c+2));
                result.add(hg);
            });
        });
        return result;
    }
}

class HourGlass3X3 {
    private int _r0=0, _c0=0;   
    private int[][] _items = {{0,0,0},{0,0,0},{0,0,0}};

    public HourGlass3X3(int r0, int c0) { _r0=r0; _c0=c0; }

    //-- rowNumber = {0,1,2}
    public void addItem(int rowNumber, int valC0, int valC1, int valC2) {   
        if(rowNumber>=0 && rowNumber<=2) {
            _items[rowNumber][0] = valC0;
            _items[rowNumber][1] = valC1;
            _items[rowNumber][2] = valC2;
        }
    }
    public int getR0() { return _r0; }
    public int getC0() { return _c0; }
    public Integer getSum() {
        return Arrays.stream(_items).flatMapToInt( arr -> Arrays.stream(arr) ).sum();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader bufferedReader = 
            new BufferedReader(new InputStreamReader(System.in))) {
            
            List<List<Integer>> arr = new ArrayList<>();
            IntStream.range(0, 6).forEach(i -> {
                try {
                    arr.add(
                        Stream.of(bufferedReader.readLine().
                            replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt).collect(toList())
                    );
                } catch (IOException ex) { throw new RuntimeException(ex); }
            });
            
            List<HourGlass3X3> listHourGlass = HourglassParser.getlistHGFromListInt(arr);
            OptionalInt optMaxSum = listHourGlass.stream().mapToInt( hg -> hg.getSum() ).max();
            System.out.println(optMaxSum.isPresent() ? optMaxSum.getAsInt(): "Empty HourGlass");
        }
    }
}
