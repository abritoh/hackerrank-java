import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- This code passess the default-test
//-- requires revision to pass the other tests as well as optimization
enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);

    @Override
    public String toString() {
        return String.format("{value:%s, color:%s, depth:%d}", 
            value, (color==Color.RED) ? "RED" : "GREEN", depth);
    }
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

//-- The SumInLeavesVisitor implementation must return 
//-- the sum of the values in the tree's leaves only.
//--
//--    result = SumOf_valuesInLeaveNodes
class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;
    
    public int getResult() {
      	//implement this
        return sum;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        sum += leaf.getValue();
    }
}

//-- The ProductRedNodesVisitor implementation must return 
//-- the product of values stored in all red nodes, including leaves, 
//-- computed modulo 10^9+7. Note that the product of zero values is equal to 1.
//-- 
//--    result = ProductOfValuesInRedNodesIncludingLeaves
class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int MOD = 1_000_000_007;
    
    public int getResult() {
      	//implement this
        return (int) product;
    }

    public void visitNode(TreeNode node) {
      	//implement this
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

//-- The FancyVisitor implementation must return the absolute difference between 
//-- the sum of values stored in the tree's non-leaf nodes at even depth 
//-- and the sum of values stored in the tree's green leaf nodes.
//-- Recall that zero is an even number. (even=par)
//-- 
//--   result = abs(SumOf_NonLeafNodesWithEvenDepth - Sum_ValuesOfGreenLeafNodes)
class FancyVisitor extends TreeVis {
    private int sumEvenNonLeaf = 0;
    private int sumGreenLeaves = 0;
        
    public int getResult() {
      	//implement this
        return Math.abs(sumEvenNonLeaf - sumGreenLeaves);
    }

    public void visitNode(TreeNode node) {
    	//implement this
        if (node.getDepth() % 2 == 0) {
            sumEvenNonLeaf += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
        if (leaf.getColor() == Color.GREEN) {
            sumGreenLeaves += leaf.getValue();
        }
    }
}

public class _63_v1_treenode_traverse_tree {
    
    private static boolean isLeaf(int nodeId, int[][] edges) {
        for(int[] edge : edges) 
            //-- if the given id is a parent-node ret: false
            if(edge[0] == nodeId) return false;
        //--if not is parent of any node, is a leaf-node
        return true;
    }    
  
    //-- read the tree from STDIN and return its root 
    //--  as a return value of this function
    public static Tree solve() {
        
        String line;
        TreeNode rootNode;
        //--try(Scanner in = new Scanner(System.in)) {
        try(Scanner in = new Scanner(new File("__data/_63_T1.txt"))) {
            
            //-- read n, node-values and node-colors
            int n = in.nextInt();
            in.nextLine();
            line = in.nextLine();
            String[] values = line.split("\\s+");
            line = in.nextLine();
            String[] colors = line.split("\\s+");

            //-- PRINT
            System.out.println("\n***\nn=" + n);
            System.out.println("values=" + Arrays.stream(values).collect(Collectors.joining(",")) );
            System.out.println("colors=" + Arrays.stream(colors).collect(Collectors.joining(",")) );
            
            //-- read node-edges
            //-- an edge is represented as: [parentId, childId]
            int[][] edges = new int[n-1][2];
            for(int i=0; i<(n-1); i++) {
                line = in.nextLine();
                String[] pair = line.split("\\s+");
                edges[i][0] = Integer.parseInt(pair[0]);
                edges[i][1] = Integer.parseInt(pair[1]);
            }
            
            //-- initialize the HashMap that will be used to build the Tree
            HashMap<Integer, Tree> mapNodes = new HashMap<>();
            
            //-- identify root-node
            Set<Integer> childIds = new HashSet<>();
            for(int[] edge : edges) {
                //-- PRINT
                System.out.printf("\nedge=[%d, %d]", edge[0], edge[1]);
                childIds.add(edge[1]);
            }

            //-- root-node is not a child-node
            //-- any other node is a child-node
            int rootId = -1, value = 0; 
            Color color = Color.RED;
            for(int[] edge : edges)  {
                if(!childIds.contains(edge[0])) {
                    rootId = edge[0];
                    value = Integer.parseInt(values[rootId-1]);
                    color = Color.values()[Integer.parseInt(colors[rootId-1])];
                    break;
                }
            }

            if (rootId == -1) {
                System.out.println("root-node not found!");
                return null;
            }
        
            //-- creates the root-node, depth of root-node is 0
            //-- add the root node to the mapNodes-hashmap
            rootNode = new TreeNode(value, color, 0);
            mapNodes.put(rootId, rootNode);
            
            //-- creates sub-nodes of the root-node
            for (int[] edge : edges) {
                int parentId = edge[0];
                int childId = edge[1];
                value = Integer.parseInt(values[childId - 1]);
                color = Color.values()[Integer.parseInt(colors[childId - 1])];
                
                Tree parentNode = mapNodes.get(parentId);
                Tree childNode;
                if(isLeaf(childId, edges)) {
                    childNode = new TreeLeaf(value, color, parentNode.getDepth()+1);
                } else {
                    childNode = new TreeNode(value, color, parentNode.getDepth()+1);
                }

                ((TreeNode)parentNode).addChild(childNode);
                mapNodes.put(childId, childNode);
            }
            
            return rootNode;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}