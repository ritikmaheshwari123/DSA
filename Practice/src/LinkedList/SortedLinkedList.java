package LinkedList;

public class SortedLinkedList {
    private SortedLinkedList.ListNode head;

    private static class ListNode{
        private int data;
        private SortedLinkedList.ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        SortedLinkedList.ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void removeDuplicates(){
        SortedLinkedList.ListNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void insertInSortedList(int value){
        SortedLinkedList.ListNode newNode = new SortedLinkedList.ListNode(value);
        if(head == null || value < head.data){
            newNode.next = head;
            head = newNode;
            return;
        }

        SortedLinkedList.ListNode current = head;
        while(current.next != null && current.next.data < value){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void main(String[] args) {
        SortedLinkedList sll = new SortedLinkedList();
        sll.head = new SortedLinkedList.ListNode(1);
        SortedLinkedList.ListNode second = new SortedLinkedList.ListNode(1);
        SortedLinkedList.ListNode third = new SortedLinkedList.ListNode(2);
        SortedLinkedList.ListNode fourth = new SortedLinkedList.ListNode(2);
        SortedLinkedList.ListNode fifth = new SortedLinkedList.ListNode(3);
        SortedLinkedList.ListNode sixth = new SortedLinkedList.ListNode(4);
        SortedLinkedList.ListNode seventh = new SortedLinkedList.ListNode(4);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        sll.display();
        sll.removeDuplicates();
        System.out.println("After removing duplicates:");
        sll.display();

        sll.insertInSortedList(2);
        System.out.println("After inserting 2:");
        sll.display();

        sll.insertInSortedList(8);
        System.out.println("After inserting 8:");
        sll.display();
    }
}
