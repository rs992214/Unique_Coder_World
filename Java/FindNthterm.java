/*# Program to find Nth term in the given Series

# Given a number N. The task is to write a program to find the N-th term in the below series:
# 1, 1, 2, 3, 4, 9, 8, 27, 16, 81, 32, 243, 64, 729, 128, 2187… */

public class FindNthterm {
    
    static void findNthTerm(int n)
{
    // If input number is even
    if (n % 2 == 0)
    {
        n = n / 2;
        System.out.print(Math.pow(3, n - 1) + "\n");
    }
    // If input number is odd
    else
    {
        n = (n / 2) + 1;
        System.out.print(Math.pow(2, n - 1) + "\n");
    }
}

public static void main(String[] args)
{
    int N = 4;
    findNthTerm(N);
 
    N = 11;
    findNthTerm(N);
 
}
}
