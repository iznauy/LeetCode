//
// Created by iznauy on 18/04/2019.
// 注意，以后二分搜查都写
//
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if (citations.empty())
            return 0;
        reverse(citations.begin(), citations.end());
        int left = 0, right = citations.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (citations[mid] >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
};