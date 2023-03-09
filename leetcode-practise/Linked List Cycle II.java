//142. Linked List Cycle II
//https://leetcode.com/problems/linked-list-cycle-ii/description/
//Leetcode - Daily Challenge - 09-03-2023

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> hm = new HashMap<>();
        ListNode slow = head;
        //hm.add(slow);
        ListNode fast = head;
        ListNode ptr = null;
        int pos = -1;
        while(slow != null && !hm.containsKey(slow)){
            hm.put(slow, 1);
            slow = slow.next;
        }
        return slow;


    }
}
