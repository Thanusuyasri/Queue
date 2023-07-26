import java.util.Scanner;

class Node
{
    int value;
    Node next;
    Node(int value)
    {
        this.value = value;
    }
}
public class Queue {
    Node first;
    Node last;
    int length;
    Queue(int value)
    {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    void print()
    {
        Node temp = first;
        while(temp!=null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    void enqueue(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    Node dequeue()
    {
        if(length == 0)
        {
            return null;
        }
        Node temp = first;
        if(length == 1)
        {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements to push to end enter -1:");
        int num = scanner.nextInt();
        Queue queue = new Queue(num);
        num = scanner.nextInt();
        while (num!=-1)
        {
            queue.enqueue(num);
            num = scanner.nextInt();
        }
        int index,value;
        System.out.println("1-Enqueue\n2-Dequeue\n3-Print\n4-Exit");
        int choice = scanner.nextInt();
        while(choice!=4){
            switch(choice) {
                case 1:
                    System.out.println("Enter a value to push:");
                    value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    System.out.println("The  element is poped out:"+queue.dequeue().value);
                    break;
                case 3:
                    System.out.println("The element are:");
                    queue.print();
                    break;
                default:
                    System.out.println("Worng choice.");
            }
            System.out.println("1-Enqueue\n2-Dequeue\n3-Print\n4-Exit");
            choice = scanner.nextInt();
        }

    }
}
