package LinkedList;

public class SinglyLinkedList {

    private Node head;
    private int listSize;

    public SinglyLinkedList() {
        head = null;
        listSize = 0;
    }

    private static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * Insert node at the start of the list
     */
    public void insertAtStart(int data) {
        if(head == null)
            head = new Node(data);

        else {
            Node previousHead = head;
            head = new Node(data);
            head.next = previousHead;
        }
        listSize++;
    }

    /**
     * Insert node at the end of the list
     */
    public void insertAtEnd(int data) {
        if(head == null)
            head = new Node(data);

        else {
            // This could be made a lot quicker by keeping track of the last node in the list
            // See: DoublyLinkedList implementation
            Node current = head;
            while(current.next != null)
                current = current.next;
            current.next = new Node(data);
        }
        listSize++;
    }

    /**
     * Size of the list
     */
    public int size() {
        return listSize;
    }

    /**
     * Check if data is in the list
     */
    public boolean contains(int data) {
        Node current = head;
        while(current != null) {
            if (current.data == data)
                return true;

            current = current.next;
        }
        return false;
    }

    /**
     * Delete data if it is contained in the list
     */
    public void delete(int data) {
        if(head.data == data) {
            head = head.next;
            listSize--;
        }

        else {
            Node current = head;
            while(current.next != null) {
                if(current.next.data == data) {
                    current.next = current.next.next;
                    listSize--;
                    break;
                }
                current = current.next;
            }
        }
    }

    public void print() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtStart(2);
        list.insertAtStart(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtStart(1);
        list.print();
    }
}
