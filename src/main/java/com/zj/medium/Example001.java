package com.zj.medium;


/**
 * @program algorithm
 * @description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: zhangbo
 * @create: 2020/11/23 11:07
 */
class One {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ret = new ListNode(0);
        int num = 0;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            num = n1 + n2 + carry;
            // 还原
            carry = 0;
            if (num % 10 > 0) {
                carry = num / 10;
                ret.val = num % 10;
            }

        }

        return ret;
    }


    public static void main(String[] args) {
        One one = new One();

    }


//    public ArrayList<Integer> addTwoNumbers(ArrayList<Integer> l1, ArrayList<Integer> l2) {
//
//        ArrayList<Integer> ret = new ArrayList<>();
//        if(l1.isEmpty()) {
//            return l2;
//        }
//
//        if(l2.isEmpty()) {
//            return l1;
//        }
//
//        if(l1.size() <= l2.size()){
//            for (int i = 0; i < l2.size(); i++) {
//                if(i > l1.size()){
//                    ret.add(l2.get(i));
//                    continue;
//                }
//                ret.add(l1.get(i) + l2.get(i));
//            }
//        }
//
//        if (l1.size() > l2.size()){
//            for (int i = 0; i < l1.size(); i++) {
//                if(i >= l2.size()){
//                    ret.add(l1.get(i));
//                    continue;
//                }
//                ret.add(l1.get(i) + l2.get(i));
//            }
//        }
//
//        return ret;
//    }


}


class ListNode {
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
