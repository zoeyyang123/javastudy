package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-13.
 */
public class RemoveDuplicatesfromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode p = head;
        while (p.next!=null){
            ListNode buff = p.next;
            if (p.val==buff.val)
                p.next=buff.next;
            else
                p=p.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
