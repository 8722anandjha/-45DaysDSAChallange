// Problem: Pow(x,n)
// link: https://leetcode.com/problems/powx-n/

/*
Approach

- Define a helper function that handles the recursive calculation of the power.

- Base Case 1: If the exponent n is 0, return 1 because any number raised to the power of 0 is 1.

- Base Case 2: If the exponent n is 1, return the base x, since any number raised to the power of 1 is itself.

- If the exponent n is even:
    - If true, recursively calculate the power by squaring the base and halving the exponent:
        - power(x, n) = power(x * x, n / 2)

- If the exponent n is odd:
    - If true, recursively calculate the power by multiplying the base with the result of the power function for n - 1:
        - power(x, n) = x * power(x, n - 1)

- Handle negative exponents:
    -If the exponent is negative, calculate the power for the positive exponent and take the reciprocal of the result.

-Finally, combine these steps in a main function that checks if the exponent is negative and calls the helper function accordingly.

Time Complexity: O(log(n))
Space Complexity: 0(log(n))
*/

class Solution {
    public double myPow(double x, int n) {
        double res= pow(x,n);
        if(n < 0) return 1.0/res;
        return res;
    }
    public double pow(double x,int n){
        if(n==0 ) return 1.0;
        double half= pow(x,n/2);
        if(n%2==0) return half * half;
        else return x * half * half;
    }
}