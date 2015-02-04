package LinkedList;

public class DoublyLinkedList {

    private int listSize = 0;
    private Node head = null;
    private Node tail = null;

    private class Node {
        Node next;
        Node previous;
        int data;

        public Node(int data) {
            next = null;
            previous = null;
            this.data = data;
        }
    }

    /**
     * Insert the node at a given index. Will do nothing if index is more than the list size.
     * The inserted node will be pointed to by the previous link of the current node at the given
     * index. This means the new node will be at the given index, and the previous node will be at index+1
     * @param index
     * @param data
     */
    public void insertAtIndex(int index, int data) {
        if (index <= listSize) {
            /* Get the current node at the given index */
            Node current;
            // Is index closer to tail or head?
            if (index > (listSize/2)) {
                current = tail;
                for (int i = listSize; i > index; i--)
                    current = current.previous;
            } else {
                current = head;
                for (int i = 1; i < index; i++)
                    current = current.next;
            }

            /* Insert new node */
            Node newNode = new Node(data);
            newNode.next = current;
            newNode.previous = current.previous;
            /* Update other nodes */
            current.previous.next = newNode;
            current.previous = newNode;
        }
    }

    /**
     * Insert node at the end of the list
     * @param data
     */
    public void insertAtEnd(int data) {
        if (listSize == 0)
            insertAtStart(data); // List is empty so just insert at the start
        else {
            tail.next = new Node(data);
            tail.next.previous = tail;
            tail = tail.next;
        }

        listSize++;
    }

    /**
     * Insert node at the start of the list
     * @param data
     */
    public void insertAtStart(int data) {
        if (listSize == 0)
            head = tail = new Node(data);
        else {
            Node previousHead = head;
            head = new Node(data);
            previousHead.previous = head;
            head.next = previousHead;
        }

        listSize++;
    }

    /**
     * Check if data is contained at least once within the list
     * @param data
     * @return true if data was found in the list
     */
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;

            current = current.next;
        }

        return false;
    }

    /**
     * Traverse entire list and delete any nodes containing the given data
     * @param data
     */
    public void deleteAll(int data) {
        if (head.data == data) {
            head = head.next;
            listSize--;
        }

        if (tail.data == data) {
            tail = tail.previous;
            listSize--;
        }

        if (head != null) {
            Node current = head.next;
            while (current != null && current != tail) {
                if (current.data == data) {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    listSize--;
                }
                current = current.next;
            }
        }
    }

    /**
     * Get the amount of nodes in the linked list
     * @return size of linked list
     */
    public int size() {
        return listSize;
    }

    public void print() {
        /* Print forwards */
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }

        System.out.println();

        /* Print backwards */
        Node current2 = tail;
        while (current2 != null) {
            System.out.print(current2.data + ", ");
            current2 = current2.previous;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtStart(2);
        doublyLinkedList.insertAtEnd(4);
        doublyLinkedList.insertAtStart(1);
        doublyLinkedList.insertAtEnd(5);
        doublyLinkedList.insertAtIndex(3, 3);
        doublyLinkedList.insertAtIndex(3, 3);
        doublyLinkedList.insertAtIndex(3, 3);
        doublyLinkedList.print();
    }
}
