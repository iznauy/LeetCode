//
// Created by iznauy on 16/04/2019.
//
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if ((sum & 1) == 1)
            return false;
        int half = (sum >> 1);

        vector<bool> dp(half + 1, false);
        dp[0] = true;
        for (auto & num: nums)
            for (int i = half; i > 0; i--)
                if (num <= i)
                    dp[i] = dp[i] || dp[i - num];
        return dp[half];
    }
};