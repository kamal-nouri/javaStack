public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.remove();
        sll.printValues();
        System.out.println("**");
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.add(9);
        sll.printValues();
        System.out.println("**");
        sll.remove();
        sll.printValues();
        System.out.println("**");
        sll.remove();
        sll.printValues();
        System.out.println("**");
        System.out.println(sll.find(10));
        System.out.println("**");
        sll.removeAt(1);
        sll.printValues();

    }
}