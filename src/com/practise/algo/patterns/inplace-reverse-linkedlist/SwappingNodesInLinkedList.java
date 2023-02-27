//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/
//Eduactive - Patterns

class SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1 = head;
        int count = 1;
        while(count < k){
            node1 = node1.next;
            count++;
        }
        ListNode node2 = head;
        ListNode temp = node1;
        while(temp != null && temp.next != null){
            temp = temp.next;
            node2 = node2.next;
        }

        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
        return head;
    }
}

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
