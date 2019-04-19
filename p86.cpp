//
// Created by iznauy on 19/04/2019.
//
#include <bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        auto dummy_one = new ListNode(0);
        auto dummy_two = new ListNode(0);
        ListNode * curr_one = dummy_one;
        ListNode * curr_two = dummy_two;

        ListNode * curr = head;
        while (curr != NULL) {
            if (curr->val < x) {
                curr_one->next = curr;
                curr_one = curr_one->next;
            } else {
                curr_two->next = curr;
                curr_two = curr_two->next;
            }
            curr = curr->next;
        }
        curr_one->next = dummy_two->next;
        curr_two->next = NULL;
        return dummy_one->next;
    }
};