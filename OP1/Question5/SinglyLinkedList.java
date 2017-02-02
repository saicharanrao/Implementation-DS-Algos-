package delete;
/** @author rbk
 *  Singly linked list: for instructional purposes only
 *  Ver 1.0: initial description.
 *  Ver 1.1: added iterator: 2016/8/30.
 *  Ver 1.2: simplified the code of add by starting with tail=header instead of null: 2016/9/2
 *  Ver 1.3: corrected errors in remove and changed main:  2016/10/17
 */

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;

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
       /* for(int i=1; i<=n; i++) {
            lst.add(new Integer(i));
        }*/
        
        Random rand = new Random();
		double d;
        int in;
		
		//Passing Values into them
		for(int i=1;i<6;i++){
			d =   Math.random()*20;
            in = (int) d;
			lst.add(in);
		}
        lst.printList();

	/*Iterator<Integer> it = lst.iterator();
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
	}*/
	//lst.printList();
	//lst.unzip();
    //    lst.printList();
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