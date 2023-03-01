//https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/
//Eduactive - Patterns

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
class ReverseNodesInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int k = 1;
        int currentGroup = 1;
        ListNode ptr = head;
        while(ptr != null){
            ListNode previousGroupEnd = ptr;
            ListNode temp = ptr.next;
            k = k+1;
            currentGroup = 1;
            while(temp != null && currentGroup < k){
                temp = temp.next;
                if(temp != null){
                    currentGroup++;
                }
            }
            ListNode nextGroupStart = temp != null ? temp.next : null;
            ListNode currentGroupEnd = temp;
            if(currentGroup % 2 == 0){
                ListNode reversedListNode = reverseListNode(previousGroupEnd.next, nextGroupStart);
                currentGroupEnd = previousGroupEnd.next;
                previousGroupEnd.next = reversedListNode;
            }
            ptr = currentGroupEnd;
        }
        return head;
    }

    public ListNode reverseListNode(ListNode start, ListNode end){
        ListNode prev = end;
        ListNode curr = start;
        while(curr != end){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
