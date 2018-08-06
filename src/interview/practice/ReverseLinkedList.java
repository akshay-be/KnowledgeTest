package interview.practice;

/**
 * 
 * @author eshak01
 *
 */
public class ReverseLinkedList {

   public static void main(String[] args) {
      LinkedList linkedList = new LinkedList();
      linkedList.insert(5);
      linkedList.insert(4);
      linkedList.insert(3);
      linkedList.insert(2);
      linkedList.insert(1);

      linkedList.printAll();
      
      linkedList.reverse();
   }

}

class LinkedList {

   Node head;

   Node current;

   void insert(int data) {
      Node node = new Node(data);
      if (head == null) {
         head = node;
      } else {
         node.previous = current;
         current.next = node;
      }
      current = node;

   }

   public void reverse() {
      // TODO Auto-generated method stub
      
   }

   public void printAll() {
      Node temp = head;
      while (temp != null) {
         System.out.println(temp.data);
         temp = temp.next;
      }
   }
}

class Node {
   Node previous;
   int data;
   Node next;

   Node() {
   }

   Node(int data) {
      this.data = data;
   }
}
