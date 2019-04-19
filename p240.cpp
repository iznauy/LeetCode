//
// Created by iznauy on 19/04/2019.
//
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0)
            return false;
        int top = 0, down = matrix.size() - 1;
        int left = 0, right = matrix[0].size() - 1;
        while (top <= down && left <= right) {
            int pivot = matrix[down][left];
            if (pivot == target)
                return true;
            else if (pivot < target) {
                left++;
            } else {
                down--;
            }
        }
        return false;
    }
};