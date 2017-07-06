package leetcode.easy;


/**
 * 用递归更好一些
 * Created by zhaoyi on 17-7-6.
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode temp;
        if (l1.val>l2.val){
            temp = l2;
            l2 = l2.next;
        }else {
            temp = l1;
            l1 = l1.next;
        }
        ListNode result = temp;
        while (l1!=null&&l2!=null){
            if (l1.val>l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp=temp.next;
        }
        temp.next=l1==null?l2:l1;
        return result;
    }

    public static void main(String[] args) {

    }
}
