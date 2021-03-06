


Let's define the reverse of an integer x as the number obtained by reversing the order of the digits of x and then moving any leading zeroes to the end of the resulting number.

demonstration

Given an array of integers arr, your task is to calculate the sum of reverse numbers of the elements of arr.

Example

For arr = [7, 234, 58100], the output should be sumOfReversed(arr) = 18939.

The reverse of 7 is 7.
The reverse of 234 is 432.
The reverse of 58100 is 18500.
So the answer is 7 + 432 + 18500 = 18939.
For arr = [0, 100, 220], the output should be sumOfReversed(arr) = 320.

The reverse of 0 is 0.
The reverse of 100 is 100.
The reverse of 220 is 220.
So the answer is 0 + 100 + 220 = 320.
Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer arr

An array of non-negative integers.

Guaranteed constraints:
1 ≤ arr.length ≤ 105,
0 ≤ arr[i] ≤ 109.

[output] integer64

The sum of reverse numbers of the elements of arr.
[Java] Syntax Tips

// Prints help message to the console
// Returns a string
// 
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}