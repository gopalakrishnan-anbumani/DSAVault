//725. Split Linked List in Parts
//https://leetcode.com/problems/split-linked-list-in-parts/description/


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
class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int N = 0;
        ListNode temp = head;
        while(temp != null){
            N++;
            temp = temp.next;
        }
        int min = N/k;
        int max = N % k;
        ListNode[] res = new ListNode[k];

        ListNode curr = head;
        for(int i=0; i<k; i++){
            res[i] = curr;
            int count = 0;
            int extra = i < max ? 1 : 0;
            ListNode prev = curr;
            while(curr != null && count < min+extra){
                prev = curr;
                curr = curr.next;
                count++;
            }
            if(prev != null){
                prev.next = null;
            }
        }
        return res;
    }
}