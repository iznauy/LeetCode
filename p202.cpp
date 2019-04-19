//
// Created by iznauy on 18/04/2019.
// 快慢指针要写一篇博客
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isHappy(int n) {
        int fast = n, slow = n;
        do {
            fast = next(next(fast));
            slow = next(slow);
        } while (fast != slow);
        return fast == 1;
    }

private:
    int next(int n) {
        int result = 0;
        while (n != 0) {
            int val = n % 10;
            result += val * val;
            n /= 10;
        }
        return result;
    }

};

bool isHappy(int n, int max) {
    for (int i = 0; i < max; i++) {
        if (n == 1)
            return true;
        int nextN = 0;
        while (n > 0) {
            int val = n % 10;
            nextN += val * val;
            n /= 10;
        }
        n = nextN;
    }
    return false;
}

int main() {
    for (int i = 1; i <= 100; i++) {
        cout << i <<  " is " << (isHappy(i, 1000) ? "" : "not ") << "happy" << endl;
    }
}
