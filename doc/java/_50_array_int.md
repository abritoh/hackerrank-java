# Java Challenge-50

An array is a simple data structure used to store a collection of data in a contiguous block of memory. Each element in the collection is accessed using an index, and the elements are easy to find because they're stored sequentially in memory.

Because the collection of elements in an array is stored as a big block of data, we typically use arrays when we know exactly how many pieces of data we're going to have. For example, you might use an array to store a list of student ID numbers, or the names of state capitals. To create an array of integers named myArray that can hold four integer values, you would write the following code:

`int[] myArray = new int[4];`

This sets aside a block of memory that's capable of storing 4 integers. Each integer storage cell is assigned a unique index ranging from  to one less than the size of the array, and each cell initially contains a 0. 

## Task

The code in your editor does the following:

1. Reads an integer from stdin and saves it to a variable, n, denoting some number of integers.
2. Reads  integers corresponding to a0,a1,...an from stdin and saves each integer ai to a variable.
3. Attempts to print each element of an array of integers named a.

Write the following code in the unlocked portion of your editor:

1. Create an array, , capable of holding  integers.
2. Modify the code in the loop so that it saves each sequential value to its corresponding location in the array. For example, the first value must be 
stored in a0, the second value must be stored in a1, and so on.

### Input Format

The first line contains a single integer, , denoting the size of the array.
Each line  of the  subsequent lines contains a single integer denoting the value of element .

Output Format

You are not responsible for printing any output to stdout. Locked code in the editor loops through array  and prints each sequential element on a new line.

### Sample Input

5
10
20
30
40
50

### Sample Output

10
20
30
40
50
