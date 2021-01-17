public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public Node remove() {
        if (head == null) {
            return null;
        } else if (this.head.next == null) {
            Node node = this.head;
            this.head = null;
            return node;
        } else {
            Node node = this.head;
            while (node.next.next != null) {
                node = node.next;
            }
            Node temp = node.next;
            node.next = null;

            return temp;
        }
    }

    public void printValues() {
        if (head == null) {
            System.out.println("there is no node to print!");
        } else {
            Node runner = head;
            while (runner != null) {
                System.out.println(runner.value);
                runner = runner.next;
            }
        }
    }

    public int find(int Inputvalue) {
        Node runner = this.head;
        while (runner.value != Inputvalue) {
            runner = runner.next;
        }
        return runner.value;
    }

    public void removeAt(int index) {
        Node runner = this.head;
        if (head == null) {
            System.out.println("there is no node to remove!");
        } else if (index == 0) {
            this.head = runner.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                runner = runner.next;
            }
            runner.next = runner.next.next;
        }
    }
}