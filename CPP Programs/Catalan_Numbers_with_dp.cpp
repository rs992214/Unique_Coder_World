#include <iostream>
using namespace std;

int catalan(int n)
{
    int dp[n + 1] = {0};
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++)
    {
        for (int j = 0; j < i; j++)
            dp[i] += (dp[j] * dp[i - j - 1]);
    }
    return dp[n];
}

int main()
{
    int n;
    cin >> n;
    cout << catalan(n);
    return 0;
}

/*
Applications : 
1. Total no. of binary trees possible with n nodes = catalan(n)
2. Total no. of Unlabeled binary trees possible with n nodes = catalan(n)
3. Total no. of labeled binary trees possible with n nodes = catalan(n) * n!
4. Total valid combination of paranthesis with n pair of paranthesis (with or without letters)= catalan(n)
5. Dyck Words (Possible ways to arrange xy pair such that no. of x is either greater or equal to no. of y) = catalan(n)
6. Mountain Ranges with n pair of up & down strokes = catalan(n)
7. Path on grid - We're given a n*n grid and we have to go from bottom left corner to top right corner.
Two variations (R = Right & U = Up)
-> Stay below or equal to diagonal (No. of R >= U)
-> Stay above or equal to diagonal (No. of U >= R)

8. Convex Polygon (No. of triangles possible with n vertices) = catalan(n-2)
We can't make any polygon with 0/1 vertices . Our journey starts from 2 here.

9. Connect Disjoint chords (You're given n pairs of points on a circle) = catalan(n)

*/