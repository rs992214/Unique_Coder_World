#include <bits/stdc++.h>
using namespace std;

int kadane_sum(vector<int> nums)
{
    int n = nums.size();

    if (n == 1)
        return nums[0];

    int currsum = nums[0];
    int ans = nums[0];

    for (int i = 1; i < n; i++)
    {
        currsum = max(nums[i], currsum + nums[i]);
        ans = max(ans, currsum);
    }

    return ans;
}

int main()
{
    vector<int> arr{-2,1,-3,4,-1,2,1,-5,4};

    cout << "Maximum subarray sum = " << kadane_sum(arr);
    return 0;
}