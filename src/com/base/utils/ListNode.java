package com.base.utils;

/**
 * @Description ListNode
 * @Author Monster
 * @Date 2020/9/18 16:48
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) { this.val = val; }

    public static ListNode createNode(int[] arr) {
        int len = arr.length;
        if(len == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < len; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printNode(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println("null");
    }
}
