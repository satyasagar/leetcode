/*
445. Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1 == null && l2 == null)
            return null;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        
        while(l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode output = new ListNode(s1.pop().val+s2.pop().val);
        int buffer = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || output.val >=10){
            ListNode temp = null;              
            int sum = 0;
            if(output.val>=10){
                output.val = output.val%10;
                buffer = 1;
            }          
            if(!s1.isEmpty()){
                sum += s1.pop().val;
            }
            if(!s2.isEmpty()){
                sum += s2.pop().val;
            }
            if(buffer>0){
                sum += buffer;
            }
            temp = new ListNode(sum);
            temp.next = output;
            output = temp;
            buffer = 0;
        }
        return output;
    }
}