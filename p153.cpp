//
// Created by iznauy on 18/04/2019.
//
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        if (nums.empty())
            return 0;
        if (nums.size() == 1)
            return nums[0];
        int left = 0, right = nums.size() - 1;
        while (nums[left] > nums[right]) {
            int mid = (left + right) / 2;
            if (nums[left] <= nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[right + 1];
    }
};
