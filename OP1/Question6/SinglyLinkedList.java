import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;

/** 
 *  Ver 1.0:  Linked List (recursive and nonrecursive functions for the following tasks:)
 *  a)Reverse the linked list
 *  b) Print Linked List in Reverse Order
 *  Issues: Reverse using Recursion is not printing Properly.
 *  
 *  
 */

public class SinglyLinkedList<T> implements Iterable<T> {

    /** Class Entry holds a single node of the list */
    public class Entry<T> {
        T element;
        Entry<T> next;

        Entry(T x, Entry<T> nxt) {
            element = x;
            next = nxt;
        }
    }

    // Dummy header is used.  tail stores reference of tail element of list
    Entry<T> header, tail;
    int size;

    SinglyLinkedList() {
        header = new Entry<>(null, null);
        tail = header;
        size = 0;
    }

    public Iterator<T> iterator() { return new SLLIterator<>(header); }

    private class SLLIterator<E> implements Iterator<E> {
	Entry<E> cursor, prev;
	boolean ready;  // is item ready to be removed?

	SLLIterator(Entry<E> head) {
	    cursor = head;
	    prev = null;
	    ready = false;
	}

	public boolean hasNext() {
	    return cursor.next != null;
	}
	
	public E next() {
	    prev = cursor;
	    cursor = cursor.next;
	    ready = true;
	    return cursor.element;
	}

	// Removes the current element (retrieved by the most recent next())
	// Remove can be called only if next has been called and the element has not been removed
	public void remove() {
	    if(!ready) {
		throw new NoSuchElementException();
	    }
	    prev.next = cursor.next;
	    cursor = prev;
	    ready = false;  // Calling remove again without calling next will result in exception thrown
	    size--;
	}
    }

    // Add new elements to the end of the list
    void add(T x) {
	tail.next = new Entry<>(x, null);
	tail = tail.next;
	size++;
    }
    void reverseIterative(){
    	//Method for reversing the Linked List using Iteration.
    	Entry<T> current = header.next;
    	Entry<T> prev = null;
    	Entry<T> next;
    	while(current!=null){
    		next=current.next;
    		current.next=prev;
    		prev=current;
    		current=next;
    	}
    	header.next=prev;
    }
    
   
    void reverseRecursion(Entry<T> p){
    	//Method for reversing the Linked List using Recursion.
    	if(p.next==null){
    		//System.out.print(p.element+" ");
    		
    		header=p;
    		return;
    	}
    	
    	reverseRecursion(p.next);
    	Entry<T> q=p.next;
    	q.next=p;
    	p.next=null;
    	
    }
    
    void reversePrintRecursion(Entry<T> p){
    	//Method for printing the Linked List in reverse order using Recursion.
    	if(p==null){
    		
    		return;
    	}
    	this.reversePrintRecursion(p.next);
    	System.out.print(p.element+" ");
    	
    }
    void reversePrintIteration(Entry<T> p){
    	Entry<T> tail=this.tail;
      	 Entry<T> current=this.header;
      	 while(current.next!=tail)
      	 {
      		 current=current.next;                //traverse till the tail and print tail
      		 if(current.next.equals(tail))
      		 {
      			 System.out.print(current.next.element+" ");
      			 tail=current;                      // reset tail to prev before tail
      			 current=this.header;           //traverse from starting 
      		 }
      	 }
      	 if(current==this.header)              //for the header element
      	 {                                      //where while fails we will print next element
      		 System.out.print(current.next.element+" ");
      		 
      	 }
    }
    void printList() {
	/* Code without using implicit iterator in for each loop:

        Entry<T> x = header.next;
        while(x != null) {
            System.out.print(x.element + " ");
            x = x.next;
        }
	*/

	System.out.print(this.size + ": ");
	for(T item: this) {
	    System.out.print(item + " ");
	}

	System.out.println();
    }

    // Rearrange the elements of the list by linking the elements at even index
    // followed by the elements at odd index. Implemented by rearranging pointers
    // of existing elements without allocating any new elements.
    void unzip() {
	if(size < 3) {  // Too few elements.  No change.
	    return;
	}

	Entry<T> tail0 = header.next;
	Entry<T> head1 = tail0.next;
	Entry<T> tail1 = head1;
	Entry<T> c = tail1.next;
	int state = 0;

	// Invariant: tail0 is the tail of the chain of elements with even index.
	// tail1 is the tail of odd index chain.
	// c is current element to be processed.
	// state indicates the state of the finite state machine
	// state = i indicates that the current element is added after taili (i=0,1).
	while(c != null) {
	    if(state == 0) {
		tail0.next = c;
		tail0 = c;
		c = c.next;
	    } else {
		tail1.next = c;
		tail1 = c;
		c = c.next;
	    }
	    state = 1 - state;
	}
	tail0.next = head1;
	tail1.next = null;
    }

    public static void main(String[] args) throws NoSuchElementException {
        int n = 10;
        if(args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        SinglyLinkedList<Integer> lst = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> two = new SinglyLinkedList<>();
        for(int i=1; i<=n; i++) {
            lst.add(new Integer(i));
        }
        for(int i=1; i<=n; i++) {
            two.add(new Integer(i));
        }
        lst.printList();

	Iterator<Integer> it = lst.iterator();
	Scanner in = new Scanner(System.in);
	whileloop:
	while(it.hasNext() && in.hasNext()) {
	    int com = in.nextInt();
	    switch(com) {
	    case 1:  // Move to next element and print it
		Integer x = it.next();
		System.out.println(x);
		break;
	    case 2:  // Remove element
		it.remove();
		lst.printList();
		break;
	    default:  // Exit loop
		 break whileloop;
	    }
	}
	System.out.println("List printed in Reverse Order Using Recursion:");
	lst.reversePrintRecursion(lst.header.next);
	System.out.println();
	System.out.println("List printed in Reverse Order Using Iteration:");
	lst.reversePrintIteration(lst.header.next);
	
	System.out.println();
	System.out.println("Reverse using Iteration.");
	lst.reverseIterative();
	lst.printList(); 
	System.out.println("Reverse using Recursion.");
	two.reverseRecursion(two.header.next);
	two.printList();
	
        
    }
}

/* Sample input:
   1 2 1 2 1 1 1 2 1 1 2 0
   Sample output:
10: 1 2 3 4 5 6 7 8 9 10 
1
9: 2 3 4 5 6 7 8 9 10 
2
8: 3 4 5 6 7 8 9 10 
3
4
5
7: 3 4 6 7 8 9 10 
6
7
6: 3 4 6 8 9 10 
6: 3 4 6 8 9 10 
6: 3 6 9 4 8 10
*/