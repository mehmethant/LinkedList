package LinkedList;

public class LinkedList {
    private Node head;

    public void append(int data) {

        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public Node returnHead() {
        return head;
    }

    public void prepend(int data) {
        Node nodeToBeAdded = new Node(data);
        nodeToBeAdded.next = head;
        head = nodeToBeAdded;
    }

    public void delete(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
    }

    public int get(int index) throws InvalidIndexException {


        if (index >= 0) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                if (current == null || current.next == null)
                    return Integer.MIN_VALUE;
                current = current.next;
            }
            return current.data;
        } else {
            throw new InvalidIndexException();
        }
    }

    public int getMid() {
        Node current1 = head;
        Node current2 = head;
        while (current1 != null && current1.next != null) {
            current1 = current1.next.next;
            current2 = current2.next;
        }
        return current2.data;
    }

    public int getHead() {
        if (head == null)
            return Integer.MIN_VALUE;
        return head.data;
    }

    public int getTail() {
        Node current = head;
        if (current != null) {
            while (current.next != null) {
                current = current.next;
            }
            return current.data;
        }
        else {
            throw new NullPointerException();
        }
    }

    int size() {
        Node current = head;
        int counter = 0;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }
}
