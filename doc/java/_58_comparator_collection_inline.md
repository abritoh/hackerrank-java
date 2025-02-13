# Java Challenge-58

You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order. If two student have the same CGPA, then arrange them according to their first name in alphabetical order. If those two students also have the same first name, then order them according to their ID. No two students have the same ID.

Hint: You can use comparators to sort a list of objects. See the oracle docs to learn about comparators.

See: https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html

## Input Format

The first line of input contains an integer N, representing the total number of students. The next N lines contains a list of student information in the following structure:

`ID Name CGPA`


## Output Format

After rearranging the students according to the above rules, print the first name of each student on a separate line.

## Sample Input

```java
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
```

## Sample Output

```java
Ashis
Fahim
Samara
Samiha
Rumpa
```

