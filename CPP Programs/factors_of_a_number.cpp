#include <iostream>

using namespace std;

int main()
{
    int n;
    int i;

    cout << "Enter the number: ";
    cin >> n;

    for (i = 1; i <= n; i++)
    {
        if (n % i == 0)
        {
            cout << i << " is a factor of " << n << endl;
        }
    }
    return 0;
}