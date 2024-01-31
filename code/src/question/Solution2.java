package question;

/**
 * @author duancf
 * @version 1.0
 * @date created in 2023年11月08日 10:00
 * @since 1.0
 */
public class Solution2 {

   static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmpNode = new ListNode(-1);
        ListNode resultNode = tmpNode;
        Integer r = 0;
        while(l1 != null || l2 != null){
            ListNode newNode = null;
            if(l1 != null && l2 != null) {
                if (l1.val + l2.val + r > 9) {
                    newNode = new ListNode(l1.val + l2.val + r - 10);
                    r = 1;
                } else {
                    newNode = new ListNode(l1.val + l2.val + r);
                    r = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null){
                if (l1.val + r > 9) {
                    newNode = new ListNode(l1.val + r - 10);
                    r = 1;
                } else {
                    newNode = new ListNode(l1.val + r);
                    r = 0;
                }
                l1 = l1.next;
            } else if (l2 != null){
                if (l2.val + r > 9) {
                    newNode = new ListNode(l2.val + r - 10);
                    r = 1;
                } else {
                    newNode = new ListNode(l2.val + r);
                    r = 0;
                }
                l2 = l2.next;
            }
            tmpNode.next = newNode;
            tmpNode = tmpNode.next;
        }
        if(r > 0){
            tmpNode.next = new ListNode(r);
        }
        return resultNode.next;

    }

    public static void main(String[] args) {
        ListNode l1 = configListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = configListNode(new int[]{9,9,9,9});
        ListNode result = addTwoNumbers(l1, l2);
    }

    private static ListNode configListNode(int[] arr){
       ListNode head = new ListNode(-1);
       ListNode start = head;
       for(int a : arr){
           ListNode newNode = new ListNode(a);
           start.next = newNode;
           start = start.next;
       }
       return head.next;
    }


}
