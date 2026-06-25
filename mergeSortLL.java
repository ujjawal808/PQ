import java.util.*;
public class mergeSortLL {
    public static class Node{
        int data; 
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next; 
            fast=fast.next.next;
        }
        return slow;//mid node


    }
    public Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
       while(head1!=null && head2!=null){
        if(head1.data<=head2.data){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;

        }
        else{
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
       }
    //    for remaining nodes
    while(head1!=null){
        temp.next=head1;
        head1=head1.next;
        temp=temp.next;

    }
     while(head2!=null){
        temp.next=head2;
        head2=head2.next;
        temp=temp.next;

    }
    return mergedLL.next;//to skip -1. that's why we have used next;

        
    } 
    
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        // Divide 
        Node mid=getMid(head);
        // mergeLeft ,mergeRight method
        Node rightHead=mid.next;
        mid.next=null;
        Node newleft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        // merge
        return merge(newleft,newRight);
        

    }
    public void print(Node head){
        if(head==null){
            System.out.println("LL is Empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

        public static void main(String args[]){
        mergeSortLL ll = new mergeSortLL();
        head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println("Original List:");
        ll.print(head);

        head = ll.mergeSort(head);

        System.out.println("Sorted List:");
        ll.print(head);
    }
    
}
