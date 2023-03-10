//382. Linked List Random Node
//https://leetcode.com/problems/linked-list-random-node/
//LeetCode Daily Challenge - 10-03-2023



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode ptr = null;
    int len = 0;

    public Solution(ListNode head) {
        ptr = head;
        len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
    }
    
    public int getRandom() {
        int random = (int) (Math.random() * len);
        int count = 0;
        ListNode temp = ptr;
        while(count < random){
            count++;
            temp = temp.next;
        }
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
