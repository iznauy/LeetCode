#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = -1, last = -1;
        int left = 0, right = nums.size();
        bool find = false;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                find = true;
                left = mid; // left就是找到的其中的一个相等的元素
                break;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (find) {
            if (nums[0] == target)
                first = 0;
            else {
                int l = 0, r = left;
                int mid = (l + r) / 2;
                while (nums[mid] == target || nums[mid + 1] < target) {
                    if (nums[mid] == target)
                        r = mid;
                    else
                        l = mid + 1;
                    mid = (l + r) / 2;
                }
                first = mid + 1;
            }

            if (nums[nums.size() - 1] == target)
                last = nums.size() - 1;
            else {
                int l = left + 1, r = nums.size() - 1;
                int mid = (l + r) / 2;
                while (nums[mid] == target || nums[mid - 1] > target) {
                    if (nums[mid] == target)
                        l = mid + 1;
                    else
                        r = mid;
                    mid = (l + r) / 2;
                }
                last = mid - 1;
            }
        }
        return {first, last};
    }
};

