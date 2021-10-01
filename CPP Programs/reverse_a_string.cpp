#include <iostream>
#include <string>

using namespace std;

void rev_string(string s1)
{
    int len = s1.length();
    for (int i = 0; i < len / 2; i++)
    {
        char temp = s1.at(i);
        s1.at(i) = s1.at(len - i - 1);
        s1.at(len - i - 1) = temp;
    }
    cout << "the reversed string is: " << endl;
    cout << s1;
}

int main()
{
    string s1;
    getline(cin, s1);

    rev_string(s1);
    return 0;
}