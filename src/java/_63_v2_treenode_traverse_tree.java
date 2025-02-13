import java.util.ArrayList;
import java.io.*;
import java.util.*;
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
    private final int MOD = 1000000007;
    
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

public class _63_v2_treenode_traverse_tree {    
    
    private static int[] values;
    private static Color[] colors;    
    //-- initialize the HashMap that will be used to build the Tree
    private static HashMap<Integer, HashSet<Integer>> mapNodeIDs = new HashMap<>();
      
    //-- read the tree from STDIN and return its root 
    //--  as a return value of this function
    public static Tree solve() {
        
        String line;
        try(Scanner in = new Scanner(System.in)) {
            
            //-- read n, node-values and node-colors
            int n = in.nextInt();
            in.nextLine();
            line = in.nextLine();
            String[] str_values = line.split("\\s+");
            line = in.nextLine();
            String[] str_colors = line.split("\\s+");
            
            //-- convert values and colors
            values = new int[n];
            colors = new Color[n];
            for(int i=0; i<n; i++) {
                values[i] = Integer.parseInt(str_values[i]);
                colors[i] = Color.values()[Integer.parseInt(str_colors[i])];
            }
            
            //-- read (n-1) lines of node-edges
            //-- edge is represented as: [parentId, childId]
            for (int i = 0; i < n-1; i++) {
                int parentId = in.nextInt();
                int childId = in.nextInt();
                
                HashSet<Integer> parentMap = mapNodeIDs.get(parentId);
                if (parentMap == null) {
                    parentMap = new HashSet();
                    mapNodeIDs.put(parentId, parentMap);
                }
                parentMap.add(childId);
                
                HashSet<Integer> childMap = mapNodeIDs.get(childId);
                if (childMap == null) {
                    childMap = new HashSet();
                    mapNodeIDs.put(childId, childMap);
                }
                childMap.add(parentId);
            }

            //-- it is guaranteed that the tree is rooted at node 1.
            if (n == 1) { return new TreeLeaf(values[0], colors[0], 0); }
            
            //-- build the TreeNode DS
            TreeNode root = new TreeNode(values[0], colors[0], 0);
            createTreeDSRecursive(root, 1);
            
            return root;
        }
    }
    
    //-- creates the TreeNode using recursion
    private static void createTreeDSRecursive(TreeNode parent, Integer parentId) {
        for (Integer nodeId : mapNodeIDs.get(parentId)) {
            mapNodeIDs.get(nodeId).remove(parentId);
            Tree childNode = createNode(nodeId, parent.getDepth());
            parent.addChild(childNode);
            //-- if the child is a TreeNode, recursively process its children
            if (childNode instanceof TreeNode) {
                createTreeDSRecursive((TreeNode) childNode, nodeId);
            }
        }
    }
    
    private static Tree createNode(int nodeId, int parentDepth) {
        //-- checks if the node has children
        HashSet<Integer> children = mapNodeIDs.get(nodeId);
        boolean hasChildren = (children != null && !children.isEmpty());
        if (hasChildren) {
            return new TreeNode(values[nodeId - 1], colors[nodeId - 1], parentDepth + 1);
        } else {
            return new TreeLeaf(values[nodeId - 1], colors[nodeId - 1], parentDepth + 1);
        }
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