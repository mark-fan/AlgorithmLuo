package operation;

/**
 * @author luofan
 */
public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return new ListNode();
        }
        int i = 0;
        ListNode res = new ListNode();
        while (head.next != null) {
            if (i == n) {
                res.next = head.next.next;
            }
            res.next = head.next;
            i++;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }else if(list1.val >list2.val){
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }else{
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while(list1!=null&&list2!=null){
            if(list1.val > list2.val){
                pre.next = list2;
                list2 = list2.next;
            }else{
                pre.next = list1;
                list1.next = list1;
            }
        }
        pre.next = list1 == null ? list2:list1;
        return prehead.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        for (ListNode list : lists) {
            listNode =   mergeTwoLists3(listNode,list);
        }
        return listNode;
    }

    private ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1 ==null){
            return l2;

        }else if(l2==null){
            return l1;
        }else if (l1.val >l2.val){
            l1.next = mergeTwoLists3(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists3(l1,l2.next);
        return l2;
        }

    }


    public ListNode swapPairs(ListNode head) {
        if(head == null ||head.next ==null){
            return head;
        }
        ListNode ans = head.next;
        head.next = swapPairs(ans.next);
        ans.next = head;
        return ans;
    }
}
