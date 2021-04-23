package com.jd.niuke;


/**
 * @author FM
 * @Description
 * @create 2020-10-10 22:56
 */
public class Solution {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        ListNode listNode = new Solution().ReverseList(l1);
        System.out.println(listNode.getVal());
    }

    public ListNode ReverseList(ListNode head) {
        if(head==null)return head;
        ListNode curr=head;
        ListNode before=null;
        while(curr.getNext()!=null){
            ListNode after = curr.getNext();
            curr.setNext(before);
            before=curr;
            curr=after;
        }
        curr.setNext(before);
        return curr;
    }

    // 输入一个链表，反转链表后，输出新链表的表头。
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        if (a[n - 1] < v) return n + 1;//如果数组最大值比v小，一定没有v值，则返回数组长度+1
        int start = 0;//开启索引
        int end = n - 1;//结束索引
        int mid = 0;//中间索引
        int result = -1;
        while (start <= end) {//跳出条件
            mid = (start + end) / 2;//中间位置索引
            if (a[mid] < v) {
                start = mid + 1;
            }
            if (a[mid] >= v) {
                result = mid;
                end = mid - 1;
            }
        }
        return result + 1;
    }


}
