//
// Created by iznauy on 18/04/2019.
//
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set<int> st;
        for (auto & num: nums) {
            st.insert(num);
        }
        return st.size() == nums.size();
    }
};