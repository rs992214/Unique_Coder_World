#include <bits/stdc++.h>
using namespace std;

#define ch 256

void search(char pattern[], char text[], int q)
{
    int M = strlen(pattern);
    int N = strlen(text);
    int i, j;
    int p = 0;
    int t = 0;
    int h = 1;

    for (i = 0; i < M - 1; i++)
        h = (h * ch) % q;

    for (i = 0; i < M; i++)
    {
        p = (ch * p + pattern[i]) % q;
        t = (ch * t + text[i]) % q;
    }

    // Here we slide the pattern over the string one by one.
    for (i = 0; i <= N - M; i++)
    {

        // Checking if the hash values for each of these match. If they match, only then we move forward to check the entire pattern.
        if (p == t)
        {
            bool flag = true;
            // Checking for characters one by one
            for (j = 0; j < M; j++)
            {
                if (text[i + j] != pattern[j])
                {
                    flag = false;
                    break;
                }
            }
            if (j == M)
                cout << "Pattern found at index " << i << endl;
        }
        if (i < N - M)
        {
            t = (ch * (t - text[i] * h) + text[i + M]) % q;

            // We might get negative value of t, so we need to convert it into a positive value.
            if (t < 0)
                t = (t + q);
        }
    }
}

int main()
{
    char text[] = "KARTIK";
    char pattern[] = "ART";
    int q = 101;
    search(pattern, text, q);
    return 0;
}
