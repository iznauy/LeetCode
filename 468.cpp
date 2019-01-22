#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    string validIPAddress(string IP) {
        if (IP.find('.')!= string::npos) { // 找到了点，不可能是ipv6
            int value = 0, groupCount = 0;
            bool first = true;
            for (char & c: IP.append(".")) {
                if (c == '.') {
                    if (first)
                        return "Neither";
                    first = true;
                    value = 0;
                    groupCount++;
                } else {
                    int cv = c - '0'; // 当前字符的值
                    if (cv < 0 || cv > 10)
                        return "Neither";
                    if (first) { // 第一个可以为0
                        first = false;
                    } else if (value == 0) { // 不是第一个数，但是现在加起来也都是0
                        return "Neither";
                    }
                    value = value * 10 + cv; // 更新数值
                    if (value > 255)
                        return "Neither";
                }
            }
            if (groupCount == 4)
                return "IPv4";
        } else if (IP.find(':') != string::npos) {
            int groupCount = 0, numCount = 0;
            for (char & c: IP.append(":")) {
                if (c == ':') {
                    if (numCount == 0) // 多个连续分号
                        return "Neither";
                    groupCount++;
                    numCount = 0;
                } else {
                    int cv = c - '0';
                    int sc = c - 'a';
                    int bc = c - 'A';
                    if (!((cv >= 0 && cv <= 9) || (sc >= 0 && sc <= 5) || (bc >= 0 && bc <= 5)))
                        return "Neither";

                    numCount++;
                    if (numCount > 4)
                        return "Neither";
                }
            }
            if (groupCount == 8)
                return "IPv6";
        }
        return "Neither";
    }
};
