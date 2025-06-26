

public class Basics{
    public static void main(String[] args) {
        Linkedlists ll = new Linkedlists();
        ll.add(6);ll.add(4);ll.add(5);ll.add(8);ll.add(7);ll.add(4);ll.add(55);ll.add(88);
        ll.printList();
        ll.insert(9,4);
        ll.printList();
        ll.delete(4);
        ll.printList();
        ll.add(45);
        ll.add(88);
        System.out.println("size:"+ll.size());
    }
}
class node {
    int val;
    node next;
    //constructor
    node(int val) {
        this.val = val;
    }
}
class Linkedlists {
    static node head;
    //static keyword is used for calling method of a class without making an object of that class.
    //You can call it like ClassName.methodName()
    //You cannot access non-static (object-specific) variables or methods from inside a static method unless you create an object.
    // static variable like college is shared by all objects of the class — all instances refer to the same memory for that variable
    //adding elements
    public void add(int val) {
        node new_node = new node(val);
        if (Linkedlists.head == null) {
            //empty LinkedList
            head = new_node;
        } else {
            //non-empty LinkedList
            //the pointer 'last' will go to the last node of LL without disturbing 'head'
            node last = head;
            while(last.next != null) {
                last = last.next;
            }
            //'last' is now at the last node
            last.next = new_node;
        }
    }
    //printing lists
    void printList(){
        node last = head;
        while (last != null) {
            System.out.print(last.val+"->");
            last = last.next;
        }
        System.out.print("null");
        System.out.println();
    }
    //finding size
    int size() {
        node last = head;
        int size = 1;
        while(last.next != null) {last = last.next; size++;}
        return size;
    }
    //deleting last element(node)
    void delete() {
        node empty = null;
        //unless not specified, delete the last node
        if (head == null) {
            System.out.println("linked list is empty");
        } else {
            node last = head;
            while (last.next.next != null) {
                //last.next.next will go check the parso wala node.
                last = last.next;
            }
            last.next = null;
        }
    }
    //deleting specified node
    void delete(int pos) {
        //the key should be start from 0
        //deleting the node with specified position
        if (pos > size() && pos <0){
            //checking the invalid key
            System.out.println("Invalid key");
            return;
        }
        if (head == null) {
            //for the empty LinkedList
            System.out.println("LinkedList is empty");
            return;
        }
        if (pos == 0){
            //for the first node
            head = head.next;
            return;
        }
        node prev = head;
        node target = head;
        //will iterate till target comes to the specified node and prev will be just before that
        for (int i = 0; i < pos; i++){
            prev = target;
            target = target.next;
        }
        prev.next = target.next;
        target = null;
    }
    //deleting the 1st occurrence of the specified key
    void delFirstOccur(int key) {
        node curr = head;
        node prev = head;
        int ptr = 0;
        while (curr.val != key) {
            prev = curr;
            curr = curr.next;
            ptr++;
            if(curr == null){
                System.out.println("not in the LinkedList");
                return;
            }
        }
        if (ptr == 0) {
            head = head.next;
        }else{
            prev.next = curr.next;
        }
    }
    //inserting elements at a specific position
    void insert(int val, int pos){
        node new_node = new node(val);
        //position should be normal(starting from 0)
        if (pos > size()) {
            System.out.println("Invalid position");
            return;
        }
        //adding the element at starting(head)
        if (pos == 0) {
            new_node.next = head;
            head = new_node;
        }else {//adding element other than pos - 1
            node last = head;
            node prev = head;
            for (int i = 0; i < pos; i++) {
                prev = last;
                last = last.next;
            }
            prev.next = new_node;
            new_node.next = last;
        }
    }
}