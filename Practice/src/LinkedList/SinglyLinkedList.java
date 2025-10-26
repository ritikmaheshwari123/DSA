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
            while(count < position - 1 && current.next != null){
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteFirst(){
        if(head == null){
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        ListNode current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
    }

    public void deleteAtPosition(int position){
        if(head == null){
            return;
        }
        if(position == 1){
            head = head.next;
            return;
        }
        ListNode current = head;
        int count = 1;
        while(count < position - 1 && current.next != null){
            current = current.next;
            count++;
        }
        if(current.next != null){
            current.next = current.next.next;
        }
    }

    public boolean search(int key){
        ListNode current = head;
        while(current != null){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverse(){
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public int getMiddleNode() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer.data;
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

        int position = 3;
        sll.insertAtPosition(15, position);
        sll.display();
        System.out.println("Length of linked list after insertion at " + position + " : " + sll.length());

        sll.deleteFirst();
        sll.display();
        System.out.println("Length of linked list after deleting first node: " + sll.length());

        sll.deleteLast();
        sll.display();
        System.out.println("Length of linked list after deleting last node: " + sll.length());

        position = 2;
        sll.deleteAtPosition(position);
        sll.display();
        System.out.println("Length of linked list after deleting node at position " + position + " : " + sll.length());

        int key = 8;
        System.out.println("Searching for " + key + ": " + sll.search(key));

        sll.reverse();
        System.out.println("Reversed linked list:");
        sll.display();

        System.out.println("Middle node of the linked list: " + sll.getMiddleNode());

    }
}
