package linkedlist;

import lombok.Data;

@Data
public class MyLinkedList<E> {

    private Node<E> head;

    public E get(E element) {

        if (head != null) {
            if (head.element.equals(element)) {
                return head.element;
            }

            Node<E> temp = head;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
                if (temp.element.equals(element)) {
                    return temp.element;
                }
            }
        }
        return null;
    }

    public void add(E element) {
        Node<E> node = new Node<>(element, null);

        if (head == null) {
            head = node;
        } else {
            Node<E> temp = head;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = node;
        }
    }

    public void reverseList() {
        Node<E> current = head;
        Node<E> previous = null;
        Node<E> temp = null;

        while (current != null) {
            temp = current.nextNode;   // store temp item

            current.nextNode = previous;// swap nodes
            previous = current;         // increment also previous

            current = temp; // increment current
        }

        head = previous; // previous is the latest item where current is null
    }


    public void printList() {
        Node<E> temp = head;

        System.out.println("List: ");

        while (temp != null) {
            System.out.println(temp.element + " ");
            temp = temp.nextNode;
        }

        System.out.println();
    }

    @Data
    private static class Node<E> {
        private E element;
        private Node<E> nextNode;

        public Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }
    }
}
