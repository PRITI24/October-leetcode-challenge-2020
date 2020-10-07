/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
*/

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)return head;
        int size=0;              //It will store the size of linked list
        ListNode ptr=head,temp1=head;
        while(ptr!=null)             //counting size of link list
        {
            ptr=ptr.next;
            size++;
        }
        if(k>=size)k=k%size;       //Managing corner cases where k is greater than size of link list
        if(k==0)return head;
        ListNode ptr1=head;
        for(int i=1;i<(size-k);i++)        //Rotating the list
        {
            ptr1=ptr1.next;
        }
        System.out.println(ptr1.val);
        ListNode temp=ptr1.next;
        head=temp;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        ptr1.next=null;
        temp.next=temp1;
        return head;
    }
}
