package LinkedList;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(){
        if(head==null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertAtBeginning(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtPosition(int data, int position){
        ListNode newNode = new ListNode(data);
        if(position == 1){
            newNode.next = head;
            head = newNode;
        } else {
            ListNode current = head;
            int count = 1;
            while(count < position - 1 ){
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        sll.display();
        System.out.println("Length of linked list: " + sll.length());

        sll.insertAtBeginning(5);
        sll.display();
        System.out.println("Length of linked list after insertion at beginning: " + sll.length());

        sll.insertAtEnd(20);
        sll.display();
        System.out.println("Length of linked list after insertion at end: " + sll.length());

        sll.insertAtPosition(15, 7);
        sll.display();
        System.out.println("Length of linked list after insertion at position: " + sll.length());
    }
}
